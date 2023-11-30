package com.gestionfoyer.Controllers;

import com.gestionfoyer.Entites.Bloc;
import com.gestionfoyer.Services.BlocService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/bloc")
public class BlocController {

    @Autowired
     BlocService blocService;


    @PostMapping()
   public Bloc add(@RequestBody Bloc bloc){
      return blocService.addBloc(bloc);
   }

   @PutMapping()
   public Bloc UpdtaeBloc(@RequestBody Bloc bloc){
        return blocService.UpdateBloc(bloc);
   }

   @GetMapping()
   public List<Bloc> getAll(){
        return blocService.AllBlocs();
   }

   @GetMapping("{id}")
   public Bloc blocbyid(@PathVariable  Long id){
       return  blocService.BlocById(id);
   }

   @DeleteMapping("{id}")
   public void  deleteBlocById(@PathVariable long id){
        blocService.deleteBlocById(id);
    }



    @PutMapping("{id}")
    public Bloc affecterChambresABloc(@RequestBody List<Long> numeroChambre, Long id ){
        return  blocService.affecterChambresABloc(numeroChambre, id);
    }



    @PutMapping("{id}/{idF}")
    public Bloc affecterBlocAFoyer(@PathVariable long id,@PathVariable long idF){

       return blocService.affecterBlocAFoyer(id, idF);
    }
}
