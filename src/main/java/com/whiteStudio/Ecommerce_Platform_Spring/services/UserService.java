package com.whiteStudio.Ecommerce_Platform_Spring.services;

import com.whiteStudio.Ecommerce_Platform_Spring.entities.User;
import com.whiteStudio.Ecommerce_Platform_Spring.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository _rep;

    public List<User> findAll()
    {
        return _rep.findAll();
    }

    public Optional<User> findById(Long id)
    {
        return _rep.findById(id);
    }
}
