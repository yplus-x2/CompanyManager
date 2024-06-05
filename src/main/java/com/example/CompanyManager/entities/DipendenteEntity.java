package com.example.CompanyManager.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "dipendente")
public class DipendenteEntity implements Serializable {
    @Serial
    private static final long serialVersionUID = 7288308094596981209L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "cognome")
    private String cognome;

    @Column(name = "data_nascita")
    private Date dataNascita;

    @ManyToOne
    @JoinColumn(name = "id_azienda")
    @JsonManagedReference
    private AziendaEntity azienda;

    @ManyToOne
    @JoinColumn(name = "id_ruolo")
    @JsonManagedReference
    private RuoloEntity ruolo;

    @ManyToOne
    @JoinColumn(name = "id_mansione")
    @JsonManagedReference
    private MansioneEntity mansione;
}
