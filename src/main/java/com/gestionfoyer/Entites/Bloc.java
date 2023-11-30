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
public class Bloc {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
      private long idBloc;
    private String nomBloc;

    private    String capaciteBloc;

    @JsonIgnore
    @OneToMany(mappedBy = "bloc")
   private List<Chambre> chambres;

    @JsonIgnore
    @ManyToOne
    private Foyer foyer;
}
