package com.example.CompanyManager.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto implements Serializable {


    @Serial
    private static final long serialVersionUID = -531945573542404059L;

    private Long id;
    private String name;
    private String lastName;
}
