package net.itinajero.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/noticias")
public class NoticiasController {

    @GetMapping(value = "create")
    public String crear(){



        return "noticias/formNoticia";
    }

}
