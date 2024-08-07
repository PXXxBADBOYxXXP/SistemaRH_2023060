package com.marcobolanos.system.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Vacantes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     Integer idVacantes;
     String nombres;
     String apellidos;
     String telefono;
     String correo;
}
