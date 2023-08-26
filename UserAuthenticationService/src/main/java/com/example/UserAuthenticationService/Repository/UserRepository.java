package com.example.UserAuthenticationService.Repository;

import com.example.UserAuthenticationService.Domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,String> {
    public abstract User findByEmailIdAndPassword(String emailId,String password);
}
