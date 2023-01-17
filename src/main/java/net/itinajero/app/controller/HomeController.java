package net.itinajero.app.controller;

import net.itinajero.app.model.Pelicula;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

@Controller
public class HomeController {

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String goHome() {
        return "home";
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String mostrarPrincipal(Model model) {

        List<Pelicula> peliculas = getLista();
     //   peliculas.add("Rapido y Furiosos");
     //   peliculas.add("El aro 2");
     //   peliculas.add("Aliens");
        model.addAttribute("peliculas", peliculas);

        return "home";
    }


    @RequestMapping(value = "/detail")
    public String mostrarDetalle(Model model) {
        String tituloPelicula = "Rapidos y Furiosos";
        int duracion = 136;
        double precioEntrada = 50;

        model.addAttribute("titulo", tituloPelicula);
        model.addAttribute("duraccion", duracion);
        model.addAttribute("precio", precioEntrada);

        return "detalle";
    }

	/***
	 *
	 * Metodo para generar una lista de objetos de Modelo (Pelicula)
	 *
	 */
	private List<Pelicula> getLista(){

		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");  // Formato a la fecha de estreno
		List<Pelicula> lista = null;

		try {
			lista = new LinkedList<Pelicula>();

			Pelicula pelicula1 = new Pelicula();
            pelicula1.setId(1);
            pelicula1.setTitulo("Power Rangers");
            pelicula1.setDuracion(120);
            pelicula1.setClasificacion("B");
            pelicula1.setGenero("Aventura");
            pelicula1.setFechaEstreno(formatter.parse("12-05-2022"));

            Pelicula pelicula2= new Pelicula();
            pelicula2.setId(2);
            pelicula2.setTitulo("La bella y la bestia");
            pelicula2.setDuracion(132);
            pelicula2.setClasificacion("A");
            pelicula2.setGenero("Infantil");
            pelicula2.setFechaEstreno(formatter.parse("12-02-2022"));
            pelicula2.setImagen("estreno6.png");

            Pelicula pelicula3= new Pelicula();
            pelicula3.setId(3);
            pelicula3.setTitulo("ContraTiempo");
            pelicula3.setDuracion(106);
            pelicula3.setClasificacion("B");
            pelicula3.setGenero("Thriller");
            pelicula3.setFechaEstreno(formatter.parse("10-03-2022"));
            pelicula3.setImagen("estreno7.png");

            Pelicula pelicula4= new Pelicula();
            pelicula4.setId(4);
            pelicula4.setTitulo("Kon La Isla Calavera");
            pelicula4.setDuracion(118);
            pelicula4.setClasificacion("B");
            pelicula4.setGenero("Accion y Aventura");
            pelicula4.setFechaEstreno(formatter.parse("06-06-2017"));
            pelicula4.setImagen("estreno4.png");
            pelicula4.setEstatus("Inactiva");

            Pelicula pelicula5= new Pelicula();
            pelicula5.setId(5);
            pelicula5.setTitulo("Life: Vida Inteligente");
            pelicula5.setDuracion(104);
            pelicula5.setClasificacion("B");
            pelicula5.setGenero("Drama");
            pelicula5.setFechaEstreno(formatter.parse("10-06-2017"));
            pelicula5.setImagen("estreno5.png");
            pelicula5.setEstatus("Inactiva");

            // Agregamos a los obejtos Pelicula

            lista.add(pelicula1);
            lista.add(pelicula2);
            lista.add(pelicula3);
            lista.add(pelicula4);
            lista.add(pelicula5);
            return lista;

		} catch (ParseException e) {
            System.out.println("Error: "+ e.getMessage());
            return  null;
        }


    }

}
