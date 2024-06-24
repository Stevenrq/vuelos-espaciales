package org.example.repositorios;

import org.example.modelos.Vuelo;

public class NodoCola {

    private Vuelo vuelo;
    private NodoCola siguiente;

    public NodoCola(Vuelo vuelo) {
        this.vuelo = vuelo;
    }

    public Vuelo getVuelo() {
        return vuelo;
    }

    public void setVuelo(Vuelo vuelo) {
        this.vuelo = vuelo;
    }

    public NodoCola getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoCola siguiente) {
        this.siguiente = siguiente;
    }

    @Override
    public String toString() {
        return "Nodo [vuelo=" + vuelo + ", siguiente=" + siguiente + "]";
    }
}
