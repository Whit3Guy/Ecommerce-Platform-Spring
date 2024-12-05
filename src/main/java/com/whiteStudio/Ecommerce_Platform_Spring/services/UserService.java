package com.whiteStudio.Ecommerce_Platform_Spring.services;

import com.whiteStudio.Ecommerce_Platform_Spring.entities.User;
import com.whiteStudio.Ecommerce_Platform_Spring.repositories.UserRepository;
import com.whiteStudio.Ecommerce_Platform_Spring.services.exceptions.ResourceNotFoundException;
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

    public User insert(User user) throws RuntimeException
    {
        return _rep.save(user);
    }

    public User remove(Long id)
    {
        Optional<User> u = _rep.findById(id);
        if(u.isPresent()) {
            _rep.delete(u.get());
            return u.get();
        }
        else
        {
            throw new ResourceNotFoundException(id);
        }
    }

    public User update(User user, Long id)
    {
        Optional<User> u = _rep.findById(id);
        if(u.isPresent())
        {
            User u1 = u.get();
            u1.UserUpdate(user);
            _rep.save(u1);
            return u1;
        }
        else
        {
            throw new ResourceNotFoundException(id);
        }
    }
}
