package net.itinajero.app.service;

import net.itinajero.app.model.Noticia;
import org.springframework.stereotype.Service;

@Service
public class NoticiaServiceImpl implements  INoticiasService{

    // Constructor vacio. Unicamente para imprimir un mensaje al crearse una instancia
    public NoticiaServiceImpl() {
        System.out.println("Creando una instancia de la clase NoticiasServiceImpl");
    }
    public void guardar(Noticia noticia) {
        System.out.println("Guadando el objeto " + noticia + " en la base de datos.");

    }
}
