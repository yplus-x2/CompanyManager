package com.example.CompanyManager.Controllers;

import com.example.CompanyManager.Components.UserComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
@CrossOrigin("Http://localhost:4200")
public class UserController {

    @Autowired
    private UserComponent userComponent;

    @GetMapping("/id")
    public ResponseEntity<?> UserById(@RequestParam String id){
        return new ResponseEntity<>(userComponent.getUser(id), HttpStatus.OK);
    }
}
