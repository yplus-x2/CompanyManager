package com.example.CompanyManager.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "azienda")
public class AziendaEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 5386653174338270662L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "denominazione")
    private String denominazione;

    @Column(name = "residenza")
    private String residenza;

    @Column(name = "p_iva")
    private String pIva;

    @Column(name = "settore")
    private String settore;

    @OneToMany(mappedBy = "azienda", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<UserEntity> users;

    @OneToMany(mappedBy = "azienda", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<SedeEntity> sedi;

    @OneToMany(mappedBy = "azienda", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<DipendenteEntity> dipendenti;
}
