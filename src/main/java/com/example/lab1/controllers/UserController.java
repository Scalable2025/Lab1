package com.example.lab1.controllers;

import com.example.lab1.models.User;
import com.example.lab1.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserController {
    UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping("/hello")
    public String testController() {
        return "Hello from user controller";
    }

    @GetMapping()
    public List<User> getUsers(){
//        return List.of(new User(UUID.randomUUID().toString(),"John Doe", "john@doe.com", 25));
        return userService.getUsers();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable String id) {
//        return new User(id, "John Doe", "john@doe.com", 25);
        return userService.getUserById(id);
    }

    @PostMapping()
    public User createUser(@RequestBody User user){
//        user.setId(UUID.randomUUID().toString());
//        return user;
        return userService.createUser(user);
    }

}
