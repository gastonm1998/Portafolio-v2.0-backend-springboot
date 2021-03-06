package com.backend.portafoliobackend.controllers;


import com.backend.portafoliobackend.models.CertHtmlCssModel;
import com.backend.portafoliobackend.models.CertJavaScriptModel;
import com.backend.portafoliobackend.services.CertHtmlCssService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/cssHtml")
public class CertHtmlCssController {
    /*Inyeccion de dependencia desde el service*/
    @Autowired
    CertHtmlCssService certHtmlCssService;

    /*metodo get all*/
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping()
    public ArrayList<CertHtmlCssModel> obtenerCssHtml(){

        return certHtmlCssService.obtenerCssHtml();
    }

    /* metodo post*/
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping
    public CertHtmlCssModel guardarCssHtml(@RequestBody CertHtmlCssModel cssHtml){
        return this.certHtmlCssService.guardarCssHtml(cssHtml);
    }

    /*Metodo get por id*/
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(path = "/{id}")
    public Optional<CertHtmlCssModel> obtenerCssHtmlPorID(@PathVariable("id") Long id){
        return this.certHtmlCssService.obtenerCssHtmlPorID(id);
    }

    /*metodo eliminar por id*/
    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping(path = "/{id}")
    public String eliminarCssHtml( @PathVariable("id") Long id){
        boolean ok = this.certHtmlCssService.eliminarCssHtml(id);
        if (ok){
            return  "Eliminado correctamente";
        }else{
            return "error al eliminar";
        }
    }

    /* metodo put*/
    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping
    public CertHtmlCssModel actualizarCssHtml(@RequestBody CertHtmlCssModel cssHtml){
        return this.certHtmlCssService.actualizarCssHtml(cssHtml);
    }
}
