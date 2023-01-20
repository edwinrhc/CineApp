package net.itinajero.app.controller;

import net.itinajero.app.model.Pelicula;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("/peliculas")
public class PeliculasController {

    @GetMapping("/create")
    public String crear(){
        return "peliculas/formPelicula";
    }


    @PostMapping("/save")
    public String guardar( Pelicula pelicula, BindingResult result){

        // Si existe errores
        if(result.hasErrors()){
            System.out.println("Existieron errores " + pelicula);
            return "peliculas/formPelicula";
        }

       /* for(ObjectError error: result.getAllErrors()){
            System.out.println(error.getDefaultMessage());
        } */

        System.out.println("Recibiendo objeto pelicula " + pelicula);

        return "peliculas/formPelicula";

    }

    //Formato de fecha personalizando el DataBinding tipo  Date
    @InitBinder
    public void initBinder(WebDataBinder binder){
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat,false));
    }




}
