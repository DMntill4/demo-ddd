package com.backintro.domain.auth.port.security;

import java.util.Set;
import java.util.UUID;

public interface TokenProviderPort {
    String generateAccessToken(UUID userId, String email, Set<String> roles);
    String generateRefreshToken(UUID userId, String email);
    String extractEmail(String token);
    boolean validateToken(String token);
}
