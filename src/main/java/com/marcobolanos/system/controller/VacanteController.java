package com.marcobolanos.system.controller;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marcobolanos.system.model.Vacantes;
import com.marcobolanos.system.service.IVacantesService;

@RestController
@RequestMapping("rh-vacante")
public class VacanteController {

    private static final Logger logger =LoggerFactory.getLogger(VacanteController.class);

    @Autowired
    private IVacantesService iVacantesService;

    @GetMapping("/vacantes")

    public List<Vacantes> obtenerVacantes (){
        var vacante2 = iVacantesService.listarVacantes();
        vacante2.forEach((vacante ->  logger.info(vacante.toString())));
        return vacante2;
    }

    @PostMapping("/vacantesA")
    public Vacantes agregarVacantes (@RequestBody Vacantes vacantes){
        logger.info("vacante agregada");
        return iVacantesService.guardarVacantes(vacantes);
    }



    
}
