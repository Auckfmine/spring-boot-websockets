package com.auckfmine.chat.controllers;

import com.auckfmine.chat.entities.Auth;
import com.auckfmine.chat.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.ResponseEntity.noContent;

@RestController
public class AuthController {
    @Autowired
    private AuthService service;
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/login")
    @ResponseBody
    public ResponseEntity<Auth> login(@RequestBody Auth auth){
        Auth auuth = service.login(auth.getUserName(), auth.getPassword());
        if(auuth==null){
            return  ResponseEntity.status(404).build();
        }
        else return ResponseEntity.ok(auuth);

    }
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/register")
    @ResponseBody
    public ResponseEntity<Auth> register(@RequestBody Auth auth){

        return ResponseEntity.ok(service.register(auth.getUserName(), auth.getPassword(), auth.getEmail()));
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/get-all-users")
    @ResponseBody
    public ResponseEntity<?> getAllUsers(){

        return ResponseEntity.ok(service.getAllUsers());
    }


}
