package com.gestionfoyer.Entites;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Etudiant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idEtudiant;
    private String nomEt;

    private String prenomEt;
    private Long cin;
    private String ecole;

    private Date dataNaissance;

   @ManyToMany(mappedBy = "etudiants")
   private List<Reservation> reservations;


}
