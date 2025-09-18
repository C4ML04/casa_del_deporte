package repositorio;

import modelo.dominio.UserLogin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class UsserLogInRepositorio {

    Conexion conexion=new Conexion();
    Scanner sc= new Scanner(System.in);

    public void registrarUsserLogInDB(UserLogin userLogin){

        PreparedStatement ps=null;

        try (Connection connection= conexion.connect()){

            String query = "INSERT INTO login_user (email_login, password_login) VALUES(?,?)";

            ps=connection.prepareStatement(query);
            ps.setString(1,userLogin.getEmail());
            ps.setString(2,userLogin.getPassword());

            ps.executeUpdate();


        }catch (Exception e){
            System.out.println("error al conectar "+e.getMessage());

        }

    }

    public void listarUssersLogin(){
        PreparedStatement ps=null;
        ResultSet rs=null;

        try(Connection connection= conexion.connect()) {

            String query = "SELECT*FROM login_user";

            ps=connection.prepareStatement(query);
            rs=ps.executeQuery();

            while (rs.next()){
                int id =rs.getInt("id_login");
                String usser= rs.getNString("email_login");
                String password = rs.getNString("password_login");

                System.out.println("Id de las credenciales: "+id+"\n"+
                        "Email: "+usser+"\n"+
                        "Password: "+password+"\n");
            }

        }catch (Exception e){
            System.out.println("error al conectar a la base de datos: "+e.getMessage());
        }

    }

    public void buscarUsserLoginPorUsser(String usser){
        PreparedStatement ps = null;
        ResultSet rs= null;

        try(Connection connection= conexion.connect()){

            String query = "SELECT*FROM login_user WHERE email_login = ? ";

            ps= connection.prepareStatement(query);
            ps.setString(1,usser);
            rs=ps.executeQuery();

            while (rs.next()){
                int id = rs.getInt("id_login");
                String email = rs.getNString("email_login");
                String password = rs.getNString("password_login");

                System.out.println("Id del acceso: "+id+"\n"+
                        "Email del acceso: "+email+"\n"+
                        "Password del acceso: "+password+"\n");
            }


        }catch (Exception e){
            System.out.println("Error al conectar a la base de datos: "+e.getMessage());
        }

    }

    public void deleteUserPorIdLog(int id){
        PreparedStatement ps=null;

        try (Connection connection= conexion.connect()){

            String query = "DELETE FROM login_user WHERE  id_login = ?";

            ps=connection.prepareStatement(query);
            ps.setInt(1,id);
            ps.executeUpdate();
            System.out.println("Acceso eliminado de la lista de credenciales con el ID: "+id);

        }catch (Exception e){
            System.out.println("Error al conectar  a la base de datos: "+e.getMessage());
        }
    }

    public  void updateAccesoPorId(UserLogin userLogin){

        System.out.println("USER: "+userLogin.getEmail());
        System.out.println("PASSWORD: "+userLogin.getPassword());
        System.out.println("ID: "+userLogin.getId());

        PreparedStatement ps=null;

        try(Connection connection= conexion.connect()){

            if (userLogin.getEmail() != null && !userLogin.getEmail().isEmpty()){
                String query = createQueryUpdateLogin("email_login");
                ps = connection.prepareStatement(query);
                ps.setString(1,userLogin.getEmail());
                ps.setInt(2,userLogin.getId());
                ps.executeUpdate();
                System.out.println("Credencial actualizada de la base de datos");
                System.out.println("Email: "+userLogin.getEmail());


            }else if (userLogin.getPassword() !=null && !userLogin.getPassword().isEmpty()){
                String query = createQueryUpdateLogin("password_login");
                ps=connection.prepareStatement(query);
                ps.setString(1,userLogin.getPassword());
                ps.setInt(2,userLogin.getId());
                ps.executeUpdate();
                System.out.println("Credencial actualizada de la base de datos: ");
                System.out.println("PASSWORD: "+userLogin.getPassword());

            }else {
                System.out.println("PARAMETRO DE BUSQUEDA INCORRECTO::::");
            }


        }catch (Exception e){
            System.out.println("Error al conectar a la base de datos: "+e.getMessage());
        }


    }

    public String createQueryUpdateLogin(String paramSql){

        return "UPDATE login_user SET "+paramSql+" = ? WHERE id_login = ?";

    }

    public boolean confirmrAcceso(String email,String password){

        PreparedStatement ps =null;
        ResultSet rs = null;

        try (Connection connection= conexion.connect()){

            String query = "SELECT * FROM login_user WHERE email_login = ? AND password_login = ?";

            ps = connection.prepareStatement(query);
            ps.setString(1,email);
            ps.setString(2,password);

            rs=ps.executeQuery();

            return rs.next();


        }catch (Exception e){
            System.out.println("Error al conectar a la base de datos: "+e.getMessage());
            return false;
        }

    }


}

