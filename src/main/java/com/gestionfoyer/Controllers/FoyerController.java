package com.gestionfoyer.Controllers;

import com.gestionfoyer.Entites.Foyer;
import com.gestionfoyer.Services.FoyerService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/foyer")
public class FoyerController {

    private  final FoyerService foyerService;


    @PostMapping("")
   public Foyer addFoyer(@RequestBody Foyer foyer){

      return  foyerService.addFoyer(foyer);

   }

    @PutMapping("")
    public Foyer UpdateFoyer(@RequestBody Foyer foyer){

        return  foyerService.addFoyer(foyer);

    }

   @GetMapping("")
   public List<Foyer> getAllFoyer(){
        return foyerService.geteAllFoyers();
   }


   @GetMapping("{id}")
   public Foyer getFoyerById(@PathVariable long id){
   return foyerService.getFoyerById(id);
   }


   @DeleteMapping("{id}")
   public void deleteFoyerById(@PathVariable long id){

        foyerService.removeFoyer(id);
   }


   @PostMapping("{id}")
   public Foyer ajouterFoyerEtAffecterAUniversite(@RequestBody Foyer foyer,@PathVariable long id){

        return foyerService.ajouterFoyerEtAffecterAUniversite(foyer, id);

   }



}
