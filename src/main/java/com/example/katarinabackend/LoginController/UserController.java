package com.example.katarinabackend.LoginController;

import com.example.katarinabackend.LoginDomain.User;
import com.example.katarinabackend.LoginService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public ArrayList<User> getUsers() {
        return userService.getUsers();
    }

    @PostMapping("/user")
    public User saveUser(@RequestBody User user) {
        return this.userService.saveUser(user);
    }

    @GetMapping(path ="/user/{id}")
    public Optional<User> getUserById(@PathVariable("id") Long id){
        return this.userService.getUserById(id);
    }

    @GetMapping("/login")
    public Object getUserByEmailAndPassword(@RequestParam("email") String email, @RequestParam("password") String password){
        return this.userService.getUserByEmailAndPassword(email,password);
    }

    @DeleteMapping(path ="/user/{id}")
    public Boolean deleteUserById(@PathVariable("id") Long id){
        return this.userService.deleteUserById(id);
    }
}
