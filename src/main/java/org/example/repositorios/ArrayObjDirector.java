package org.example.repositorios;

import javax.swing.JOptionPane;

import org.example.modelos.Director;

public class ArrayObjDirector {
    private int tamano;
    private Director[] directores;

    public void agregarDirectores() {
        this.tamano = Integer.parseInt(JOptionPane.showInputDialog("¿Cuántos directores desea registrar?"));
        this.directores = new Director[tamano];
        Long id = 0L;

        for (int i = 0; i < tamano; i++) {
            try {
                id = Long.parseLong(JOptionPane.showInputDialog("Ingrese id del director: " + (i + 1)));
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Sólo se aceptan NÚMEROS para el id del director.");
                System.exit(0); // Se puede mejorar
            }
            String nombre = JOptionPane.showInputDialog("Ingrese el nombre del director: " + (i + 1));
            String apellido = JOptionPane.showInputDialog("Ingrese el apellido del director: " + (i + 1));

            Director director = new Director(id, nombre, apellido);

            this.directores[i] = director;
        }
    }

    public Director obtenerDirectorPorId() {
        Long id = Long
                .parseLong(JOptionPane.showInputDialog("Ingrese el ID del director a buscar para asignarlo al vuelo:"));

        if (directores == null) {
            JOptionPane.showMessageDialog(null, "No hay directores registrados.");
            return null;
        } else {
            for (int i = 0; i < directores.length; i++) {
                if (directores[i].getId() == id) {
                    return directores[i];
                }
            }
        }
        return null;
    }

    public void mostrarDirectores() {
        StringBuilder totalDirectores = new StringBuilder();

        if (directores == null) {
            JOptionPane.showMessageDialog(null, "No hay directores registrados.");
            return;
        } else {
            totalDirectores.append("=== DIRECTORES REGISTRADOS ===\n\n");
            for (int i = 0; i < directores.length; i++) {
                totalDirectores.append(directores[i]).append("\n");
            }
            JOptionPane.showMessageDialog(null, totalDirectores.toString());
        }

    }

}
