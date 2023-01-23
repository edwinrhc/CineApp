package net.itinajero.app.controller;

import net.itinajero.app.model.Pelicula;
import net.itinajero.app.service.IPeliculasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/peliculas")
public class PeliculasController {

    @Autowired
    private IPeliculasService servicePelicula;

    @GetMapping("/index")
    public String mostrarIndex(Model model) {
        List<Pelicula> lista = servicePelicula.buscarTodas();
        model.addAttribute("peliculas", lista);
        return "peliculas/listPeliculas";
    }



    @GetMapping("/create")
    public String crear(){
        return "peliculas/formPelicula";
    }


    @PostMapping("/save")
    public String guardar(Pelicula pelicula, BindingResult result, RedirectAttributes attributes){

        // Si existe errores
        if(result.hasErrors()){
            System.out.println("Existieron errores " + pelicula);
            return "peliculas/formPelicula";
        }


        servicePelicula.insertar(pelicula);

        attributes.addFlashAttribute("mensaje", "El registro fue guardado");


        return "redirect:/peliculas/index";

    }






    //Formato de fecha personalizando el DataBinding tipo  Date
    @InitBinder
    public void initBinder(WebDataBinder binder){
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat,false));
    }




}
