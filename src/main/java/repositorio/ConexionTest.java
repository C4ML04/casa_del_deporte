package repositorio;

import java.sql.Connection;

public class ConexionTest {

    public static void main(String[] args) {


        Conexion conexion = new Conexion();

        try(Connection connection = conexion.connect()) {

        } catch (Exception e) {
            System.out.println("Error al conectar: " + e.getMessage());
        }
    }
}
