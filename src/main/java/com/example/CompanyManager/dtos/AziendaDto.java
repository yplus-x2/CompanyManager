package com.example.CompanyManager.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AziendaDto implements Serializable {
    @Serial
    private static final long serialVersionUID = 195518763269941928L;

    private Long id;
    private String name;
    private String address;
}
