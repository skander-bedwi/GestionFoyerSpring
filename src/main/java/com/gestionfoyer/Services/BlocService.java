package com.gestionfoyer.Services;

import com.gestionfoyer.Entites.Bloc;
import com.gestionfoyer.Entites.Chambre;
import com.gestionfoyer.Entites.Foyer;
import com.gestionfoyer.Repositories.BlocRepository;
import com.gestionfoyer.Repositories.ChambreRepository;
import com.gestionfoyer.Repositories.FoyerRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BlocService implements IBlocService{



   private final BlocRepository blocRepository;

   private final ChambreRepository  chambreRepository;

   private final FoyerRepository foyerRepository;
    @Override
    public List<Bloc> AllBlocs() {
        return blocRepository.findAll();
    }

    @Override
    public Bloc BlocById(Long id) {
        return blocRepository.findById(id).get();
    }

    @Override
    public Bloc addBloc(Bloc bloc) {
        return blocRepository.save(bloc);
    }

    @Override
    public void deleteBlocById(long id) {
        blocRepository.deleteById(id);
    }

    @Override
    public Bloc UpdateBloc(Bloc bloc) {
        return blocRepository.save(bloc);
    }

    @Override
    public Bloc affecterChambresABloc(List<Long> numeroChambre, long id) {

        Bloc bloc = blocRepository.findById(id).orElse(null);

        for(long idaffectechambre:numeroChambre){
            Chambre chambre = chambreRepository.findByNumeroChambre(idaffectechambre);
            chambre.setBloc(bloc);
            chambreRepository.save(chambre);

        }


        return blocRepository.save(bloc);
    }

    @Override
    public Bloc affecterBlocAFoyer(long id, long idF) {

        Bloc bloc = blocRepository.findById(id).orElse(null);

        Foyer foyer = foyerRepository.findById(idF).orElse(null);

        bloc.setFoyer(foyer);

        blocRepository.save(bloc);

        return bloc;

    }
}
