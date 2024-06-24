package org.example;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import javax.swing.JOptionPane;

import org.example.modelos.Director;
import org.example.modelos.Nave;
import org.example.modelos.Vuelo;
import org.example.repositorios.ArrayListDirector;
import org.example.repositorios.ArrayListNave;
import org.example.repositorios.ColaVueloFallido;
import org.example.repositorios.ListaEnlazadaDobleVuelos;
import org.example.repositorios.PilaVueloFallido;

public class App {

    /**
     * Muestra el menú de opciones.
     *
     * @return La opción elegida por el usuario.
     */
    public static int menu() {
        return Integer.parseInt(JOptionPane.showInputDialog("""
                Seleccione una opción:

                1. Agregar naves
                2. Agregar directores/as
                3. Agregar vuelos
                4. Consultar todos los vuelos de la lista
                5. Consultar un vuelo
                6. Marcar y procesar vuelos fallidos
                7. Consultar todos los vuelos fallidos

                Opcionales
                8. Mostrar todas las naves registradas
                9. Mostrar todos los directores registrados

                > Elija OTRA opción para salir del programa <

                """));
    }

    public static int menuVuelosFallidos() {
        return Integer.parseInt(JOptionPane.showInputDialog("""
                         Seleccione una opción:

                         1. Agregar vuelo fallido a la PILA.
                         2. Agregar vuelo fallido a la COLA.
                                \s
                \s"""));
    }

    public static int menuMostrarVuelosFallidos() {
        return Integer.parseInt(JOptionPane.showInputDialog("""
                         Seleccione una opción:

                         1. Mostrar vuelos fallidos de la PILA.
                         2. Mostrar vuelos fallidos de la COLA.
                                \s
                \s"""));
    }

