package com.example.CompanyManager.entities;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.tomcat.util.http.parser.MediaType;

import java.awt.*;
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

    @OneToMany(mappedBy = "azienda")
    @JsonBackReference
    private List<UserEntity> users;

    @OneToMany(mappedBy = "azienda")
    @JsonBackReference
    private List<SedeEntity> sedi;

    @OneToMany(mappedBy = "azienda")
    @JsonBackReference
    private List<DipendenteEntity> dipendenti;

}
