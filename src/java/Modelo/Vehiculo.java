package Modelo;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author manol
 */
public abstract class Vehiculo {

    private String placa;
    private String marca;
    private String tipo;
    private Persona persona;

    public Vehiculo() {
        this.placa = "";
        this.marca = "";
        this.tipo = "";
        this.persona = null;
    }

    public Vehiculo(String placa, String marca, String tipo, Persona persona) {
        this.placa = placa;
        this.marca = marca;
        this.tipo = tipo;
        this.persona = persona;
    }

    public Object[] datos() {
        Object[] data = {marca, placa, tipo, persona.getId(), persona.getNombre()};
        return data;
    }

    @Override
    public String toString() {
        return "\n Placa: " + placa + "\n Marca: " + marca + "\n Tipo: "
                + tipo + "\n Nombre: " + persona.getNombre() + "\n Identificacion: " + persona.getId();
    }

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Vehiculo other = (Vehiculo) obj;
        if (!Objects.equals(this.placa, other.placa)) {
            return false;
        }
        if (!Objects.equals(this.marca, other.marca)) {
            return false;
        }
        if (!Objects.equals(this.tipo, other.tipo)) {
            return false;
        }
        return Objects.equals(this.persona, other.persona);
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) throws ExcepcionFormatoEntrada {
        if (placa.contentEquals("")) {
            throw new ExcepcionFormatoEntrada(101);
        } else {
            this.placa = placa;
        }
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) throws ExcepcionFormatoEntrada {
        if (marca.contentEquals("")) {
            throw new ExcepcionFormatoEntrada(101);
        } else {
            this.marca = marca;
        }
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) throws ExcepcionFormatoEntrada {
        Pattern pat = Pattern.compile("[0-9]");
        Matcher mat = pat.matcher(tipo);
        if (tipo.contentEquals("")) {
            throw new ExcepcionFormatoEntrada(101);
        } else if (mat.find()) {
            throw new ExcepcionFormatoEntrada(103, tipo);
        } else {
            this.tipo = tipo;
        }
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

}
