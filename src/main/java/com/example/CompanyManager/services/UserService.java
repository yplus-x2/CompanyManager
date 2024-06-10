package com.example.CompanyManager.services;

import com.example.CompanyManager.dtos.UserDto;
import com.example.CompanyManager.entities.UserEntity;
import com.example.CompanyManager.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserDto getUserById(Long id){
        UserDto user = null;

        try{
            Optional<UserEntity> userE = userRepository.findById(id);

            if(userE.isPresent()){
                UserEntity temp = userE.get();
                user = new UserDto(temp.getId(), temp.getNome(), temp.getCognome());
            }

            return user;
        }catch (Exception e){
            return user;
        }
    }
}
