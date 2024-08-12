package com.marcobolanos.system.controller;

import java.util.List;
import java.util.logging.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marcobolanos.system.model.Empleados;
import com.marcobolanos.system.service.IEmpleadosService;

@RestController //http://localhost:8081/rh-empleado
@RequestMapping("rh-empleado")
public class EmpleadoController {

    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(EmpleadoController.class);

    @Autowired
    private IEmpleadosService iEmpleadosService;

    //http://localhost:8081/rh-empleado/empleados
    @GetMapping("/empleados")

    public List<Empleados> obtenerEmpleados(){
        List<Empleados> empleado2 = iEmpleadosService.listarEmpleados();
        empleado2.forEach(empleado -> logger.info(empleado.toString()));
        return empleado2;
    }

    @PostMapping("/empleadosA")
    public Empleados agregarEmpleados (@RequestBody Empleados empleados){
        logger.info("empleado agregado");
        return iEmpleadosService.guardarEmpleados(empleados);
    }


}
