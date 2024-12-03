package com.whiteStudio.Ecommerce_Platform_Spring.controllers;

import com.whiteStudio.Ecommerce_Platform_Spring.entities.User;
import com.whiteStudio.Ecommerce_Platform_Spring.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController
{
    @Autowired
    private UserService service;

    @GetMapping("/")
    public ResponseEntity<List<User>> getAllUsers()
    {
        List<User> u = service.findAll();
        return ResponseEntity.ok().body(u);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getUserById(@PathVariable(value="id") Long id)
    {
        Optional<User> u = service.findById(id);
        return u.<ResponseEntity<Object>>map(user -> ResponseEntity.status(HttpStatus.OK).body(user)).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found"));
    }

}
