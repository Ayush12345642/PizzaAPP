package com.example.UserPizzaService.Repository;

import com.example.UserPizzaService.Domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User,String> {
    public  User findByEmailIdAndPassword(String emailId,String password);
    public User findByEmailId(String email);
    User findByAddress(String address);

}
