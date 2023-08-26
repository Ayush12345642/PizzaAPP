package com.example.UserAuthenticationService.Service;

import com.example.UserAuthenticationService.Domain.SignupData;
import com.example.UserAuthenticationService.Domain.User;

public interface UserService {
    public  User register1(SignupData signupData);
    public  User register(User user);
    public  User loginCheck(User user);

}
