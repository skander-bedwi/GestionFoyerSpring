package com.gestionfoyer.Services;

import com.gestionfoyer.Entites.Chambre;
import com.gestionfoyer.Entites.Enums.TypeChambre;

import java.util.List;

public interface IChmabreService {

   public  List<Chambre> getAllChambres();
    public Chambre addChambre(Chambre chambre);
    public Chambre updateChambre (Chambre chambre);
    public Chambre retrieveChambre (long id);

    public void deleteChambreById(long id);

    public List<Chambre> getChambreParNomUniversite(String nomUniversite);

    public List<Chambre>  getChambresParBlocEtType(Long idBloc, TypeChambre typeChambre);

    public List<Chambre> findChambreBlocIdTypeChambre(long idBloc, TypeChambre typechambre);
}
