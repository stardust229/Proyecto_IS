package com.example.OlimpiadasUNAM.Repositorio;

import com.example.OlimpiadasUNAM.Modelo.Competir;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CompetirRepositorio extends CrudRepository<Competir,Integer> {
    @Query(value="SELECT * FROM competir c WHERE c.num_cuenta=:id",nativeQuery = true)
    public  List<Competir> obtenerCompetencias(Integer id);
}
