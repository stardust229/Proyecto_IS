package com.example.OlimpiadasUNAM.Repositorio;

import com.example.OlimpiadasUNAM.Modelo.Competidor;
import com.example.OlimpiadasUNAM.Modelo.Competir;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CompetirRepositorio extends CrudRepository<Competir,Integer> {
    public List<Competir> findAllByCompetidor(Competidor competidor);

    @Query(value="SELECT * FROM competir c WHERE c.competidor_num_cuenta=:numCuenta",nativeQuery = true)
    public  List<Competir> obtenerCompetencias(Integer numCuenta);
}
