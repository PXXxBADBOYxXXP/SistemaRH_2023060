package com.marcobolanos.system.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

// crea la tabla
@Entity
// hace los getter y setters
@Data
// construye constructor vacio
@NoArgsConstructor
// construye constructor lleno
@AllArgsConstructor
@ToString

public class Empleados {
    @Id
    // Id sea auto increment
    // Se establece que el id empieza en uno y se crea infinitas veces
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // Atributos no encapsulados (Publicos)
    // Recomendado usar Integer en lugar de Int
     Integer idEmpleado;
     String nombreCompleto;
     int dpi;
     String puesto;
     double salario;
}
