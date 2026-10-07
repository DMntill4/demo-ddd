package com.backintro.application.auth.dto;

import java.util.Set;

public record AuthTokenResponse(
        String accessToken,
        String refreshToken,
        String tokenType,
        long expiresIn,
        String email,
        Set<String> roles
) {
    public static AuthTokenResponse of(
            String accessToken,
            String refreshToken,
            long expiresIn,
            String email,
            Set<String> roles
    ) {
        return new AuthTokenResponse(accessToken, refreshToken, "Bearer", expiresIn, email, roles);
    }
}
