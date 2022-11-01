package com.example.katarinabackend.LoginRepository;

import com.example.katarinabackend.LoginDomain.User;
import org.springframework.boot.Banner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;


@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    User findByEmailAndPassword(String email, String password);

    public abstract User findUserByEmailAndPassword(String email, String password);
}
