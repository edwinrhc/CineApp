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
import org.springframework.web.multipart.MultipartFile;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;



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
    public String guardar(Pelicula pelicula, BindingResult result, RedirectAttributes attributes,
                          @RequestParam("archivoImagen") MultipartFile multiPart, HttpServletRequest request){

        // Si existe errores
        if(result.hasErrors()){
            System.out.println("Existieron errores " + pelicula);
            return "peliculas/formPelicula";
        }

        if(!multiPart.isEmpty()){
           String nombreImagen = guardarImagen(multiPart, request);
           pelicula.setImagen(nombreImagen);
            System.out.println("Nombre de la imagen subida" + nombreImagen);
        }


        servicePelicula.insertar(pelicula);

        attributes.addFlashAttribute("mensaje", "El registro fue guardado");


        return "redirect:/peliculas/index";

    }

    private String guardarImagen(MultipartFile multiPart, HttpServletRequest request){
        // Obtenemos el nombre original del archivo
        String nombreOriginal = multiPart.getOriginalFilename();
        // Obtenemos la ruta ABSOLUTA  del directorio images
        // apache-tomcat/webapss/cineapp/resources/images/
        String rutaFinal = request.getServletContext().getRealPath("/resources/images/");
        try {
            //Formamos el nombre del archivo para guardarlo en el disco duro
            File imageFile = new File(rutaFinal + nombreOriginal);
            // Aquí se guarda físicamente el archivo en el disco duro
            multiPart.transferTo(imageFile);
            return nombreOriginal;
        }catch ( IOException e){
            System.out.println("Error "+ e.getMessage());
            return null;
        }
    }


    //Formato de fecha personalizando el DataBinding tipo  Date
    @InitBinder
    public void initBinder(WebDataBinder binder){
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat,false));
    }




}
