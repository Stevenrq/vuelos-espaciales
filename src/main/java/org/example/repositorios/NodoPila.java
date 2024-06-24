package org.example.repositorios;

import org.example.modelos.Vuelo;

public class NodoPila {

    private Vuelo vuelo;
    private NodoPila siguiente;

    public NodoPila(Vuelo vuelo) {
        this.vuelo = vuelo;
    }

    public Vuelo getVuelo() {
        return vuelo;
    }

    public void setVuelo(Vuelo vuelo) {
        this.vuelo = vuelo;
    }

    public NodoPila getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoPila siguiente) {
        this.siguiente = siguiente;
    }

    @Override
    public String toString() {
        return "Nodo [vuelo=" + vuelo + ", siguiente=" + siguiente + "]";
    }
}
