package com.example.CompanyManager.Components;

import com.example.CompanyManager.dtos.UserDto;
import com.example.CompanyManager.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserComponent {

    @Autowired
    private UserService userService;

    public UserDto getUser(String id){
        Long parseId = Long.parseLong(id);
        return userService.getUserById(parseId);
    }
}
