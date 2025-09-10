package repositorio;

import modelo.dominio.Reserva;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ReservaRepositorio {

    Conexion conexion = new Conexion();

    // 🔹 Crear una reserva
    public void crearReserva(Reserva reserva, int idUsuario, int idAdmin) {
        String query = "INSERT INTO reserva (id_reserva, fecha_reserva, hora_reserva, entrenamiento_asistido, id_usuario, id_admin) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection connection = conexion.connect();
             PreparedStatement ps = connection.prepareStatement(query)) {

            ps.setInt(1, reserva.getIdReserva());
            ps.setDate(2, java.sql.Date.valueOf(reserva.getFechaReserva()));
            ps.setTimestamp(3, java.sql.Timestamp.valueOf(reserva.getHoraReserva()));
            ps.setBoolean(4, reserva.isEntrenamientoAsistido());
            ps.setInt(5, idUsuario);
            ps.setInt(6, idAdmin);

            int filas = ps.executeUpdate();
            if (filas > 0) {
                System.out.println("✅ Reserva creada correctamente.");
            } else {
                System.out.println("⚠️ No se pudo crear la reserva.");
            }

        } catch (Exception e) {
            System.out.println("❌ Error al crear la reserva: " + e.getMessage());
        }
    }

    // 🔹 Actualizar una reserva existente
    public void actualizarReserva(Reserva reserva, int idUsuario, int idAdmin) {
        String query = "INSERT INTO reserva (fecha_reserva, hora_reserva, entrenamiento_asistido, id_usuario, id_admin) VALUES (?, ?, ?, ?, ?)";


        try (Connection connection = conexion.connect();
             PreparedStatement ps = connection.prepareStatement(query)) {

            ps.setDate(1, java.sql.Date.valueOf(reserva.getFechaReserva()));
            ps.setTimestamp(2, java.sql.Timestamp.valueOf(reserva.getHoraReserva()));
            ps.setBoolean(3, reserva.isEntrenamientoAsistido());
            ps.setInt(4, idUsuario);
            ps.setInt(5, idAdmin);


            int filas = ps.executeUpdate();
            if (filas > 0) {
                System.out.println("✅ Reserva actualizada correctamente.");
            } else {
                System.out.println("⚠️ No se encontró la reserva con id " + reserva.getIdReserva());
            }

        } catch (Exception e) {
            System.out.println("❌ Error al actualizar la reserva: " + e.getMessage());
        }
    }


    // Buscar reserva porID
    public Reserva buscarPorId(int idReserva) {
        Reserva reserva = null;
        String sql = "SELECT * FROM reserva WHERE id_reserva = ?";

        try (Connection connection = conexion.connect();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setInt(1, idReserva);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                reserva = new Reserva();
                reserva.setIdReserva(rs.getInt("id_reserva"));
                reserva.setFechaReserva(rs.getDate("fecha_reserva").toLocalDate());
                reserva.setHoraReserva(rs.getTimestamp("hora_reserva").toLocalDateTime());
                reserva.setEntrenamientoAsistido(rs.getBoolean("entrenamiento_asistido"));
                reserva.setIdUsuario(rs.getInt("id_usuario"));
                reserva.setIdAdmin(rs.getInt("id_admin"));   //Se añadio nuevo setter debido a que
                //El problema principal es una incompatibilidad conceptual entre tu clase Reserva y la tabla en la base de datos.
                //
                //La tabla de base de datos reserva almacena IDs numéricos (id_usuario, id_admin).
                //
                //Tu clase Reserva está diseñada para almacenar objetos completos (UsuarioExterno, Admin). Por esto se añadio
            }
        } catch (Exception e) {
            System.out.println("Error al buscar reserva por ID: " + e.getMessage());
        }
        return reserva;
    }
    }

    // Listar las reservas
    public List<Reserva> listarReservas() {
        List<Reserva> reservas = new ArrayList<>();
        String sql = "SELECT * FROM reserva";

        try (Connection connection = conexion.connect();
             Statement st = connection.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                Reserva reserva = new Reserva();
                reserva.setIdReserva(rs.getInt("id_reserva"));
                reserva.setFechaReserva(rs.getDate("fecha_reserva").toLocalDate());
                reserva.setHoraReserva(rs.getTimestamp("hora_reserva").toLocalDateTime());
                reserva.setEntrenamientoAsistido(rs.getBoolean("entrenamiento_asistido"));

                // ✅ CORREGIDO: Usa los setters que esperan IDs
                reserva.setIdUsuario(rs.getInt("id_usuario"));
                reserva.setIdAdmin(rs.getInt("id_admin"));

                reservas.add(reserva);
            }
        } catch (Exception e) {
            System.out.println("Error al listar reservas: " + e.getMessage());
        }
        return reservas;


    } public void eliminarReserva(int id_reserva){
        PreparedStatement ps = null;

        try(Connection connection = conexion.connect()) {

            String query = "DELETE FROM reserva WHERE id_reserva = ?";
            ps = connection.prepareStatement(query);
            ps.setInt(1,id_reserva);
            ps.executeUpdate();
            System.out.println("Reserva eliminada de la base de datos con id: " + id_reserva);


        } catch (Exception e) {
            System.out.println("Error al conectar: " + e.getMessage());
        }
    }

public void main() {
}


