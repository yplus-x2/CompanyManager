package com.example.CompanyManager.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "sede")
public class SedeEntity implements Serializable {

    private static final long serialVersionUID = 5839423795383036038L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "denominazione")
    private String denominazione;

    @Column(name = "indirizzo")
    private String indirizzo;

    @ManyToOne
    @JoinColumn(name = "id_azienda")
    @JsonBackReference
    private AziendaEntity azienda;

    @ManyToOne
    @JoinColumn(name = "id_comune")
    @JsonManagedReference
    private ComuneEntity comune;

    @ManyToMany
    @JoinTable(
            name = "sede_dipendente",
            joinColumns = @JoinColumn(name = "id_sede"),
            inverseJoinColumns = @JoinColumn(name = "id_dipendente")
    )
    @JsonManagedReference
    private List<DipendenteEntity> dipendenti;
}
