package com.toolsforbiology.security.model;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by pascalbardeau on 25/10/2017.
 */

@Data
@NoArgsConstructor
public class UserTokenState {
    private String accessToken;
    private Long expiresIn;
    private String refreshToken;
    private Long refreshExpiresIn;
}
