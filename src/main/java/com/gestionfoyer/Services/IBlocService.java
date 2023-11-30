package com.gestionfoyer.Services;

import com.gestionfoyer.Entites.Bloc;

import java.util.List;

public interface IBlocService {
    public List<Bloc> AllBlocs();

    public Bloc BlocById(Long id);

    public Bloc  addBloc(Bloc bloc);

    public void deleteBlocById(long id);

    public Bloc UpdateBloc(Bloc bloc);

    public Bloc affecterChambresABloc(List<Long> numeroChambre, long
            id) ;


    public Bloc affecterBlocAFoyer(long id, long idF);

}
