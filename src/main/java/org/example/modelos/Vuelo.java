package org.example.modelos;

import java.time.LocalDateTime;

public class Vuelo {
    private Integer numeroVuelo;
    private String nombre;
    private LocalDateTime fecha;
    private Director director;
    private Nave nave;

    public Vuelo() {
    }

    public Vuelo(Integer numeroVuelo, String nombre, LocalDateTime fecha, Director director, Nave nave) {
        this.numeroVuelo = numeroVuelo;
        this.nombre = nombre;
        this.fecha = fecha;
        this.director = director;
        this.nave = nave;
    }

    public Integer getNumeroVuelo() {
        return numeroVuelo;
    }

    public void setNumeroVuelo(Integer numeroMision) {
        this.numeroVuelo = numeroMision;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    public Nave getNave() {
        return nave;
    }

    public void setNave(Nave nave) {
        this.nave = nave;
    }

    @Override
    public String toString() {
        return "Vuelo [numeroVuelo=" + numeroVuelo + ", nombre=" + nombre + ", fecha=" + fecha + ", director="
                + director + ", nave=" + nave + "]";
    }

}
