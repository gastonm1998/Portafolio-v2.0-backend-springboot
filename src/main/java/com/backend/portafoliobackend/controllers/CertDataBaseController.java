package com.backend.portafoliobackend.controllers;

import com.backend.portafoliobackend.models.CertDataBaseModel;
import com.backend.portafoliobackend.models.CertJavaScriptModel;
import com.backend.portafoliobackend.services.CertDataBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/dataBase")
public class CertDataBaseController {

    /*Inyeccion de dependencia desde el service*/
    @Autowired
    CertDataBaseService certDataBaseService;

    /*metodo get all*/
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping()
    public ArrayList<CertDataBaseModel> obtenerDataBase(){

        return certDataBaseService.obtenerDataBase();
    }

    /* metodo post*/
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping
    public CertDataBaseModel guardarDataBase(@RequestBody CertDataBaseModel dataBase){
        return this.certDataBaseService.guardarDataBase(dataBase);
    }

    /*Metodo get por id*/
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(path = "/{id}")
    public Optional<CertDataBaseModel> obtenerDataBasePorID(@PathVariable("id") Long id){
        return this.certDataBaseService.obtenerDataBasePorID(id);
    }

    /*metodo eliminar por id*/
    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping(path = "/{id}")
    public String eliminarDataBase( @PathVariable("id") Long id){
        boolean ok = this.certDataBaseService.eliminarDataBase(id);
        if (ok){
            return  "Eliminado correctamente";
        }else{
            return "error al eliminar";
        }
    }

    /* metodo put*/
    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping
    public CertDataBaseModel actualizarDataBase(@RequestBody CertDataBaseModel dataBase){
        return this.certDataBaseService.actualizarDataBase(dataBase);
    }
}
