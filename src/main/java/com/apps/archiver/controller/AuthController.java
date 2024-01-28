package com.apps.archiver.controller;

import com.apps.archiver.dto.LoginDTO;
import com.apps.archiver.dto.SignUpDTO;
import com.apps.archiver.model.User;
import com.apps.archiver.service.AuthService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/auth")
public class AuthController {

    private final AuthService authService;

    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @RequestMapping(method = RequestMethod.POST, path = "/signup")
    public ResponseEntity<String> signup(@Valid @RequestBody SignUpDTO request){
        authService.createUser(request);
        return new ResponseEntity<>("User created successfully!", HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.POST, path = "/login")
    public ResponseEntity<String> login(@Valid @RequestBody LoginDTO request){
        return new ResponseEntity<>("User logged in successfully!", HttpStatus.OK);
    }

}
