package com.example.CompanyManager.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
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
@Table(name = "sede")
public class SedeEntity implements Serializable {

    @Serial
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
    @JsonManagedReference
    private AziendaEntity azienda;

    @ManyToOne
    @JoinColumn(name = "id_comune")
    @JsonManagedReference
    private ComuneEntity comune;
}
