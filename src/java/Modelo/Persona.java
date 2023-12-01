package Modelo;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JButton;

/**
 *
 * @author manol
 */
public abstract class Persona {

    private String id;
    private String nombre;
    private String email;
    private String telefono;
    private String rol;

    public Persona() {
        this.id = "";
        this.nombre = "";
        this.email = "";
        this.telefono = "";
        this.rol = "";
    }

    public Persona(String id, String nombre, String rol) {
        this.id = id;
        this.nombre = nombre;
        this.rol = rol;
    }

    public Persona(String id, String nombre, String email, String telefono, String rol) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
        this.rol = rol;
    }

    public Object[] datos() {
        Object[] data = {id, nombre, telefono, email, rol};
        return data;
    }

    @Override
    public String toString() {
        return "\n ID: " + id + "\n Nombre: " + nombre + "\n Email: " + email
                + "\n Telefono: " + telefono + "\n Rol: " + rol;
    }

    @Override
    public int hashCode() {
        int hash = 7;
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
        final Persona other = (Persona) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.telefono, other.telefono)) {
            return false;
        }
        return Objects.equals(this.rol, other.rol);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) throws ExcepcionFormatoEntrada {
        Pattern pat = Pattern.compile("[a-z]");
        Matcher mat = pat.matcher(id);
        if (id.contentEquals("")) {
            throw new ExcepcionFormatoEntrada(101);
        } else if (mat.find()) {
            throw new ExcepcionFormatoEntrada(103, id);
        } else {
            this.id = id;
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) throws ExcepcionFormatoEntrada {
        Pattern pat = Pattern.compile("[0-9]");
        Matcher mat = pat.matcher(nombre);
        if (mat.find()) {
            throw new ExcepcionFormatoEntrada(102, nombre);
        } else {
            this.nombre = nombre;
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) throws ExcepcionFormatoEntrada {
        Pattern pat = Pattern.compile("[a-z]");
        Matcher mat = pat.matcher(telefono);
        if (mat.find()) {
            throw new ExcepcionFormatoEntrada(103, telefono);
        } else {
            this.telefono = telefono;
        }
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

}
