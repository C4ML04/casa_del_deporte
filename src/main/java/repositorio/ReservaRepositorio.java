package repositorio;

import modelo.dominio.Reserva;
import java.sql.Connection;
import java.sql.PreparedStatement;

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

    public void eliminarReserva(int id_reserva){
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
}
