package com.marcobolanos.system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marcobolanos.system.model.Empleados;
import com.marcobolanos.system.repository.EmpleadosRepositorio;
// Me va a hacer comunicacion de esta clase (SERVICIO) en bean(model)
@Service
public class EmpleadosService implements IEmpleadosService{
    @Autowired
    // variable para almacenar el autowired
    private EmpleadosRepositorio empleadosRepositorio;
    @Override
    public List<Empleados> listarEmpleados() {
        return empleadosRepositorio.findAll();
    }

    @Override
    public Empleados buscarEmpleados(Integer idEmpleado) {
        Empleados empleados = empleadosRepositorio.findById(idEmpleado).orElse(null);
        return empleados;
    }

    @Override
    public Empleados guardarEmpleados(Empleados empleados) {
        return empleadosRepositorio.save(empleados);
    }

    @Override
    public void eliminarEmpleados(Empleados empleados) {
        empleadosRepositorio.delete(empleados);
    }

    
}
