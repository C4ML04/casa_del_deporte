package repositorio;

import modelo.dominio.Admin;

import java.util.Scanner;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class AdminRepositorio {

    Conexion conexion=new Conexion();

    Scanner sc = new Scanner(System.in);

    public void registraAdminDB(Admin admin){

        PreparedStatement ps = null;
        try ( Connection connection = conexion.connect()) {

          String query = "INSERT INTO admin(id_admin, nombre_admin, apellido_admin, telefono_admin, actividad_directa)VALUES(?,?,?,?,?)";

          ps=connection.prepareStatement(query);
          ps.setInt(1,admin.getId());
          ps.setString(2,admin.getNombre());
          ps.setString(3,admin.getApellido());
          ps.setString(4, admin.getTelefono());
          ps.setString(5, admin.getActividadDirecta());
          ps.executeUpdate();

            System.out.println("Usuario Externo registrado en la base de datos" + admin.getNombre() + " " + admin.getApellido());

        } catch (Exception e) {
            System.out.println("Error al registrar el usuario externo en la base de datos: " + e.getMessage());

        }
    }

}
