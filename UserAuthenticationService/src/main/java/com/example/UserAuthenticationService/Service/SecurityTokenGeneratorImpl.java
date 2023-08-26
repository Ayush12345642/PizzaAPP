package com.example.UserAuthenticationService.Service;

import com.example.UserAuthenticationService.Domain.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class SecurityTokenGeneratorImpl implements SecurityTokenGenerator {
    @Override
    public Map<String, String> generateToken(User user) {
        Map<String, String> result = new HashMap<String, String>();
        user.setPassword("");
        Map<String, Object> userdata = new HashMap<>();
        userdata.put("user_role", user.getRole());
        userdata.put("user_email", user.getEmailId());
        String jwt = Jwts.builder()
                .setClaims(userdata)
                .setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS256, "mysecretkey")
                .compact();
        result.put("token", jwt);
        result.put("message", "User login success");
        result.put("role", user.getRole());
        result.put("emailId",user.getEmailId());
        return result;
    }
}
