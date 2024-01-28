package com.apps.archiver.dto;

import jakarta.validation.constraints.NotNull;

import java.util.List;

public class SignUpDTO {
    @NotNull(message = "Username field is required!")
    private String username;

    @NotNull(message = "Password field is required!")
    private String password;

    @NotNull(message = "Email field is required!")
    private String email;

    @NotNull(message = "Full name field is required!")
    private String fullName;

    @NotNull(message = "Roles field is required!")
    private List<String> roles;

    public SignUpDTO(String username, String password, String email, String fullName) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.fullName = fullName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }
}
