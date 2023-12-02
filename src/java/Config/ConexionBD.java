package Config;


import java.sql.*;

/**
 *
 * @author manol
 */
public class ConexionBD {

    private Connection con;
    private final String db = "instituto";
    private final String user = "postgres";
    private final String pass = "1234";
    private final String url = "jdbc:postgresql://localhost:5432/" + db;
    

    public Connection connectDB() {
        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection(url, user, pass);
        } catch (ClassNotFoundException ex) {
            System.out.println("\tNo se pudo establecer conexion...");
        } catch (SQLException ex) {
            System.out.println("\tNo se puede conectar con PostgreSQL..." + ex.getMessage());
        }
        return con;
    }

    public void close() {
        try {
            if (con != null) {
                con.close();
            }
        } catch (SQLException e) {
            System.out.println("\tError: No se logro cerrar la conexion:\n" + e);
        }
    }

    @Override
    public String toString() {
        return "Conection: " + con + "\nDatabase: " + db + "\nUser:" + user + "\nURL: " + url;
    }

    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }
}
