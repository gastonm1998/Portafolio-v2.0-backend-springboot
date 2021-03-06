package com.backend.portafoliobackend.controllers;

import com.backend.portafoliobackend.models.CertIotModel;
import com.backend.portafoliobackend.models.CertJavaScriptModel;
import com.backend.portafoliobackend.services.CertIotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/iot")
public class CertIotController {

    /*Inyeccion de dependencia desde el service*/
    @Autowired
    CertIotService certIotService;

    /*metodo get all*/
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping()
    public ArrayList<CertIotModel> obtenerIot(){

        return certIotService.obtenerIot();
    }

    /* metodo post*/
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping
    public CertIotModel guardarIot(@RequestBody CertIotModel iot){
        return this.certIotService.guardarIot(iot);
    }

    /*Metodo get por id*/
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(path = "/{id}")
    public Optional<CertIotModel> obtenerIotPorID(@PathVariable("id") Long id){
        return this.certIotService.obtenerIotPorID(id);
    }

    /*metodo eliminar por id*/
    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping(path = "/{id}")
    public String eliminarIot( @PathVariable("id") Long id){
        boolean ok = this.certIotService.eliminarIot(id);
        if (ok){
            return  "Eliminado correctamente";
        }else{
            return "error al eliminar";
        }
    }

    /* metodo put*/
    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping
    public CertIotModel actualizarIot(@RequestBody CertIotModel iot){
        return this.certIotService.guardarIot(iot);
    }
}
