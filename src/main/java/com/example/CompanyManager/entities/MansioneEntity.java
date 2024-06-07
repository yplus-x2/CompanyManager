package com.example.CompanyManager.entities;

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
@Table(name = "mansione")
public class MansioneEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = -778733989317729056L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "denominazione")
    private String denominazione;

    @OneToMany(mappedBy = "mansione", cascade = CascadeType.ALL)
    private List<DipendenteEntity> dipendenti;
}
