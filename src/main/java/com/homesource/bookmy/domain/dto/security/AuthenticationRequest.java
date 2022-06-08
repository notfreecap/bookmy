package com.homesource.bookmy.domain.dto.security;

import lombok.Data;

@Data
public class AuthenticationRequest {
    private String user;
    private String password;
}
