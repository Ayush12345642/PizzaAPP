package com.example.UserAuthenticationService.Service;

import com.example.UserAuthenticationService.Domain.User;

import java.util.Map;

public interface SecurityTokenGenerator {
    public abstract Map<String,String> generateToken(User user);
}
