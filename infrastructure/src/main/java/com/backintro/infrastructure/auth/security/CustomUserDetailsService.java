package com.backintro.infrastructure.auth.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.backintro.domain.auth.model.valueobject.Email;
import com.backintro.domain.auth.port.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            Email email = Email.of(username);
            return userRepository.findByEmail(email)
                    .map(SecurityUser::new)
                    .orElseThrow(() -> new UsernameNotFoundException("User not found with email: " + username));
        } catch (IllegalArgumentException e) {
            throw new UsernameNotFoundException("Invalid email format: " + username, e);
        }
    }
}
