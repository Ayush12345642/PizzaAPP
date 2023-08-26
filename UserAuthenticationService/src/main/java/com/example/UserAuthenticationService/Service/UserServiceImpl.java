package com.example.UserAuthenticationService.Service;

import com.example.UserAuthenticationService.Domain.SignupData;
import com.example.UserAuthenticationService.Domain.User;
import com.example.UserAuthenticationService.Domain.UserData;
import com.example.UserAuthenticationService.Proxy.UserProxy;
import com.example.UserAuthenticationService.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
   @Autowired
  private UserProxy userProxy;

    @Override
    public User register1(SignupData signupData) {
        UserData userData=new UserData(signupData.getEmail(),signupData.getUserName(),signupData.getMobileNo(),signupData.getAddress());
       ResponseEntity response = userProxy.addUser(userData);
        User user=new User(signupData.getEmail(), signupData.getPassword(), "ROLE_USER");
        User user1=userRepository.save(user);
        return user1;
    }

    @Override
    public User register(User user) {

        return userRepository.save(user);
    }

    @Override
    public User loginCheck(User user) {
        if (userRepository.findById(user.getEmailId()).isPresent()) {
            User result = userRepository.findById(user.getEmailId()).get();
            if (result.getPassword().equals(user.getPassword())) {
                return result;
            } else {
                return null;
            }
        } else {
            return null;
        }
    }
}
