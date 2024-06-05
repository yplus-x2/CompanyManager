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
@Table(name = "comune")
public class ComuneEntity implements Serializable {


    @Serial
    private static final long serialVersionUID = 2879122020157339379L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "denominazione")
    private String denominazione;

    @Column(name = "sigla_prov")
    private String siglaProv;

    @Column(name = "denominazione_prov")
    private String denominazioneProv;

    @Column(name = "sigla_reg")
    private String siglaReg;

    @Column(name = "denominazione_reg")
    private String denominazioneReg;

    @Column(name = "cod_catastale")
    private String codCatastale;

    @OneToMany(mappedBy = "comune")
    @JsonBackReference
    private List<ComuneEntity> comuni;

}
