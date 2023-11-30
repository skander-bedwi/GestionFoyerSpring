package com.gestionfoyer.Services;

import com.gestionfoyer.Entites.Chambre;
import com.gestionfoyer.Entites.Etudiant;
import com.gestionfoyer.Entites.Reservation;
import com.gestionfoyer.Repositories.ChambreRepository;
import com.gestionfoyer.Repositories.EtudiantRepository;
import com.gestionfoyer.Repositories.ReservationRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ReservationService implements IReserveationService{

    @Autowired
    ReservationRepository  reservationRepository;
    EtudiantRepository etudiantRepository;
    ChambreRepository chambreRepository;
    @Override
    public List<Reservation> getAllReservation() {
        return reservationRepository.findAll();
    }

    @Override
    public Reservation updateReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    @Override
    public Reservation getReservationById(String id) {
        return reservationRepository.findById(id).get();
    }

    @Override
    public Reservation ajouterReservation(Long idChambre, Long cinEtudiant) {
        LocalDate startDate=LocalDate.of(LocalDate.now().getYear(),1,1);
        LocalDate endDate=LocalDate.of(LocalDate.now().getYear(),12,31);
        Assert.isTrue(!reservationRepository.existsByEtudiantsCinAndAnneeUniversitaireBetween(cinEtudiant,startDate,endDate),"Vous avez deja une reservation cette année");
        Chambre chambre = chambreRepository.findById(idChambre).orElseThrow(()->new IllegalArgumentException("Cette chambre n'existe pas"));

        Etudiant etudiant = etudiantRepository.findByCin(cinEtudiant);
        String id=chambre.getNumeroChambre() +"-"+ chambre.getBloc().getNomBloc().replace(" ", "") +"-"+LocalDate.now().getYear();

        // Création de la réservation
        Reservation reservation = reservationRepository.findById(id).orElse(Reservation.builder().idReservation(id).anneeUniversitaire(LocalDate.now()).estValide(true).etudiants(new ArrayList<Etudiant>()).build());
        Assert.isTrue(reservation.isEstValide(),"La capacité maximale de la chambre est atteinte.");
        reservation.getEtudiants().add(etudiant);
        if (!chambre.getReservationList().contains(reservation)){
            reservation=reservationRepository.save(reservation);
            chambre.getReservationList().add(reservation);
        }
        switch (chambre.getTypeChambre()){
            case SIMPLE ->reservation.setEstValide(false);
            case DOUBLE ->{
                if(reservation.getEtudiants().size()==2){reservation.setEstValide(false);}
            }
            case TRIPLE ->{
                if(reservation.getEtudiants().size()==3){reservation.setEstValide(false);}
            }
        }
        return reservation;
    }

    @Override
    public Reservation annulerReservation(Long cinEtudiant) {
        // Trouver l'étudiant et sa réservation
        Etudiant etudiant = etudiantRepository.findByCin(cinEtudiant);

        Reservation reservation = etudiant.getReservations().stream()
                .findFirst()
                .orElseThrow(()->new IllegalArgumentException("Cette reservation n'existe pas"));


        reservation.setEstValide(true);

        reservation.getEtudiants().remove(etudiant);


        Chambre chambreAssociee = chambreRepository.findByReservationListContains(reservation);
        if (chambreAssociee != null) {
            switch (chambreAssociee.getTypeChambre()){
                case SIMPLE ->chambreAssociee.getReservationList().remove(reservation);
            }

            chambreRepository.save(chambreAssociee); // Sauvegarder les changements dans la chambre
        }

        // Sauvegarder les modifications
        return reservationRepository.save(reservation);
    }
    }



