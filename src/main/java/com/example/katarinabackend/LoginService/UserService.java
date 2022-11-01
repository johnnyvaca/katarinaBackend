package com.example.katarinabackend.LoginService;

import com.example.katarinabackend.LoginDomain.User;
import com.example.katarinabackend.LoginRepository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User user(String email, String password) {
        return userRepository.findByEmailAndPassword(email, password);
    }

    public ArrayList<User> getUsers() {
        return (ArrayList<User>) userRepository.findAll();
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public Object getUserByEmailAndPassword(String email, String password) {
        try {
            return userRepository.findUserByEmailAndPassword(email, password).getId();
        }catch (Exception exception){
            return false;
        }

    }

    public boolean deleteUserById(Long id) {
        try {
            userRepository.deleteById(id);
            return true;
        } catch (Exception exception) {
          return false;
        }
    }

}
