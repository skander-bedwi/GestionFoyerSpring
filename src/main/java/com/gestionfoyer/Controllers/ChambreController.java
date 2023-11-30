package com.gestionfoyer.Controllers;

import com.gestionfoyer.Entites.Chambre;
import com.gestionfoyer.Entites.Enums.TypeChambre;
import com.gestionfoyer.Services.ChambreService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/chambre")
public class ChambreController {

    private  final ChambreService chambreService;

    @PostMapping("")
    public Chambre addChambre(@RequestBody Chambre chambre){
        return chambreService.addChambre(chambre);
    }

    @PutMapping("")
   public Chambre updateChambre(@RequestBody Chambre chambre){
        return chambreService.updateChambre(chambre);
   }

   @GetMapping("")
   public List<Chambre> getAllChambre(){
        return chambreService.getAllChambres();
   }

   @GetMapping("{id}")
   public Chambre findChambreById(@PathVariable Long id){
       return chambreService.retrieveChambre(id);
   }

   @DeleteMapping("{id}")
   public void deleteChambreById(@PathVariable long id){
        chambreService.deleteChambreById(id);
   }


   @GetMapping("api/{nomUniversite}")
   public List<Chambre> getChambreParNomUniversite(@PathVariable String nomUniversite){

        return chambreService.getChambreParNomUniversite(nomUniversite);
   }

//   @GetMapping("{idbloc}/{typechambre}")
//   public List<Chambre> getChambreParIdBlocAndTypeChambre(@PathVariable long idbloc, @PathVariable TypeChambre typeChambre){
//        return chambreService.findChambreBlocIdTypeChambre(idbloc, typeChambre);
//   }


    @GetMapping("/{idBloc}/{typeChambre}")
    public List<Chambre> getChambresParBlocEtType(@PathVariable Long idBloc, @PathVariable TypeChambre typeChambre) {
        return chambreService.getChambresParBlocEtType(idBloc, typeChambre);
    }

}
