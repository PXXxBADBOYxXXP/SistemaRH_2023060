package com.marcobolanos.system.controller;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marcobolanos.system.exception.VacantesException;
import com.marcobolanos.system.model.Vacantes;
import com.marcobolanos.system.service.IVacantesService;

@RestController
@RequestMapping("rh-vacante")
public class VacanteController {

    private static final Logger logger =LoggerFactory.getLogger(VacanteController.class);

    @Autowired
    private IVacantesService iVacantesService;
    //http://localhost:8081/rh-vacante/vacantes
    @GetMapping("/vacantes")

    public List<Vacantes> obtenerVacantes (){
        var vacante2 = iVacantesService.listarVacantes();
        vacante2.forEach((vacante ->  logger.info(vacante.toString())));
        return vacante2;
    }
    //http://localhost:8081/rh-vacante/vacantesA
    @PostMapping("/vacantesA")
    public Vacantes agregarVacantes (@RequestBody Vacantes vacantes){
        logger.info("vacante agregada");
        return iVacantesService.guardarVacantes(vacantes);
    }

     //http://localhost:8081/rh-vacante/vacantes/1
    @GetMapping("/vacantes/{id}")
        
    public ResponseEntity <Vacantes> buscarVacante(@PathVariable Integer id){
        Vacantes vacantes = iVacantesService.buscarVacantes(id);
        if(vacantes == null)
        throw new VacantesException("No se encontro la vacante");
        return ResponseEntity.ok(vacantes);
    }

    @PutMapping("/vacantes/{id}")
        public ResponseEntity <Vacantes> editarVacantes (@PathVariable Integer id, @RequestBody Vacantes vacantesRecibidas){
            Vacantes vacantes = iVacantesService.buscarVacantes(id);
            if(vacantes == null)
            throw new VacantesException("El id no existe");
            vacantes.setApellidos(vacantesRecibidas.getApellidos());
            vacantes.setCorreo(vacantesRecibidas.getCorreo());
            vacantes.setNombres(vacantesRecibidas.getNombres());
            vacantes.setTelefono(vacantesRecibidas.getTelefono());
            iVacantesService.guardarVacantes(vacantes);
            return ResponseEntity.ok(vacantes);
        }
    
    @DeleteMapping("/vacantes/{id}")
    public ResponseEntity<Map<String, Boolean>> eliminarVacantes(@PathVariable Integer id){
        Vacantes vacantes = iVacantesService.buscarVacantes(id);
        if(vacantes == null)
        throw new VacantesException("La vacante no existe");
        iVacantesService.eliminarVacantes(vacantes);

        Map<String, Boolean> respuestav = new HashMap<>();
        respuestav.put("Borrado", true);
        return ResponseEntity.ok(respuestav);
    }
}
