package com.example.UserAuthenticationService.Controller;

import com.example.UserAuthenticationService.Domain.SignupData;
import com.example.UserAuthenticationService.Domain.User;
import com.example.UserAuthenticationService.Service.SecurityTokenGenerator;
import com.example.UserAuthenticationService.Service.UserService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/auth-app-v1")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private SecurityTokenGenerator securityTokenGenerator;
 @PostMapping("/register-user1")
    public ResponseEntity<?> registerUser1(@RequestBody SignupData signupData)
 {
  return new ResponseEntity<>(userService.register1(signupData), HttpStatus.OK);
 }
 @PostMapping("/register-user")
    public ResponseEntity<?> registerUser(@RequestBody  User user)
 {
   user.setRole("ROLE_USER");
   return new ResponseEntity<>(userService.register(user),HttpStatus.OK);
 }
 @PostMapping("/login-check")
    public ResponseEntity<?> loginCheck(@RequestBody User user)
 {
      User result=userService.loginCheck(user);
     if(result!=null)
     {
        return new ResponseEntity<>(securityTokenGenerator.generateToken(result),HttpStatus.OK);
     }else{
         return new ResponseEntity<>("Authentication failed", HttpStatus.OK);
     }
 }
}