    public static void main(String[] args) {
        int opcion;

        ArrayListNave arrayListNave = new ArrayListNave();
        ArrayListDirector arrayListDirector = new ArrayListDirector();
        ListaEnlazadaDobleVuelos listaEnlazadaDobleVuelos = new ListaEnlazadaDobleVuelos();

        PilaVueloFallido pilaVueloFallido = new PilaVueloFallido();
        ColaVueloFallido colaVueloFallido = new ColaVueloFallido();

        do {
            opcion = menu();
            switch (opcion) {
                // Agregar naves
                case 1:
                    String opcionR;
                    Nave naveA;
                    do {
                        String placa = JOptionPane.showInputDialog("Ingrese la PLACA de la nave:");
                        String nombre = JOptionPane.showInputDialog("Ingrese el NOMBRE de la nave");
                        String tipoNave = JOptionPane.showInputDialog("Ingrese el TIPO de nave:");

                        naveA = new Nave(placa, nombre, tipoNave);
                        arrayListNave.agregarNave(naveA);

                        opcionR = JOptionPane.showInputDialog("¿Desea registrar otra nave? (S/N)");

                        if (opcionR.equalsIgnoreCase("S")) {
                            placa = JOptionPane.showInputDialog("Ingrese la PLACA de la nave:");
                            nombre = JOptionPane.showInputDialog("Ingrese el NOMBRE de la nave");
                            tipoNave = JOptionPane.showInputDialog("Ingrese el TIPO de nave:");
                            naveA = new Nave(placa, nombre, tipoNave);
                            arrayListNave.agregarNave(naveA);
                        } else {
                            break;
                        }
                        opcionR = JOptionPane.showInputDialog("Desea registrar otra nave (S/N)");
                    } while (opcionR.equalsIgnoreCase("S"));

                    break;

                // Agregar directores
                case 2:
                    String opcionB;
                    Director directorA;
                    do {
                        long id = Long.parseLong(JOptionPane.showInputDialog("Ingrese el ID del director:"));
                        String nombre = JOptionPane.showInputDialog("Ingrese el NOMBRE del director");
                        String apellido = JOptionPane.showInputDialog("Ingrese el APELLIDO del director:");

                        directorA = new Director(id, nombre, apellido);
                        arrayListDirector.agregarDirector(directorA);

                        opcionB = JOptionPane.showInputDialog("¿Desea registrar otro director? (S/N)");

                        if (opcionB.equalsIgnoreCase("S")) {
                            id = Long.parseLong(JOptionPane.showInputDialog("Ingrese el ID del director:"));
                            nombre = JOptionPane.showInputDialog("Ingrese el NOMBRE del director");
                            apellido = JOptionPane.showInputDialog("Ingrese el APELLIDO del director:");
                            directorA = new Director(id, nombre, apellido);
                            arrayListDirector.agregarDirector(directorA);
                        } else {
                            break;
                        }
                        opcionB = JOptionPane.showInputDialog("Desea registrar otro director(S/N)");
                    } while (opcionB.equalsIgnoreCase("S"));
                    break;

                // Agregar vuelos
                case 3:
                    Integer numeroVuelo = Integer
                            .parseInt(JOptionPane.showInputDialog("Ingrese el número del vuelo:"));
                    String nombre = JOptionPane.showInputDialog("Ingrese el nombre del vuelo:");

                    LocalDateTime f = LocalDateTime.now();
                    // eliminar nanosegundos de la fecha
                    LocalDateTime fecha = f.truncatedTo(ChronoUnit.SECONDS);

                    Director director = arrayListDirector.obtenerDirectorPorId();
                    Nave nave = arrayListNave.obtenerNavePorPlaca();

                    if (director == null || nave == null) {
                        break;
                    } else {
                        Vuelo vuelo = new Vuelo(numeroVuelo, nombre, fecha, director, nave);
                        listaEnlazadaDobleVuelos.insertarInicio(vuelo);
                        listaEnlazadaDobleVuelos.mostrarVuelos();
                    }
                    break;

                // Consultar todos los vuelos
                case 4:
                    listaEnlazadaDobleVuelos.mostrarVuelos();
                    break;

                // Consultar un vuelo
                case 5:
                    String opcionV;
                    do {
                        int numVuelo = Integer
                                .parseInt(JOptionPane.showInputDialog("Ingrese el número del vuelo a buscar:"));
                        Vuelo vueloEncontrado = listaEnlazadaDobleVuelos.buscarPorNumeroVuelo(numVuelo);

                        if (vueloEncontrado == null) {
                            break;
                        } else {
                            JOptionPane.showMessageDialog(null, vueloEncontrado);
                        }

                        opcionV = JOptionPane.showInputDialog("¿Desea buscar otro vuelo? (S/N)");
                        if (opcionV.equalsIgnoreCase("S")) {
                            numVuelo = Integer
                                    .parseInt(JOptionPane.showInputDialog("Ingrese el número del vuelo a buscar:"));
                            vueloEncontrado = listaEnlazadaDobleVuelos.buscarPorNumeroVuelo(numVuelo);

                            if (vueloEncontrado == null) {
                                break;
                            } else {
                                JOptionPane.showMessageDialog(null, vueloEncontrado);
                            }
                        } else {
                            break;
                        }
                        opcionV = JOptionPane.showInputDialog("¿Desea buscar otro vuelo? (S/N)");
                    } while (opcionV.equalsIgnoreCase("S"));
                    break;

                // Marcar y procesar vuelos fallidos
                case 6:
                    // Marcar
                    int opcionVF = menuVuelosFallidos();
                    int numeroVueloF;
                    Vuelo vueloF;

                    if (opcionVF == 1) {
                        numeroVueloF = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de vuelo:"));
                        vueloF = listaEnlazadaDobleVuelos.eliminarVueloPorNumeroVuelo(numeroVueloF);
                        if (vueloF == null) {
                            break;
                        }
                        pilaVueloFallido.agregarVueloFallido(vueloF);
                        JOptionPane.showMessageDialog(null, "Vuelo fallido agregado a la PILA exitosamente.");
                        break;
                    } else if (opcionVF == 2) {
                        numeroVueloF = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de vuelo:"));
                        vueloF = listaEnlazadaDobleVuelos.eliminarVueloPorNumeroVuelo(numeroVueloF);
                        if (vueloF == null) {
                            break;
                        }
                        colaVueloFallido.agregar(vueloF);
                        JOptionPane.showMessageDialog(null, "Vuelo fallido agregado a la COLA exitosamente.");
                        break;
                    } else if (opcionVF != 1 || opcionVF != 2) {
                        break;
                    }

                    // Procesar
                    String opcionEliminar;
                    if (opcionVF == 1) {
                        opcionEliminar = JOptionPane.showInputDialog("¿Desea eliminar un vuelo fallido de la PILA? (S/N)");
                        if (opcionEliminar.equalsIgnoreCase("S")) {
                            pilaVueloFallido.eliminarVuelo();
                        }
                        break;
                    } else if (opcionVF == 2) {
                        opcionEliminar = JOptionPane.showInputDialog("¿Desea eliminar un vuelo fallido de la COLA? (S/N)");
                        if (opcionEliminar.equalsIgnoreCase("S")) {
                            colaVueloFallido.eliminar();
                        }
                        break;
                    }
                    break;

                // Consultar todos los vuelos fallidos
                case 7:
                    int opcionMVF = menuMostrarVuelosFallidos();

                    if (opcionMVF == 1) {
                        pilaVueloFallido.mostrarVuelosFallidos();
                    } else if (opcionMVF == 2) {
                        colaVueloFallido.mostrarVuelosFallidos();
                    }
                    break;

                // Mostrar todas las naves registradas
                case 8:
                    arrayListNave.mostrarNaves();
                    break;

                // Mostrar todos los directores registrados
                case 9:
                    arrayListDirector.mostrarDirectores();
                    break;

                default:
                    System.exit(0);
                    break;
            }
        } while (opcion < 10);
    }
}
