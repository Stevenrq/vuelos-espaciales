package org.example.repositorios;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import org.example.modelos.Director;

public class ArrayListDirector {
    private List<Director> directores;

    public ArrayListDirector() {
        this.directores = new ArrayList<>();
    }

    public List<Director> getDirectores() {
        return directores;
    }

    public void setDirectores(List<Director> directores) {
        this.directores = directores;
    }

    public void agregarDirector(Director director) {
        directores.add(director);
    }

    public Director obtenerDirectorPorId() {
        Long id = Long.parseLong(JOptionPane.showInputDialog("Ingrese el ID del director a buscar:"));
        for (Director director : directores) {
            if (director.getId() == id) {
                return director;
            }
        }
        return null;
    }

    public void mostrarDirectores() {
        StringBuilder sb = new StringBuilder();
        sb.append("=== DIRECTORES REGISTRADOS ===\n\n");

        for (Director director : directores) {
            sb.append(director).append("\n");
        }
        JOptionPane.showMessageDialog(null, sb.toString());
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((directores == null) ? 0 : directores.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ArrayListDirector other = (ArrayListDirector) obj;
        if (directores == null) {
            if (other.directores != null)
                return false;
        } else if (!directores.equals(other.directores))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "ArrayListDirector [directores=" + directores + "]";
    }
}
