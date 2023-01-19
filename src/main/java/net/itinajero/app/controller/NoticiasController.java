package net.itinajero.app.controller;

import net.itinajero.app.model.Noticia;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "/noticias")
public class NoticiasController {

    @GetMapping(value = "/create")
    public String crear(){

        return "noticias/formNoticia";
    }

    @PostMapping("/save")
    public String guardar(@RequestParam("titulo") String titulo, @RequestParam("estatus") String estatus, @RequestParam("detalle") String detalle){

        Noticia noticia = new Noticia();
        noticia.setTitulo(titulo);
        noticia.setEsttus(estatus);
        noticia.setDetalle(detalle);

        // Pendiente: Guardar el objeto noticia  en la BD

        System.out.println(noticia);


        return "noticias/formNoticia";
    }

}
