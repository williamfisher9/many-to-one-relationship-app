package com.apps.archiver.service;

import com.apps.archiver.dto.SignUpDTO;
import com.apps.archiver.model.User;
import org.springframework.http.ResponseEntity;

public interface AuthService {
    void createUser(SignUpDTO request);
}
