package com.marcobolanos.system.service;

import java.util.List;

import com.marcobolanos.system.model.Vacantes;

public interface IVacantesService {

    public List<Vacantes> listarVacantes();

    public Vacantes buscarVacantes (Integer idVacantes);

    public Vacantes guardarVacantes(Vacantes vacantes);

    public void eliminarVacantes(Vacantes vacantes);
    
}
