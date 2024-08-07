package com.marcobolanos.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.marcobolanos.system.model.Empleados;

public interface EmpleadosRepositorio extends JpaRepository<Empleados, Integer> {

}
