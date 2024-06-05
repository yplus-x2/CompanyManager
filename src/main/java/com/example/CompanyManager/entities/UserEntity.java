package com.example.CompanyManager.entities;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.apachecommons.CommonsLog;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user")
public class UserEntity implements Serializable {
    @Serial
    private static final long serialVersionUID = -281780998799291511L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "cognome")
    private  String cognome;

    @Column(name = "username")
    private  String username;

    @Column(name = "password")
    private  String password;

    @ManyToOne
    @JoinColumn(name = "id_azienda")
    @JsonManagedReference
    private AziendaEntity azienda;
}
