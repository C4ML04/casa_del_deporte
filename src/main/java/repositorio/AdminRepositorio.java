package repositorio;

import com.mysql.cj.util.DnsSrv;
import modelo.dominio.Admin;

import java.sql.*;
import java.util.Scanner;

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

    public void mostrarAdmins(){

        PreparedStatement ps = null;
        ResultSet rs = null;

        try (Connection connection = conexion.connect()){

            String query = "SELECT * FROM admin";

            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();

            while(rs.next()) {
                int id = rs.getInt("id_admin");
                String nombre = rs.getNString("nombre_admin");
                String apellido = rs.getNString("apellido_admin");
                String telefono = rs.getNString("telefono_admin");
                String actividadDirecta = rs.getNString("actividad_directa");


                System.out.println("ID del Admin: " + id +"\n"+
                        "Nombre del Admin: "+ nombre +"\n"+
                        "Apellido del Admin: "+ apellido +"\n"+
                        "Telefono del Admin: "+ telefono +"\n"+
                        "Responsabilidad: "+ actividadDirecta+"\n");
            }

        }catch (Exception e){
            System.out.println("error al conectar "+ e.getMessage());
        }
    }

    public void buscarAdminPorId(int id){
        PreparedStatement ps = null;
        ResultSet rs = null;

        try(Connection connection= conexion.connect()){

            String query = "SELECT * FROM admin WHERE id_admin = ?";

            ps = connection.prepareStatement(query);

            ps.setInt(1,id);

            rs=ps.executeQuery();

            while (rs.next()){

                int id_ad = rs.getInt("id_admin");
                String nombre = rs.getNString("nombre_admin");
                String apellido = rs.getNString("apellido_admin");
                String telefono = rs.getNString("telefono_admin");
                String responsabilidad = rs.getNString("actividad_directa");

                if (nombre != null ){

                    System.out.println("ID del Admin: "+id_ad+"\n"+
                        "Nombre del Admin: "+nombre+"\n"+
                        "Apellido del Admin: "+apellido+"\n"+
                        "Telefono del Admin: "+telefono+"\n"+
                        "Actividad Directa del Admin: "+responsabilidad+"\n");

                }else {
                    System.out.println("ESTE ID NO EXISTE EN LA BASE DE DATOS");
                }


            }

        }catch (Exception e){
            System.out.println("Error al conectar "+e.getMessage());
        }


    }

    public void deleteAdminId(int id){

        PreparedStatement ps = null;

        try (Connection conection = conexion.connect()){
            String query = "DELETE FROM admin WHERE id_admin = ?";
            ps = conection.prepareStatement(query);
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("Admin Eliminado con el id: " + id);
        } catch (SQLException e) {
            System.out.println("Error de conexión: " + e.getMessage());
        }

    }

}
