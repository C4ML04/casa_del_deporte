package repositorio;

import modelo.dominio.UsuarioExterno;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
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
            System.out.println("Usuario Externo registrado en la base de datos: " + usuarioExterno.getNombre() + " " + usuarioExterno.getApellido());

        } catch (Exception e) {
            System.out.println("Error al registrar el usuario externo en la base de datos: " + e.getMessage());

        }
    }

    //Metodo para obtener usuario por ID
    public UsuarioExterno buscarUsuarioPorId(int idUsuario) {
        UsuarioExterno usuario = null;
        String query = "SELECT * FROM usuario_externo WHERE id_usuario = ?";

        try (Connection connection = conexion.connect();
             PreparedStatement ps = connection.prepareStatement(query)) {

            ps.setInt(1, idUsuario);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                usuario = new UsuarioExterno();
                usuario.setId(rs.getInt("id_usuario"));
                usuario.setNombre(rs.getString("nombre_usuario"));
                usuario.setApellido(rs.getString("apellido"));
                usuario.setTelefono(rs.getString("telefono"));
                usuario.setFechaDeNacimiento(rs.getDate("fecha_de_nacimiento"));
                usuario.setEsDeportistaActivo(rs.getBoolean("es_deportista_activo"));
                usuario.setHaciendoMusculacion(rs.getBoolean("haciendo_musculacion"));
            }

        } catch (Exception e) {
            System.out.println("Error al obtener usuario externo: " + e.getMessage());
        }

        return usuario;
    }


    // 🔹 Actualizar usuario
    public void actualizarUsuarioExternoBD(UsuarioExterno usuarioExterno) {
        String query = "UPDATE usuario_externo SET nombre_usuario=?, apellido=?, telefono=?, fecha_de_nacimiento=?, es_deportista_activo=?, haciendo_musculacion=? WHERE id_usuario=?";

        try (Connection connection = conexion.connect();
             PreparedStatement ps = connection.prepareStatement(query)) {

            ps.setString(1, usuarioExterno.getNombre());
            ps.setString(2, usuarioExterno.getApellido());
            ps.setString(3, usuarioExterno.getTelefono());

            // Manejo de fecha NULL
            if (usuarioExterno.getFechaDeNacimiento() != null) {
                ps.setDate(4, new java.sql.Date(usuarioExterno.getFechaDeNacimiento().getTime()));
            } else {
                ps.setNull(4, java.sql.Types.DATE);
            }

            ps.setBoolean(5, usuarioExterno.isEsDeportistaActivo());
            ps.setBoolean(6, usuarioExterno.isHaciendoMusculacion());
            ps.setInt(7, usuarioExterno.getId());

            int filasAfectadas = ps.executeUpdate();
            if (filasAfectadas > 0) {
                System.out.println("✅ Usuario Externo actualizado: " + usuarioExterno.getNombre() + " " + usuarioExterno.getApellido());
            } else {
                System.out.println("⚠ No se encontró el usuario externo con id: " + usuarioExterno.getId());
            }

        } catch (Exception e) {
            System.out.println("❌ Error al actualizar el usuario externo en la base de datos: " + e.getMessage());
        }
    }}