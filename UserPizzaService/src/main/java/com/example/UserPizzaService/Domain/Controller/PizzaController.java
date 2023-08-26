package com.example.UserPizzaService.Domain.Controller;

import com.example.UserPizzaService.Domain.Pizza;
import com.example.UserPizzaService.Domain.PizzaDTO;
import com.example.UserPizzaService.Domain.User;
import com.example.UserPizzaService.Service.OrderService;
import com.example.UserPizzaService.Service.PizzaListInterface;
import com.example.UserPizzaService.Service.UserService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@CrossOrigin
@RestController
@RequestMapping("/pizza-app-v1")
public class PizzaController {
    @Autowired
    private UserService userService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private PizzaListInterface pizzaListInterface;
    Gson gson=new Gson();
    private ResponseEntity responseEntity;
    @PostMapping("/admin/add-new-pizza")
    public ResponseEntity<?> registerPizza(@RequestParam("file") MultipartFile file, @RequestParam("details") String details) {
        try {
            Pizza pizza = gson.fromJson(details, Pizza.class);
            responseEntity = new ResponseEntity<>(orderService.registerPizza(pizza, file.getBytes()), HttpStatus.OK);}
        catch (IOException e) {throw new RuntimeException(e);}
        return responseEntity;
    }
    @GetMapping("pizzaId/{pizzaId}")
    public ResponseEntity<?> findPizza(@PathVariable String pizzaId) {
        return new ResponseEntity<>(orderService.getPizzaById(pizzaId),HttpStatus.OK);
    }
    @GetMapping("getpizzalist/{userEmail}")
    public ResponseEntity<?> findPizzaList(@PathVariable String userEmail) {
        return new ResponseEntity<>(pizzaListInterface.findPizzaList(userEmail),HttpStatus.OK);
    }
    @PutMapping("/admin/update-pizza")
    public ResponseEntity<?> updateProduct(@RequestBody Pizza pizza){
        return new ResponseEntity<>(orderService.updatePizza(pizza),HttpStatus.OK);
    }
    @DeleteMapping("/admin/delete-pizza/{pizzaId}")
    public ResponseEntity<?> deleteProduct(@PathVariable String pizzaId){
        return new ResponseEntity<>(orderService.deletByPizzaId(pizzaId),HttpStatus.OK);
    }
    @GetMapping("/get-all-pizza")
    public ResponseEntity<?> getAllPizzaDetails()
    {
        return new ResponseEntity<>(orderService.getAllPizzaDetails(),HttpStatus.OK);
    }
    @PostMapping("/pizzalist")
    public ResponseEntity<?> savePizzaList(@RequestBody PizzaDTO pizzaDTO) {
        return new ResponseEntity<>(pizzaListInterface.savePizzaList(pizzaDTO), HttpStatus.OK);
    }

    @DeleteMapping("user/deleteProduct/{name}")
    public ResponseEntity<?> deletePizza(@PathVariable String name,@RequestBody User user)
    {
//        System.out.println(email);
        System.out.println(name);
       return new ResponseEntity<>(userService.deleteFromPizzaId(name,user),HttpStatus.OK);


    }
    @DeleteMapping("delete/{pizzaId}/{emailId}")
    public ResponseEntity<?> deletepizzabyid(@PathVariable String pizzaId,@PathVariable String emailId)
    {


        return new ResponseEntity<>(pizzaListInterface.deletePizzalistbyId(pizzaId,emailId),HttpStatus.CREATED);

    }


}
