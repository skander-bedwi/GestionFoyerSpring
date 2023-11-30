package com.gestionfoyer.Services;

import com.gestionfoyer.Entites.Reservation;

import java.util.List;

public interface IReserveationService {


    public List<Reservation> getAllReservation();
    public Reservation updateReservation (Reservation reservation);
    public Reservation getReservationById (String id);

    Reservation ajouterReservation (Long idChambre, Long cinEtudiant) ;

    Reservation annulerReservation (Long cinEtudiant) ;

}
