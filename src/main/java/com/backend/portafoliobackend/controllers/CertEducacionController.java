package com.backend.portafoliobackend.controllers;

import com.backend.portafoliobackend.models.CertEducacionModel;
import com.backend.portafoliobackend.models.CertJavaScriptModel;
import com.backend.portafoliobackend.services.CertEducacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/CertEducacion")
public class CertEducacionController {

    /*Inyeccion de dependencia desde el service*/
    @Autowired
    CertEducacionService certEducacionService;

    /*metodo get all*/
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping()
    public ArrayList<CertEducacionModel> obtenerEducacion(){

        return certEducacionService.obtenerCertEducacion();
    }

    /* metodo post*/
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping
    public CertEducacionModel guardarCertEducacion(@RequestBody CertEducacionModel educacion){
        return this.certEducacionService.guardarCertEducacion(educacion);
    }

    /*Metodo get por id*/
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(path = "/{id}")
    public Optional<CertEducacionModel> obtenerCertEducacionPorID(@PathVariable("id") Long id){
        return this.certEducacionService.obtenerCertEducacionPorID(id);
    }

    /*metodo eliminar por id*/
    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping(path = "/{id}")
    public String eliminarCertEducacion( @PathVariable("id") Long id){
        boolean ok = this.certEducacionService.eliminarCertEducacion(id);
        if (ok){
            return  "Eliminado correctamente";
        }else{
            return "error al eliminar";
        }
    }

    /* metodo put*/
    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping
    public CertEducacionModel actualizarCertEducacion(@RequestBody CertEducacionModel educacion){
        return this.certEducacionService.actualizarEducacion(educacion);
    }
}
