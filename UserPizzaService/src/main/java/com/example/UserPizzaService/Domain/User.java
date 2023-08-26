package com.example.UserPizzaService.Domain;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;
@Document
@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {
    @Id
    private String emailId;
    private String password;
    private String mobileNo,address;
    private List<Pizza> pizzaList;
}
