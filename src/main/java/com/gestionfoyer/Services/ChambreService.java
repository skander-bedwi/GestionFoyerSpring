package com.gestionfoyer.Services;

import com.gestionfoyer.Entites.Chambre;
import com.gestionfoyer.Entites.Enums.TypeChambre;
import com.gestionfoyer.Repositories.ChambreRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@AllArgsConstructor
@Service
public class ChambreService implements IChmabreService{

    @Autowired
    ChambreRepository chambreRepository;

    @Override
    public List<Chambre> getAllChambres() {
        return chambreRepository.findAll();
    }

    @Override
    public Chambre addChambre(Chambre chambre) {
        return chambreRepository.save(chambre);
    }

    @Override
    public Chambre updateChambre(Chambre chambre) {
        return chambreRepository.save(chambre);
    }

    @Override
    public Chambre retrieveChambre(long id) {
        return chambreRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("chambre n'existe pas"+id));
    }

    @Override
    public void deleteChambreById(long id) {
       chambreRepository.deleteById(id);
    }

    @Override
    public List<Chambre> getChambreParNomUniversite(String nomUniversite) {
        return chambreRepository.findChambreByBlocFoyerUniversiteNomUniversite(nomUniversite);
    }

    @Override
    public List<Chambre> getChambresParBlocEtType(Long idBloc, TypeChambre typeChambre) {
        return chambreRepository.getChambresParBlocEtType(idBloc, typeChambre );
    }

    @Override
    public List<Chambre> findChambreBlocIdTypeChambre(long idBloc, TypeChambre typechambre) {
        return null;
    }


//    @Override
//    public List<Chambre> findChambreBlocIdTypeChambre(long idBloc, TypeChambre typechambre){
//        return chambreRepository.findChambreByBloc_IdBlocAndTypeChambre(idBloc, typechambre);
//    }


}
