package com.example.UserPizzaService.Domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Document
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Pizza {
    @Id
 private String pizzaId;
    private String pizzaName;
    private int price;
    private String pizzaType;
    private int quantity;
    private byte[] img;
}
