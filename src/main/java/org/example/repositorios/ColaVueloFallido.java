package org.example.repositorios;

import javax.swing.JOptionPane;

import org.example.modelos.Vuelo;

public class ColaVueloFallido {

    private NodoCola frente;
    private NodoCola atras;

    public NodoCola getFrente() {
        return frente;
    }

    public void setFrente(NodoCola frente) {
        this.frente = frente;
    }

    public NodoCola getAtras() {
        return atras;
    }

    public void setAtras(NodoCola atras) {
        this.atras = atras;
    }

    public boolean estaVacia() {
        return frente == null;
    }

    public void agregar(Vuelo vuelo) {
        NodoCola nuevo = new NodoCola(vuelo);
        if (estaVacia()) {
            frente = nuevo;
            atras = nuevo;
        } else {
            atras.setSiguiente(nuevo);
            atras = nuevo;
        }
    }

    public Vuelo eliminar() {
        if (estaVacia()) {
            JOptionPane.showMessageDialog(null, "La cola está vacía.");
            return null;
        }
        Vuelo vuelo = frente.getVuelo();
        frente = frente.getSiguiente();
        if (frente == null) {
            atras = null;
        }
        return vuelo;
    }

    public void mostrarVuelosFallidos() {
        if (estaVacia()) {
            JOptionPane.showMessageDialog(null, "La cola está vacía.");
            return;
        }
        NodoCola actual = frente;
        StringBuilder sb = new StringBuilder();
        sb.append("=== VUELOS FALLIDOS ===\n\n");

        while (actual != null) {
            sb.append(actual.getVuelo()).append("\n");
            actual = actual.getSiguiente();
        }
        JOptionPane.showMessageDialog(null, sb.toString());
    }

    @Override
    public String toString() {
        return "ColaVueloFallido [frente=" + frente + ", atras=" + atras + "]";
    }
}

