package net.itinajero.app.model;

import java.util.Date;

public class Noticia {

    private int id;
    private String titulo;
    private Date fecha;
    private String detalle;
    private String esttus;

    public Noticia(){
        this.fecha = new Date();
        this.esttus = "Activa";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public String getEsttus() {
        return esttus;
    }

    public void setEsttus(String esttus) {
        this.esttus = esttus;
    }

    @Override
    public String toString() {
        return "Noticia{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", fecha=" + fecha +
                ", detalle='" + detalle + '\'' +
                ", esttus='" + esttus + '\'' +
                '}';
    }
}
