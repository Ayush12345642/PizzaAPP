package com.example.UserPizzaService.Repository;

import com.example.UserPizzaService.Domain.PizzaList;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface   PizzaListRepository extends MongoRepository<PizzaList,String> {
}
