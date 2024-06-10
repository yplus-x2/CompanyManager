package com.example.CompanyManager.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "utente")
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
    @JsonBackReference
    private AziendaEntity azienda;
}
