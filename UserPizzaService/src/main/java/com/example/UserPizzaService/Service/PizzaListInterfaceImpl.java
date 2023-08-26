package com.example.UserPizzaService.Service;

import com.example.UserPizzaService.Domain.PizzaDTO;
import com.example.UserPizzaService.Domain.PizzaList;
import com.example.UserPizzaService.Repository.PizzaListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PizzaListInterfaceImpl implements PizzaListInterface {
    @Autowired
    private PizzaListRepository pizzaListRepository;

    @Override
    public PizzaList savePizzaList(PizzaDTO pizzaDTO) {
        Optional<PizzaList> pizzaList = pizzaListRepository.findById(pizzaDTO.getEmailId());
        if (pizzaList.isEmpty()) {
            PizzaList newPizzaList = new PizzaList();
            newPizzaList.setEmailId(pizzaDTO.getEmailId());
            List<String> pizza = new ArrayList<>();
            pizza.add(pizzaDTO.getPizzaId());
            newPizzaList.setPizzaId(pizza);
            return pizzaListRepository.save(newPizzaList);}
        else {
            PizzaList existingPizzaList = pizzaList.get();
            List<String> pizza = existingPizzaList.getPizzaId();
            pizza.add(pizzaDTO.getPizzaId());
            existingPizzaList.setPizzaId(pizza);
            return pizzaListRepository.save(existingPizzaList);
        }
    }

    @Override
    public PizzaList findPizzaList(String userEmail) {
        Optional<PizzaList> pizzaList = pizzaListRepository.findById(userEmail);
        return pizzaList.get();

    }
    public boolean deletePizzalistbyId(String email,String id)
    { boolean flag=false;
        if(pizzaListRepository.findById(email).isPresent())

            pizzaListRepository.deleteById(id);
            flag=true;

        return flag;
    }

}
