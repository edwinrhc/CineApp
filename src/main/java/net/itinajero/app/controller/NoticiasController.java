package net.itinajero.app.controller;

import net.itinajero.app.model.Noticia;
import net.itinajero.app.service.INoticiasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping(value = "/noticias")
public class NoticiasController {

    @Autowired
    private INoticiasService serviceNoticia;

    @GetMapping(value = "/create")
    public String crear(){

        return "noticias/formNoticia";
    }

    @PostMapping("/save")
    public String guardar(@RequestParam("titulo") String titulo,
                          @RequestParam("estatus") String estatus,
                          @RequestParam("detalle") String detalle)
    {


        Noticia noticia = new Noticia();
        noticia.setTitulo(titulo);
        noticia.setEsttus(estatus);
        noticia.setDetalle(detalle);

        // Pendiente: Guardar el objeto noticia  en la BD
        serviceNoticia.guardar(noticia);



        return "noticias/formNoticia";
    }

}
