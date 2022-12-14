package com.techeer.cokkiri.global.util;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
public class PasswordUtil {
    private final PasswordEncoder passwordEncoder;
    public String encodingPassword(String password) {
        return passwordEncoder.encode(password);
    }

    public boolean isSamePassword(String rowPassword, String encryptPassword) {
        return passwordEncoder.matches(rowPassword, encryptPassword);
    }
}
