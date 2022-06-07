package com.example.OlimpiadasUNAM.Servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.OlimpiadasUNAM.Modelo.Boleta;
import com.example.OlimpiadasUNAM.Repositorio.BoletaRepositorio;

@Service
public class ServicioBoleta {

	@Autowired
    private BoletaRepositorio repo;

	public List<Boleta> listAll() {
        return repo.findAll();
    }

    public void save(Boleta std) {
        repo.save(std);
    }

    public Boleta get(long id) {
        return repo.findById(id).get();
    }

    public void delete(long id) {
        repo.deleteById(id);
    }

}
