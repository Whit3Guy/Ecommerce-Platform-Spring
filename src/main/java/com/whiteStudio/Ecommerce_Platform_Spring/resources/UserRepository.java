package com.whiteStudio.Ecommerce_Platform_Spring.resources;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Users")
public class UserRepository
{
    @GetMapping("/teste")
    public ResponseEntity<String> teste()
    {
        return ResponseEntity.status(HttpStatus.OK).body("Construindo o serviço...");
    }
}
