package com.example.UserPizzaService.Domain.Controller;

import com.example.UserPizzaService.Domain.Pizza;
import com.example.UserPizzaService.Domain.User;
import com.example.UserPizzaService.Service.OrderService;
import com.example.UserPizzaService.Service.PizzaListInterface;
import com.example.UserPizzaService.Service.UserService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@CrossOrigin
@RestController
@RequestMapping("/pizza-app-v1")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private PizzaListInterface pizzaListInterface;
    Gson gson =new Gson();
    private ResponseEntity responseEntity;
    @PostMapping("/add-user")
    public ResponseEntity<?> addUser(@RequestBody User user)
    {
        responseEntity=new ResponseEntity<>(userService.addUser(user), HttpStatus.CREATED);
        return responseEntity;

    }
    @GetMapping("/get-user-details")
    public ResponseEntity<?> getUserDetails(HttpServletRequest request)
    {
        //String emailid = (String) request.getAttribute("current_user_emailid");
   return new ResponseEntity<>(userService.getAllUser(),HttpStatus.OK);
    }
   @PostMapping("/add-pizza-to-user")
    public ResponseEntity<?> addPizza(@RequestBody Pizza pizza,HttpServletRequest request)
   {
       String current_email= (String) request.getAttribute("current_user_emailid");
       System.out.println(current_email);
    return new ResponseEntity<>(userService.savePizzaToUserList(pizza,current_email),HttpStatus.OK);
   }

}
