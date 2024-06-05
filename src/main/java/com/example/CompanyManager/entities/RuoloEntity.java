package com.example.CompanyManager.entities;


import com.fasterxml.jackson.annotation.JsonBackReference;
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
@Table(name = "ruolo")
public class RuoloEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = -8947478640607767228L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "descrizione")
    private String descrizione;

    @OneToMany(mappedBy = "ruolo")
    @JsonBackReference
    private List<RuoloEntity> dipendenti;
}
