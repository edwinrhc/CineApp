package net.itinajero.app.service;

import net.itinajero.app.model.Pelicula;

import java.util.List;

public interface IPeliculasService {

    void insertar(Pelicula pelicula);

    List<Pelicula> buscarTodas();

    Pelicula buscarPorId(int idPelicula);

}
