package Modelo;

import Config.ConexionBD;
import java.sql.*;
import java.util.ArrayList;

public class CRUD {

    private ConexionBD connectionDB;
    private String sql;

    public CRUD() {
        this.connectionDB = null;
        this.sql = "";
    }

    public boolean create(String table, String[] columns, Object[] values) {
        connectionDB = new ConexionBD();
        connectionDB.connectDB();
        try {
            String sqlCheck = "SELECT COUNT(*) FROM " + table + " WHERE " + columns[0] + " = ?";
            try (PreparedStatement checkQuery = connectionDB.getCon().prepareStatement(sqlCheck)) {
                checkQuery.setObject(1, values[0]);

                ResultSet resultSet = checkQuery.executeQuery();
                resultSet.next();
                int count = resultSet.getInt(1);

                if (count == 0) {
                    sql = "INSERT INTO " + table + " (";
                    for (int i = 0; i < columns.length; i++) {
                        sql += columns[i];
                        if (i < columns.length - 1) {
                            sql += ", ";
                        }
                    }
                    sql += ") VALUES (";
                    for (int i = 0; i < values.length; i++) {
                        sql += "?";
                        if (i < values.length - 1) {
                            sql += ", ";
                        }
                    }
                    sql += ")";

                    try (PreparedStatement query = connectionDB.getCon().prepareStatement(sql)) {
                        for (int i = 0; i < values.length; i++) {
                            query.setObject(i + 1, values[i]);
                        }
                        query.executeUpdate();
                        query.close();
                    }
                    connectionDB.getCon().close();
                    return true;
                } else {
                    System.out.println("El valor ya existe en la tabla.");
                    connectionDB.getCon().close();
                    return false;
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public ArrayList readPersona() {
        ArrayList<Persona> listP = new ArrayList<>();
        connectionDB = new ConexionBD();
        connectionDB.connectDB();
        String id = "";
        String nombre = "";
        String telefono = "";
        String email = "";
        String rol = "";
        try {
            sql = "SELECT * FROM persona;";
            Statement sentencia = connectionDB.getCon().createStatement();
            ResultSet result = sentencia.executeQuery(sql);
            while (result.next()) {
                id = result.getString(1);
                nombre = result.getString(2);
                telefono = result.getString(3);
                email = result.getString(4);
                rol = result.getString(5);
                listP.add(new Persona(id, nombre, email, telefono, rol) {
                });
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return listP;
    }

    public ArrayList readVehiculo() {
        ArrayList<Vehiculo> listV = new ArrayList<>();
        connectionDB = new ConexionBD();
        connectionDB.connectDB();
        String marca = "";
        String placa = "";
        String tipo = "";
        String idPersona = "";

        try {
            sql = "SELECT * FROM vehiculo;";
            Statement sentencia = connectionDB.getCon().createStatement();
            ResultSet result = sentencia.executeQuery(sql);
            while (result.next()) {
                placa = result.getString(1);
                marca = result.getString(2);
                tipo = result.getString(3);
                idPersona = result.getString(4);               
                listV.add(new Vehiculo(placa, marca, tipo, listarIdPersona(idPersona)) {
                });
            }
        } catch (SQLException | ExcepcionFormatoEntrada e) {
            System.out.println(e.getMessage());
        }
        return listV;
    }

    public Persona listarIdPersona(String identificacion) throws ExcepcionFormatoEntrada {
        String id, nombre, email, telefono, rol;
        id = nombre = email = telefono = rol = "";
        connectionDB = new ConexionBD();
        connectionDB.connectDB();

        sql = "SELECT * FROM persona WHERE identificacion='" + identificacion + "'";
        try {
            Statement sentencia = connectionDB.getCon().createStatement();
            ResultSet result = sentencia.executeQuery(sql);
            while (result.next()) {
                id = result.getString(1);
                nombre = result.getString(2);
                email = result.getString(3);
                telefono = result.getString(4);
                rol = result.getString(5);
            }
            switch (rol) {
                case "Administrativo":
                    Administrativo admin = new Administrativo(id, nombre, email, telefono, rol);
                    return admin;
                case "Docente":
                    Docente docen = new Docente(id, nombre, email, telefono, rol);
                    return docen;
                case "Estudiante":
                    Estudiante est = new Estudiante(id, nombre, email, telefono, rol);
                    return est;
                case "Visitante":
                    Visitante vis = new Visitante(id, nombre, rol);
                    return vis;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public Vehiculo listarIdVehiculo(String id) throws ExcepcionFormatoEntrada {
        String marca, placa, tipo, idPersona;
        marca = placa = tipo = idPersona = "";
        connectionDB = new ConexionBD();
        connectionDB.connectDB();

        sql = "SELECT * FROM vehiculo WHERE placa='" + id + "'";
        try {
            Statement sentencia = connectionDB.getCon().createStatement();
            ResultSet result = sentencia.executeQuery(sql);
            while (result.next()) {
                marca = result.getString(1);
                placa = result.getString(2);
                tipo = result.getString(3);
                idPersona = result.getString(4);
            }
            Persona persona = (Persona) listarIdPersona(idPersona);
            switch (tipo) {
                case "Carro":
                    Carro carro = new Carro(placa, marca, tipo, persona);
                    return carro;
                case "Moto":
                    Moto moto = new Moto(placa, marca, tipo, persona);
                    return moto;
                case "Bicicleta":
                    Bicicleta bici = new Bicicleta(placa, marca, tipo, persona);
                    return bici;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public boolean update(String table, String[] columns, Object[] values, String condition) {
        connectionDB = new ConexionBD();
        connectionDB.connectDB();
        try {
            sql = "UPDATE " + table + " SET ";
            for (int i = 0; i < columns.length; i++) {
                sql += columns[i] + " = ?";
                if (i < columns.length - 1) {
                    sql += ", ";
                }
            }
            if (condition != null && !condition.isEmpty()) {
                sql += " WHERE " + condition;
            }

            System.out.println(sql);

            try (PreparedStatement query = connectionDB.getCon().prepareStatement(sql)) {
                for (int i = 0; i < values.length; i++) {
                    query.setObject(i + 1, values[i]);
                }
                query.executeUpdate();
                query.close();
            }
            connectionDB.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return true;
    }

    public boolean delete(String table, String condition) {
        connectionDB = new ConexionBD();
        connectionDB.connectDB();
        try {
            sql = "DELETE FROM " + table;
            if (condition != null && !condition.isEmpty()) {
                sql += " WHERE " + condition + ";";
            }

            try (Statement query = connectionDB.getCon().createStatement()) {
                query.executeUpdate(sql);
                query.close();
            }
            connectionDB.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return true;
    }
}
