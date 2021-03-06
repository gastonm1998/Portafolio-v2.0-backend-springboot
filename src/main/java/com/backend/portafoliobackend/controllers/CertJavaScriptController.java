package com.backend.portafoliobackend.controllers;

import com.backend.portafoliobackend.models.CertJavaScriptModel;
import com.backend.portafoliobackend.models.ExperienciaModel;
import com.backend.portafoliobackend.services.CertJavaScriptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/javaScript")
public class CertJavaScriptController {

    /*Inyeccion de dependencia desde el service*/
    @Autowired
    CertJavaScriptService certJavaScriptService;

    /*metodo get all*/
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping()
    public ArrayList<CertJavaScriptModel> obtenerJavaScript(){

        return certJavaScriptService.obtenerJavaScript();
    }

    /* metodo post*/
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping
    public CertJavaScriptModel guardarJavaScript(@RequestBody CertJavaScriptModel javaScript){
        return this.certJavaScriptService.guardarJavaScript(javaScript);
    }

    /*Metodo get por id*/
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(path = "/{id}")
    public Optional<CertJavaScriptModel> obtenerJavaScriptPorID(@PathVariable("id") Long id){
        return this.certJavaScriptService.obtenerJavaScriptPorID(id);
    }

    /*metodo eliminar por id*/
    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping(path = "/{id}")
    public String eliminarJavaScript( @PathVariable("id") Long id){
        boolean ok = this.certJavaScriptService.eliminarJavaScript(id);
        if (ok){
            return  "Eliminado correctamente";
        }else{
            return "error al eliminar";
        }
    }

    /* metodo put*/
    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping
    public CertJavaScriptModel actualizarJavaScript(@RequestBody CertJavaScriptModel javaScript){
        return this.certJavaScriptService.actualizarJavaScript(javaScript);
    }
}
