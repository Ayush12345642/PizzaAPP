package com.example.UserPizzaService.Service;

import com.example.UserPizzaService.Domain.PizzaDTO;
import com.example.UserPizzaService.Domain.PizzaList;

public interface PizzaListInterface {
    PizzaList savePizzaList(PizzaDTO pizzaDTO);
    PizzaList findPizzaList(String userEmail);
  public boolean deletePizzalistbyId(String email,String id);

}
