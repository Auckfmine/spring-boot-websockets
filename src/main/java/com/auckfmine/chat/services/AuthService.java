package com.auckfmine.chat.services;

import com.auckfmine.chat.entities.Auth;
import com.auckfmine.chat.exceptions.ResourceNotFoundException;
import com.auckfmine.chat.repositories.AuthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthService {
    @Autowired
    private AuthRepository repository;

    public Auth login(String username, String password) {
        return repository.findByUserNameAndPassword(username, password);
    }

    public Auth register(String username, String password, String email) {
        Auth auth = repository.findByUserNameAndPassword(username, password);
        if (auth != null) {
            throw new ResourceNotFoundException("user already exists");
        } else {
            Auth a = new Auth();

            a.setUserName(username);
            a.setPassword(password);
            a.setEmail(email);
            return repository.save(a);
        }
    }

    public List<Auth>getAllUsers(){
        return repository.findAll();
    }
}
