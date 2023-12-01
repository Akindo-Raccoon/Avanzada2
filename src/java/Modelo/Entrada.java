package Modelo;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author manol
 */
public class Entrada {

    private final String[] puertaPeatonal = {"Puerta Peatonal 1", "Puerta Peatonal 2",
        "Puerta Peatonal 3", "Puerta Peatonal 4", "Puerta Peatonal 5"};
    private final String[] puertaVehicular = {"Puerta Vehicular 1", "Puerta Vehicular 2",
        "Puerta Vehicular 3", "Puerta Vehicular 4", "Puerta Vehicular 5"};

    Map<String, Integer> entradaPersona;
    Map<String, Integer> entradaVehiculo;

    private int numTotal_entradaP;
    private int numTotal_entradaV;
    private int numTotal_salidaP;
    private int numTotal_salidaV;
    private Lista lista;

    public Entrada() {
        this.lista = new Lista();
        this.numTotal_entradaP = 0;
        this.numTotal_entradaV = 0;
        this.numTotal_salidaP = 0;
        this.numTotal_salidaV = 0;
        this.entradaPersona = new HashMap<>();
        this.entradaVehiculo = new HashMap<>();

        for (String gate : puertaPeatonal) {
            entradaPersona.put(gate, 0);
        }
        for (String gate : puertaVehicular) {
            entradaVehiculo.put(gate, 0);
        }
    }

    public void entradaPersona(String entrada, Persona persona) {
        switch (entrada) {
            case "Puerta Peatonal 1":
                entradaPersona.put(entrada, entradaPersona.get(entrada) + 1);
                break;
            case "Puerta Peatonal 2":
                entradaPersona.put(entrada, entradaPersona.get(entrada) + 1);
                break;
            case "Puerta Peatonal 3":
                entradaPersona.put(entrada, entradaPersona.get(entrada) + 1);
                break;
            case "Puerta Peatonal 4":
                entradaPersona.put(entrada, entradaPersona.get(entrada) + 1);
                break;
            case "Puerta Peatonal 5":
                entradaPersona.put(entrada, entradaPersona.get(entrada) + 1);
                break;
            default:
                throw new AssertionError();
        }
        numTotal_entradaP++;
        lista.getListaPersona().add(persona);
    }

    public void entradaVehiculo(String entrada, Vehiculo vehiculo) {
        switch (entrada) {
            case "Puerta Vehicular 1":
                entradaVehiculo.put(entrada, entradaVehiculo.get(entrada) + 1);
                break;
            case "Puerta Vehicular 2":
                entradaVehiculo.put(entrada, entradaVehiculo.get(entrada) + 1);
                break;
            case "Puerta Vehicular 3":
                entradaVehiculo.put(entrada, entradaVehiculo.get(entrada) + 1);
                break;
            case "Puerta Vehicular 4":
                entradaVehiculo.put(entrada, entradaVehiculo.get(entrada) + 1);
                break;
            case "Puerta Vehicular 5":
                entradaVehiculo.put(entrada, entradaVehiculo.get(entrada) + 1);
                break;

            default:
                throw new AssertionError();
        }
        numTotal_entradaV++;
        lista.getListaVehiculo().add(vehiculo);
    }

    public void salidaPersona(String salida, Persona persona) {
        if (numTotal_salidaP < numTotal_entradaP) {
            switch (salida) {
                case "Puerta Peatonal 1":
                    entradaPersona.put(salida, entradaPersona.get(salida) - 1);
                    break;
                case "Puerta Peatonal 2":
                    entradaPersona.put(salida, entradaPersona.get(salida) - 1);
                    break;
                case "Puerta Peatonal 3":
                    entradaPersona.put(salida, entradaPersona.get(salida) - 1);
                    break;
                case "Puerta Peatonal 4":
                    entradaPersona.put(salida, entradaPersona.get(salida) - 1);
                    break;
                case "Puerta Peatonal 5":
                    entradaPersona.put(salida, entradaPersona.get(salida) - 1);
                    break;

                default:
                    throw new AssertionError();
            }
            numTotal_salidaP++;
            lista.getListaPersona().remove(persona);
        } else {
            System.out.println("No hay mas personas registradas");
        }
    }

    public void salidaVehiculo(String salida, Vehiculo vehiculo) {
        if (numTotal_salidaV < numTotal_entradaV) {
            switch (salida) {
                case "Puerta Vehicular 1":
                    entradaVehiculo.put(salida, entradaVehiculo.get(salida) - 1);
                    break;
                case "Puerta Vehicular 2":
                    entradaPersona.put(salida, entradaVehiculo.get(salida) - 1);
                    break;
                case "Puerta Vehicular 3":
                    entradaVehiculo.put(salida, entradaVehiculo.get(salida) - 1);
                    break;
                case "Puerta Vehicular 4":
                    entradaVehiculo.put(salida, entradaVehiculo.get(salida) - 1);
                    break;
                case "Puerta Vehicular 5":
                    entradaVehiculo.put(salida, entradaVehiculo.get(salida) - 1);
                    break;

                default:
                    throw new AssertionError();
            }
            numTotal_salidaV++;
            lista.getListaVehiculo().remove(vehiculo);
        } else {
            System.out.println("No hay mas vehiculos registrados");
        }
    }

    public boolean institutoVacio() {
        return numTotal_entradaP == numTotal_salidaP && numTotal_entradaV == numTotal_salidaV;
    }

    @Override
    public String toString() {
        return " Entradas peatonales registradas: " + numTotal_entradaP
                + "\n Entradas vehiculares registradas: " + numTotal_entradaV
                + " Salidas peatonales registradas: " + numTotal_salidaP
                + "\n Salidas vehiculares registradas: " + numTotal_salidaV
                + "\n listaPersonas: " + lista.toString();
    }

    public int getNumTotal_entradaP() {
        return numTotal_entradaP;
    }

    public void setNumTotal_entradaP(int numTotal_entradaP) {
        this.numTotal_entradaP = numTotal_entradaP;
    }

    public int getNumTotal_entradaV() {
        return numTotal_entradaV;
    }

    public void setNumTotal_entradaV(int numTotal_entradaV) {
        this.numTotal_entradaV = numTotal_entradaV;
    }

    public Map<String, Integer> getEntradaPersona() {
        return entradaPersona;
    }

    public void setEntradaPersona(Map<String, Integer> entradaPersona) {
        this.entradaPersona = entradaPersona;
    }

    public Map<String, Integer> getEntradaVehiculo() {
        return entradaVehiculo;
    }

    public void setEntradaVehiculo(Map<String, Integer> entradaVehiculo) {
        this.entradaVehiculo = entradaVehiculo;
    }

    public int getNumTotal_salidaP() {
        return numTotal_salidaP;
    }

    public void setNumTotal_salidaP(int numTotal_salidaP) {
        this.numTotal_salidaP = numTotal_salidaP;
    }

    public int getNumTotal_salidaV() {
        return numTotal_salidaV;
    }

    public void setNumTotal_salidaV(int numTotal_salidaV) {
        this.numTotal_salidaV = numTotal_salidaV;
    }

    public Lista getLista() {
        return lista;
    }

    public void setLista(Lista lista) {
        this.lista = lista;
    }
}
