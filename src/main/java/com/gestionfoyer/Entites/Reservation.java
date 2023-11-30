package com.gestionfoyer.Entites;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
public class Reservation {

    @Id
   private String  idReservation;



    private boolean estValide;

    private LocalDate anneeUniversitaire;
    @JsonIgnore
    @ManyToMany
    private List<Etudiant> etudiants;


}
