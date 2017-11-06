package com.toolsforbiology.security;

import com.toolsforbiology.application.exceptions.TechnicalException;
import com.toolsforbiology.security.model.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.apache.commons.codec.binary.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Component
public class TokenHelper {


    @Value("${app.name}")
    private String appName;

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expires_in}")
    private int expiresIn;

    @Value("${jwt.change.password.expires_in}")
    private int changePasswordExpiresIn;

    @Value("${jwt.refresh.expires_in}")
    private int refreshExpiresIn;

    @Value("${jwt.header}")
    private String authentHeader;


    private SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS512;

    public String getUsernameFromToken(String token) {
        String username;
        try {
            final Claims claims = this.getClaimsFromToken(token);
            username = claims.getSubject();
        } catch (TechnicalException te) {
            throw te;
        }
        return username;
    }

    public Long getIdFromToken(String token) {
        Long id;
        try {
            final Claims claims = this.getClaimsFromToken(token);
            id = Long.valueOf(((Number) claims.get("id")).longValue());
        } catch (TechnicalException te) {
            throw te;
        }
        return id;
    }

    public List<String> getScopesFromToken(String token) {
        // scopes represent what access are available for the user
        List<String> scopes;
        try {
            final Claims claims = this.getClaimsFromToken(token);
            scopes = (List<String>) claims.get("scopes");
        } catch (TechnicalException te) {
            throw te;
        }
        return scopes;
    }

    private Claims getClaimsFromToken(String token) {
        Claims claims;
        try {
            claims = Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token).getBody();
        } catch (TechnicalException te) {
            throw te;
        }
        return claims;
    }

    String generateToken(Map<String, Object> claims, int expiration) {
        return Jwts.builder().setClaims(claims).setExpiration(generateExpirationDate(expiration))
                .signWith(signatureAlgorithm, secret).compact();
    }

    public String generateToken(User user) {
        Claims claims = generateRefreshToken(user, user.getAuthorities().stream()
                .map(s -> s.getAuthority().toString()).collect(Collectors.toList()));
        return generateToken(claims, this.expiresIn);
    }

    public String generateResetPasswordToken(User user) {
        Claims claims = generateRefreshToken(user, Arrays.asList("ROLE_CHANGE_PASSWORD_PRIVILEGE"));
        return generateToken(claims, this.changePasswordExpiresIn);
    }

    public String generateRefreshToken(User user) {
        Claims claims = generateRefreshToken(user, Arrays.asList("ROLE_REFRESH"));
        return generateToken(claims, this.refreshExpiresIn);
    }

    private Claims generateRefreshToken(User user, List<String> roles) {

        Claims claims = Jwts.claims().setSubject(user.getUsername());
        claims.put("scopes", roles);
        claims.put("id", user.getId());
        claims.setIssuer(appName);

        return claims;
    }

    private long getCurrentTimeMillis() {
        Date date = new Date();
        return date.getTime();
    }

    private Date generateCurrentDate() {
        return new Date(getCurrentTimeMillis());
    }

    private Date generateExpirationDate(int expire) {
        return new Date(getCurrentTimeMillis() + expire * 1000);
    }

    public Boolean canTokenBeRefreshed(String token) {
        final Date expirationDate = getClaimsFromToken(token).getExpiration();
        return expirationDate.compareTo(generateCurrentDate()) > 0;
    }

    public String getToken(HttpServletRequest request) {
        /**
         * Getting the token from Authentication header e.g Bearer your_token
         */
        String authHeader = request.getHeader(authentHeader);
        if (authHeader != null && authHeader.startsWith("Bearer ")) {

            String bearer = authHeader.substring(7);
            if (bearer != null && !StringUtils.equals("null", bearer)) {
                return bearer;
            }
        }
        return null;
    }
}
