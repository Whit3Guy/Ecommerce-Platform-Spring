package com.whiteStudio.Ecommerce_Platform_Spring.controllers;

import com.whiteStudio.Ecommerce_Platform_Spring.entities.User;
import com.whiteStudio.Ecommerce_Platform_Spring.entities.dtos.UserDto;
import com.whiteStudio.Ecommerce_Platform_Spring.entities.dtos.UserUpdateDto;
import com.whiteStudio.Ecommerce_Platform_Spring.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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
    public ResponseEntity<Object> postUser(@RequestBody @Valid UserDto u)
    {

        User user = new User();
        BeanUtils.copyProperties(u, user);
        User u1 = service.insert(user);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().
                path("{id}").
                buildAndExpand(u1.getId()).
                toUri();
        return ResponseEntity.created(uri).body(user);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> putUser(@PathVariable(value = "id") Long id, @RequestBody UserUpdateDto user)
    {
        User u = new User();
        BeanUtils.copyProperties(user, u);
        return ResponseEntity.ok().body(service.update(u, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteUser(@PathVariable(value = "id") Long id)
    {
            User u = service.remove(id);
            return ResponseEntity.ok().body(u);

    }

}
