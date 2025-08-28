package repositorio;

import modelo.dominio.UsuarioExterno;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UsuarioExternoRepositorio {

    Conexion conexion = new Conexion();
    Scanner sc = new Scanner(System.in);

    List<ArrayList<String>> listaUsuarios = new ArrayList<>();


    public void crearUsuarioExternoRepositorio(UsuarioExterno usuarioExterno) {

        ArrayList<String> listaUsuario = new ArrayList<>();

        String id = String.valueOf(usuarioExterno.getId());
        String nombre = usuarioExterno.getNombre();
        String apellido = usuarioExterno.getApellido();
        String telefono = usuarioExterno.getTelefono();
        String fechaNacimiento = String.valueOf(usuarioExterno.getFechaDeNacimiento());
        String esDeportistaActivo = String.valueOf(usuarioExterno.isEsDeportistaActivo());
        String haciendoMusculacion = String.valueOf(usuarioExterno.isHaciendoMusculacion());

        listaUsuario.add(id);
        listaUsuario.add(nombre);
        listaUsuario.add(apellido);
        listaUsuario.add(telefono);
        listaUsuario.add(fechaNacimiento);
        listaUsuario.add(esDeportistaActivo);
        listaUsuario.add(haciendoMusculacion);
        // En la listaUsuarios se guarda una lista de strings que representa un usuario externo
        listaUsuarios.add(listaUsuario);

        System.out.println("Usuario Externo registrado: " + listaUsuario);


    }

    public void crearUsuarioExternoDB(UsuarioExterno usuarioExterno) {

        PreparedStatement ps = null;
        try ( Connection connection = conexion.connect()) {

            String query = "INSERT INTO usuario_externo(id_usuario, nombre_usuario, apellido, telefono, fecha_de_nacimiento ,es_deportista_activo, haciendo_musculacion)VALUES(?,?,?,?,?,?,?)";
            ps = connection.prepareStatement(query);
            ps.setInt(1, usuarioExterno.getId());
            ps.setString(2, usuarioExterno.getNombre());
            ps.setString(3, usuarioExterno.getApellido());
            ps.setString(4, usuarioExterno.getTelefono());
            ps.setDate(5, new java.sql.Date(usuarioExterno.getFechaDeNacimiento().getTime()));
            ps.setBoolean(6, usuarioExterno.isEsDeportistaActivo());
            ps.setBoolean(7, usuarioExterno.isHaciendoMusculacion());

            ps.executeUpdate();
            System.out.println("Usuario Externo registrado en la base de datos" + usuarioExterno.getNombre() + " " + usuarioExterno.getApellido());

        } catch (Exception e) {
            System.out.println("Error al registrar el usuario externo en la base de datos: " + e.getMessage());

        }
    }

}
