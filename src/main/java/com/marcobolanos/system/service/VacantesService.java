package com.marcobolanos.system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marcobolanos.system.model.Vacantes;
import com.marcobolanos.system.repository.VacantesRepositorio;
@Service
public class VacantesService implements IVacantesService {
    @Autowired
    private VacantesRepositorio vacantesRepositorio;
    @Override
    public List<Vacantes> listarVacantes() {
        
    }

    @Override
    public Vacantes buscarVacantes(Integer idVacantes) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buscarVacantes'");
    }

    @Override
    public Vacantes guardarVacantes(Vacantes vacantes) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'guardarVacantes'");
    }

    @Override
    public void eliminarVacantes(Vacantes vacantes) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'eliminarVacantes'");
    }

}
