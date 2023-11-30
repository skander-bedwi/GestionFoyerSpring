package com.gestionfoyer.Entites;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Foyer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idFoyer;

    private String nomFoyer;

    private String capaciteFoyer;
    @JsonIgnore
   @OneToOne(mappedBy = "foyer")
   private   Universite universite;

   @OneToMany(mappedBy = "foyer")
    private List<Bloc> blocs;
}
