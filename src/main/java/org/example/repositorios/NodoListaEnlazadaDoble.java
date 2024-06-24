package org.example.repositorios;

import org.example.modelos.Vuelo;

public class NodoListaEnlazadaDoble {

    private Vuelo vuelo;
    private NodoListaEnlazadaDoble siguiente;
    private NodoListaEnlazadaDoble anterior;

    public NodoListaEnlazadaDoble(Vuelo vuelo) {
        this.vuelo = vuelo;
    }

    public Vuelo getVuelo() {
        return vuelo;
    }

    public void setVuelo(Vuelo vuelo) {
        this.vuelo = vuelo;
    }

    public NodoListaEnlazadaDoble getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoListaEnlazadaDoble siguiente) {
        this.siguiente = siguiente;
    }

    public NodoListaEnlazadaDoble getAnterior() {
        return anterior;
    }

    public void setAnterior(NodoListaEnlazadaDoble anterior) {
        this.anterior = anterior;
    }

    @Override
    public String toString() {
        return "Nodo [vuelo: " + vuelo + ", siguiente: " + siguiente + ", anterior: " + anterior + "]";
    }

}
