package com.example.UserAuthenticationService.Domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserData {
    private String email,userName,mobileNo,address;

}
