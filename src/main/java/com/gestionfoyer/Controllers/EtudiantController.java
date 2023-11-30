package com.gestionfoyer.Controllers;


import com.gestionfoyer.Entites.Etudiant;
import com.gestionfoyer.Entites.Foyer;
import com.gestionfoyer.Services.EtudiantService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/etudiant")
public class EtudiantController {


    private final EtudiantService etudiantService;

    @PostMapping("")
    public Etudiant addEtudiant(@RequestBody Etudiant etudiant){

        return  etudiantService.addEtudiant(etudiant);

    }

    @PutMapping("")
    public Etudiant UpdateEtudiant(@RequestBody Etudiant etudiant){
        return etudiantService.updateEtudiant(etudiant);
    }

    @GetMapping("")
     public List<Etudiant> getAllEtudiant(){
        return  etudiantService.getAllEtudiants();
    }

    @GetMapping("{id}")
    public Etudiant getEtdiantById(@PathVariable long id){
        return etudiantService.getEtudiantById(id);
    }

    @DeleteMapping("{id}")
    public void  deleteEtudiantById(@PathVariable long id){
        etudiantService.removeEtudiant(id);
    }


}
