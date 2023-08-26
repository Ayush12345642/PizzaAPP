package com.example.UserPizzaService.Service;

import com.example.UserPizzaService.Domain.Pizza;
import com.example.UserPizzaService.Domain.User;

import java.util.List;

public interface UserService {
    public  User addUser(User user);
    public  List<User> getAllUser();
    public  User getUserByEmailAndPassword(String email,String password);
    public  User savePizzaToUserList(Pizza pizza, String email);
    public User deleteFromPizzaId(String pizzaName,User user);


}
