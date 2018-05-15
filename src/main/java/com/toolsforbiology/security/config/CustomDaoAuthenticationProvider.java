package com.toolsforbiology.security.config;

import com.toolsforbiology.application.services.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;

public class CustomDaoAuthenticationProvider extends DaoAuthenticationProvider {

    @Autowired
    private UserService userService;

    @Override
    protected void additionalAuthenticationChecks(UserDetails userDetails,
                                                  UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {

        if (StringUtils.isBlank(userDetails.getPassword())) {
            throw new BadCredentialsException(messages.getMessage("message.login.password.reinit"));
        }

		/*String message = gererBlocageTemporel(authentication);

		if (StringUtils.isNotEmpty(message)) {
			throw new BadCredentialsException(messages.getMessage(message));
		}*/

        Object salt = null;

        if (super.getSaltSource() != null) {
            salt = super.getSaltSource().getSalt(userDetails);
        }

        if (authentication.getCredentials() == null) {
            logger.debug("Authentication failed: no credentials provided");
            /*message = gererBlocage(authentication);
			if (StringUtils.isNotEmpty(message)) {
				throw new BadCredentialsException(messages.getMessage(message));
			}*/
            throw new BadCredentialsException(messages.getMessage("message.login.password"));
        }

        String presentedPassword = authentication.getCredentials().toString();

        if (!super.getPasswordEncoder().isPasswordValid(userDetails.getPassword(), presentedPassword, salt)) {
            logger.debug("Authentication failed: password does not match stored value");
			/*message = gererBlocage(authentication);
			if (StringUtils.isNotEmpty(message)) {
				throw new BadCredentialsException(messages.getMessage(message));
			}*/
            throw new BadCredentialsException(messages.getMessage("message.login.password"));
        }

		/*gererDeblocage(authentication);*/
    }

	/*private String gererBlocage(UsernamePasswordAuthenticationToken authentication) {
		return userService.gererBlocage(authentication);
	}

	private String gererBlocageTemporel(UsernamePasswordAuthenticationToken authentication) {
		return userService.gererBlocageTemporel(authentication);
	}

	private void gererDeblocage(UsernamePasswordAuthenticationToken authentication) {
		userService.gererDeblocage(authentication);
	}*/
}
