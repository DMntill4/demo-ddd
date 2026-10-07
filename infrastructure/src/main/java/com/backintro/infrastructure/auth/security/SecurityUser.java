package com.backintro.infrastructure.auth.security;

import java.util.Collection;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.backintro.domain.auth.model.aggregate.User;
import com.backintro.domain.auth.model.entity.Role;

public class SecurityUser implements UserDetails {

    private final UUID id;
    private final String email;
    private final String password;
    private final boolean active;
    private final boolean locked;
    private final Set<GrantedAuthority> authorities;

    public SecurityUser(User user) {
        this.id = user.getId().value();
        this.email = user.getEmail().value();
        this.password = user.getPasswordHash().value();
        this.active = user.isActive();
        this.locked = user.isLocked();
        this.authorities = user.getRoles().stream()
                .map(Role::getName)
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toSet());
    }

    public UUID getId() {
        return id;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !locked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return active;
    }
}
