package com.example.UserPizzaService.Service;

import com.example.UserPizzaService.Domain.Pizza;

import java.util.List;

public interface OrderService {
    public  Pizza registerPizza(Pizza pizza,byte[] bytes);
    public  List<Pizza> getAllPizzaDetails();
    public  boolean deletByPizzaId(String pizzaId);
    public  Pizza updatePizza(Pizza pizza);
    public  Pizza getPizzaById(String pizzaId);
}
