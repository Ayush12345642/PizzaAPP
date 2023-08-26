package com.example.UserPizzaService.Service;

import com.example.UserPizzaService.Domain.Pizza;
import com.example.UserPizzaService.Domain.User;
import com.example.UserPizzaService.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User addUser(User user) {
        return userRepository.insert(user);
    }

    @Override
    public List<User> getAllUser() {

        return userRepository.findAll();
    }

    @Override
    public User getUserByEmailAndPassword(String email, String password) {
        return userRepository.findByEmailIdAndPassword(email,password);
    }

    @Override
    public User savePizzaToUserList(Pizza pizza, String email) {
        User user=userRepository.findById(email).get();
        user.getPizzaList().add(pizza);
        return userRepository.save(user);
    }
    public User deleteFromPizzaId(String pizzaName,User user)
    {
       Optional optional=userRepository.findById(user.getAddress());
        if(optional.isPresent()){
          user.getPizzaList().removeIf(a->a.getPizzaName().equals(pizzaName));
        }
       return userRepository.save(user);

    }
}
