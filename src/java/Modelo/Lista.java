package Modelo;

import java.util.ArrayList;

/**
 *
 * @author manol
 */
public class Lista {

    private ArrayList<Persona> listaPersona;
    private ArrayList<Vehiculo> listaVehiculo;

    public Lista() {
        this.listaPersona = new ArrayList<>();
        this.listaVehiculo = new ArrayList<>();
    }

    public Lista(ArrayList<Persona> listaPersona, ArrayList<Vehiculo> listaVehiculo) {
        this.listaPersona = listaPersona;
        this.listaVehiculo = listaVehiculo;
    }

    public String recorrerListaPersona() {
        String lista = "";
        for (Persona persona : listaPersona) {
            lista += persona.toString();
        }
        return lista;
    }
    
    

    public String recorrerListaVehiculo() {
        String lista = "";
        for (Vehiculo vehiculo : listaVehiculo) {
            lista += vehiculo.toString() + "\n";
        }
        return lista;
    }

    @Override
    public String toString() {
        return "Lista de Personas: " + recorrerListaPersona() + "\n Lista de Vehiculos: " + recorrerListaVehiculo();
    }

    public ArrayList<Persona> getListaPersona() {
        return listaPersona;
    }

    public void setListaPersona(ArrayList<Persona> listaPersona) {
        this.listaPersona = listaPersona;
    }

    public ArrayList<Vehiculo> getListaVehiculo() {
        return listaVehiculo;
    }

    public void setListaVehiculo(ArrayList<Vehiculo> listaVehiculo) {
        this.listaVehiculo = listaVehiculo;
    }

}
