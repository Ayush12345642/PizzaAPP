package com.example.UserAuthenticationService.Proxy;


import com.example.UserAuthenticationService.Domain.UserData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name="pizza-service", url="localhost:5555")
public interface UserProxy {
    @PostMapping("/pizza-app-v1/add-user")
    public  ResponseEntity<?> addUser(@RequestBody UserData userDTO);
}

