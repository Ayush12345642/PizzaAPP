package com.example.UserAuthenticationService.Domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignupData {
    private String email,userName,mobileNo,address,password;;
}
