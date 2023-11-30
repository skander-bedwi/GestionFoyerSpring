package com.gestionfoyer.Controllers;

import com.gestionfoyer.Entites.Universite;
import com.gestionfoyer.Repositories.ReservationRepository;
import com.gestionfoyer.Services.UniversiteService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/universite")
public class UniversiteController {


    public final UniversiteService universiteService;
    private final ReservationRepository reservationRepository;


    @PostMapping("")
    public Universite addUnivesite(@RequestBody Universite universite){
        return  universiteService.addUniversite(universite);
    }

    @PutMapping("")
    public Universite updateUniversite(Universite universite){
        return universiteService.updateUniversite(universite);
    }

    @GetMapping("")
    public List<Universite> getAllUniversite(){
        return universiteService.getAllUniversities();
    }

    @GetMapping("{id}")
    public Universite getUniversiteById(@PathVariable long id){
        return  universiteService.getUniversiteById(id);
    }

    @DeleteMapping("{id}")
    public void deleteUniveriteById(@PathVariable long id){
        universiteService.deleteUniversiteById(id);
    }

    @PutMapping("{id}/{nomUniversite}")
    public  Universite affecterFoyerAUniversite(@PathVariable Long id, @PathVariable String nomUniversite){
        return universiteService.affecterFoyerAUniversite(id, nomUniversite);
    }

    @PutMapping("{id}")
   public Universite desaffecterFoyerAUniversite(@PathVariable long id){

        return  universiteService.desaffecterFoyerAUniversite(id);

   }


}
