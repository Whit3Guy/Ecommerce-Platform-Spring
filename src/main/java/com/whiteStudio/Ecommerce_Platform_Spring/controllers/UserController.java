package com.whiteStudio.Ecommerce_Platform_Spring.controllers;

import com.whiteStudio.Ecommerce_Platform_Spring.entities.User;
import com.whiteStudio.Ecommerce_Platform_Spring.entities.dtos.UserDto;
import com.whiteStudio.Ecommerce_Platform_Spring.entities.dtos.UserUpdateDto;
import com.whiteStudio.Ecommerce_Platform_Spring.services.UserService;
import org.springframework.beans.BeanUtils;
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
        return u.<ResponseEntity<Object>>map(user -> ResponseEntity.ok().body(user)).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found"));
    }

    @PostMapping("/")
    public ResponseEntity<Object> postUser(@RequestBody UserDto u)
    {
        User user = new User();
        BeanUtils.copyProperties(u, user);
        try {
            service.insert(user);
            return ResponseEntity.ok().body(user);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            return ResponseEntity.badRequest().body("Formato invalido");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> putUser(@PathVariable(value = "id") Long id, @RequestBody UserUpdateDto user)
    {
        try
        {

        User u = new User();
        BeanUtils.copyProperties(user, u);
        return ResponseEntity.ok().body(service.update(u, id));

        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            return ResponseEntity.badRequest().body("Usuario não encontrado");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteUser(@PathVariable(value = "id") Long id)
    {
        try
        {
            User u = service.remove(id);
            return ResponseEntity.ok().body(u);

        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario não encontrado");
        }
    }

}
