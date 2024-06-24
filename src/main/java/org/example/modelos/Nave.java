package org.example.modelos;

public class Nave {
    private String placa;
    private String nombre;
    private String tipoNave;

    public Nave() {
    }

    public Nave(String placa, String nombre, String tipoNave) {
        this.placa = placa;
        this.nombre = nombre;
        this.tipoNave = tipoNave;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipoNave() {
        return tipoNave;
    }

    public void setTipoNave(String tipoNave) {
        this.tipoNave = tipoNave;
    }

    @Override
    public String toString() {
        return "Nave [placa=" + placa + ", nombre=" + nombre + ", tipoNave=" + tipoNave + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((placa == null) ? 0 : placa.hashCode());
        result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
        result = prime * result + ((tipoNave == null) ? 0 : tipoNave.hashCode());
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
        Nave other = (Nave) obj;
        if (placa == null) {
            if (other.placa != null)
                return false;
        } else if (!placa.equals(other.placa))
            return false;
        if (nombre == null) {
            if (other.nombre != null)
                return false;
        } else if (!nombre.equals(other.nombre))
            return false;
        if (tipoNave == null) {
            if (other.tipoNave != null)
                return false;
        } else if (!tipoNave.equals(other.tipoNave))
            return false;
        return true;
    }

}
