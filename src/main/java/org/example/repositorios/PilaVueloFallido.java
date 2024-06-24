package org.example.repositorios;

import javax.swing.JOptionPane;

import org.example.modelos.Vuelo;

public class PilaVueloFallido {

    private NodoPila cima;

    public NodoPila getCima() {
        return cima;
    }

    public void setCima(NodoPila cima) {
        this.cima = cima;
    }

    public void agregarVueloFallido(Vuelo vuelo) {
        NodoPila nuevo = new NodoPila(vuelo);
        nuevo.setSiguiente(cima);
        cima = nuevo;
    }

    public boolean estaVacia() {
        return cima == null;
    }

    public Vuelo eliminarVuelo() {
        if (estaVacia()) {
            JOptionPane.showMessageDialog(null, "La pila está vacía.");
            return null;
        }
        Vuelo vuelo = cima.getVuelo();
        cima = cima.getSiguiente();
        return vuelo;
    }

    public void mostrarVuelosFallidos() {
        if (estaVacia()) {
            JOptionPane.showMessageDialog(null, "La pila está vacía.");
            return;
        }

        NodoPila actual = cima;
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
        return "PilaVueloFallido [cima=" + cima + "]";
    }
}

