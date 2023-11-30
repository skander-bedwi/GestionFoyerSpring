package com.gestionfoyer.Controllers;

import com.gestionfoyer.Entites.Reservation;
import com.gestionfoyer.Services.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/reservation")
public class ReservationController {


    private  final ReservationService reservationService;

    @GetMapping("")
    public List<Reservation> getAllResvation(){

      return   reservationService.getAllReservation();

    }

    @PutMapping("")
    public Reservation updateReservation(@RequestBody Reservation reservation){
        return  reservationService.updateReservation(reservation);
    }

    @GetMapping("{id}")
    public Reservation getReservationById(@PathVariable String id){
        return  reservationService.getReservationById(id);
    }

    @PostMapping("/{idChambre}/{cin}")
    public Reservation ajouterReservation(@PathVariable Long idChambre, @PathVariable Long cin) {
        return reservationService.ajouterReservation(idChambre, cin);
    }

    @PutMapping("/{cin}")
    public Reservation annulerReservation(@PathVariable Long cin) {
        return reservationService.annulerReservation(cin);
    }


}
