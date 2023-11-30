package com.gestionfoyer.Entites;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gestionfoyer.Entites.Enums.TypeChambre;
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
public class Chambre {

 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 Long  idChambre ;

 Long numeroChambre ;

 @Enumerated(EnumType.STRING)
private  TypeChambre typeChambre;

 @JsonIgnore
 @ManyToOne
 private Bloc bloc;

 @OneToMany
 private List<Reservation> reservationList;


}
