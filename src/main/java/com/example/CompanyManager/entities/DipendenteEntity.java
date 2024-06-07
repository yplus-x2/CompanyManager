package com.example.CompanyManager.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "dipendente")
public class DipendenteEntity implements Serializable {

    private static final long serialVersionUID = 7288308094596981209L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "cognome")
    private String cognome;

    @Column(name = "data_nascita")
    @Temporal(TemporalType.DATE)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date dataNascita;

    @ManyToOne
    @JoinColumn(name = "id_azienda")
    @JsonBackReference
    private AziendaEntity azienda;

    @ManyToOne
    @JoinColumn(name = "id_ruolo")
    private RuoloEntity ruolo;

    @ManyToOne
    @JoinColumn(name = "id_mansione")
    private MansioneEntity mansione;

    @ManyToMany(mappedBy = "dipendenti")
    @JsonBackReference
    private List<SedeEntity> sedi;
}
