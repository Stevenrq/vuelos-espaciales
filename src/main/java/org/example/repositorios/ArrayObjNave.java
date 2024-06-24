package org.example.repositorios;

import javax.swing.JOptionPane;

import org.example.modelos.Nave;

public class ArrayObjNave {
    private int tamano;
    private Nave[] naves;

    public void agregarNaves() {
        this.tamano = Integer.parseInt(JOptionPane.showInputDialog("¿Cuántas naves desea registrar?"));
        this.naves = new Nave[tamano];

        for (int i = 0; i < tamano; i++) {
            String placa = JOptionPane.showInputDialog("Ingrese la placa de la nave: " + (i + 1));
            String nombre = JOptionPane.showInputDialog("Ingrese el nombre de la nave: " + (i + 1));
            String tipoNave = JOptionPane.showInputDialog("Ingrese el tipo de nave: " + (i + 1));

            Nave nave = new Nave(placa, nombre, tipoNave);

            this.naves[i] = nave;
        }
    }

    public Nave obtenerNavePorPlaca() {
        String placa = JOptionPane.showInputDialog("Ingrese la PLACA de la nave a buscar para asignarla al vuelo:");

        if (naves == null) {
            JOptionPane.showMessageDialog(null, "No hay naves registradas.");
            return null;
        } else {
            for (int i = 0; i < naves.length; i++) {
                if (naves[i].getPlaca().equals(placa)) {
                    return naves[i];
                }
            }
        }
        return null;
    }

    public void mostrarNaves() {
        StringBuilder totalNaves = new StringBuilder();

        if (naves == null) {
            JOptionPane.showMessageDialog(null, "No hay naves registradas.");
            return;
        } else {
            totalNaves.append("=== NAVES REGISTRADAS ===\n\n");
            for (int i = 0; i < naves.length; i++) {
                totalNaves.append(naves[i]).append("\n");
            }
            JOptionPane.showMessageDialog(null, totalNaves.toString());
        }

    }
}
