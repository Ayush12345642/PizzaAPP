package com.example.UserPizzaService.Service;

import com.example.UserPizzaService.Domain.Pizza;
import com.example.UserPizzaService.Repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Override
    public Pizza registerPizza(Pizza pizza, byte[] bytes) {
        if(orderRepository.findById(pizza.getPizzaId()).isPresent())
        {
            return null;
        }
        pizza.setImg(bytes);
        return orderRepository.save(pizza);
    }

    @Override
    public List<Pizza> getAllPizzaDetails() {
        return orderRepository.findAll();
    }

    @Override
    public boolean deletByPizzaId(String pizzaId) {
      orderRepository.deleteById(pizzaId);

        return true;
    }

    @Override
    public Pizza updatePizza(Pizza pizza) {
        return orderRepository.save(pizza);
    }

    @Override
    public Pizza getPizzaById(String pizzaId) {
        return orderRepository.findById(pizzaId).get();
    }
}
