package org.example.repositorios;

import javax.swing.JOptionPane;

import org.example.modelos.Vuelo;

public class ListaEnlazadaDobleVuelos {

    private NodoListaEnlazadaDoble primero;
    private NodoListaEnlazadaDoble ultimo;

    public ListaEnlazadaDobleVuelos() {
        this.primero = null;
        this.ultimo = null;
    }

    public NodoListaEnlazadaDoble getPrimero() {
        return primero;
    }

    public void setPrimero(NodoListaEnlazadaDoble primero) {
        this.primero = primero;
    }

    public NodoListaEnlazadaDoble getUltimo() {
        return ultimo;
    }

    public void setUltimo(NodoListaEnlazadaDoble ultimo) {
        this.ultimo = ultimo;
    }

    public void insertarInicio(Vuelo vuelo) {
        NodoListaEnlazadaDoble nuevoNodo = new NodoListaEnlazadaDoble(vuelo);
        if (primero == null) {
            primero = ultimo = nuevoNodo;
        } else {
            nuevoNodo.setSiguiente(primero);
            primero.setAnterior(nuevoNodo);
            primero = nuevoNodo;
        }
    }

    public void insertarFinal(Vuelo vuelo) {
        NodoListaEnlazadaDoble nodoNuevo = new NodoListaEnlazadaDoble(vuelo);
        if (ultimo == null) {
            primero = ultimo = nodoNuevo;
        } else {
            ultimo.setSiguiente(nodoNuevo);
            nodoNuevo.setAnterior(ultimo);
            ultimo = nodoNuevo;
        }
    }

    public Vuelo buscarPorNumeroVuelo(int numeroVuelo) {
        NodoListaEnlazadaDoble actual = primero;
        while (actual != null) {
            if (actual.getVuelo().getNumeroVuelo() == numeroVuelo) {
                return actual.getVuelo();
            }
            actual = actual.getSiguiente();
        }
        JOptionPane.showMessageDialog(null, "Vuelo no encontrado.");
        return null;
    }

    public Vuelo eliminarVueloPorNumeroVuelo(int numeroVuelo) {
        NodoListaEnlazadaDoble actual = primero;

        // Recorrer la lista hasta encontrar el nodo a eliminar
        while (actual != null && actual.getVuelo().getNumeroVuelo() != numeroVuelo) {
            actual = actual.getSiguiente();
        }

        if (actual.getVuelo().getNumeroVuelo() == numeroVuelo) {
            return actual.getVuelo();
        }


        if (actual != null) {
            // Si el nodo es el primero
            if (actual == primero) {
                primero = actual.getSiguiente();
                if (primero != null) {
                    primero.setAnterior(null);
                }
                // Si el nodo es el último
            } else if (actual == ultimo) {
                ultimo = actual.getAnterior();
                if (ultimo != null) {
                    ultimo.setSiguiente(null);
                }
                // Si el nodo es el intermedio
            } else {
                actual.getAnterior().setSiguiente(actual.getSiguiente());
                actual.getSiguiente().setAnterior(actual.getAnterior());
            }
        }

        if (actual.getVuelo().getNumeroVuelo() != numeroVuelo) {
            JOptionPane.showMessageDialog(null, "Vuelo no encontrado");
            return null;
        }
        return null;
    }

    public void mostrarVuelos() {
        NodoListaEnlazadaDoble actual = primero;
        StringBuilder totalVuelos = new StringBuilder();

        if (primero == null) {
            JOptionPane.showMessageDialog(null, "No hay vuelos registrados.");
            return;
        } else {

            totalVuelos.append(" === VUELOS REGISTRADOS ===\n\n");
            while (actual != null) {
                totalVuelos.append(actual.getVuelo()).append("\n");
                actual = actual.getSiguiente();
            }
            JOptionPane.showMessageDialog(null, totalVuelos.toString());
        }
    }

}

