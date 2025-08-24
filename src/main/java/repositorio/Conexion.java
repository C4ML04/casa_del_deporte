package repositorio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    public Connection connect() {
        Connection connection = null;

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/casa_del_deporte", "root", "");

            if (connection != null) {
                System.out.println("Conexión exitosa a la base de datos casa_del_deporte");
            }

            return connection;

        } catch (SQLException e) {
            System.out.println("Error de conexión: " + e.getMessage());
        }

        return connection;
    }
}
