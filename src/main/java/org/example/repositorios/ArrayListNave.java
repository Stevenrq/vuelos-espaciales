package org.example.repositorios;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import org.example.modelos.Nave;

public class ArrayListNave {
    private List<Nave> naves;

    public ArrayListNave() {
        this.naves = new ArrayList<>();
    }

    public List<Nave> getNaves() {
        return naves;
    }

    public void setNaves(List<Nave> naves) {
        this.naves = naves;
    }

    public void agregarNave(Nave nave) {
        naves.add(nave);
    }

    public Nave obtenerNavePorPlaca() {
        String placa = JOptionPane.showInputDialog("Ingrese la PLACA de la nave a buscar:");
        for (Nave nave : naves) {
            if (nave.getPlaca().equals(placa)) {
                return nave;
            }
        }
        return null;
    }

    public void mostrarNaves() {
        StringBuilder sb = new StringBuilder();
        sb.append("=== NAVES REGISTRADAS ===\n\n");

        for (Nave nave : naves) {
            sb.append(nave).append("\n");
        }
        JOptionPane.showMessageDialog(null, sb.toString());
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((naves == null) ? 0 : naves.hashCode());
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
        ArrayListNave other = (ArrayListNave) obj;
        if (naves == null) {
            if (other.naves != null)
                return false;
        } else if (!naves.equals(other.naves))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "ArrayListNave [naves=" + naves + "]";
    }

}
