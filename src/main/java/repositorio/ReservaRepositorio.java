package repositorio;


import modelo.dominio.Reserva;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class ReservaRepositorio {

    Conexion conexion = new Conexion();


    // 🔹 Crear una reserva
    public void crearReserva(Reserva reserva, int idUsuario, int idAdmin) {
        String queryInsert = "INSERT INTO reserva (fecha_reserva, hora_reserva, entrenamiento_asistido, id_usuario, id_admin) VALUES (?, ?, ?, ?, ?)";

        try (Connection connection = conexion.connect()) {

            // 1) Verificar existencia del usuario
            boolean userExists;
            String queryUsuario = "SELECT 1 FROM usuario_externo WHERE id_usuario = ?";
            try (PreparedStatement psUser = connection.prepareStatement(queryUsuario)) {
                psUser.setInt(1, idUsuario);
                try (ResultSet rsUser = psUser.executeQuery()) {
                    userExists = rsUser.next();
                }
            }

            // 2) Verificar existencia del admin
            boolean adminExists;
            String queryAdmin = "SELECT 1 FROM admin WHERE id_admin = ?";
            try (PreparedStatement psAdmin = connection.prepareStatement(queryAdmin)) {
                psAdmin.setInt(1, idAdmin);
                try (ResultSet rsAdmin = psAdmin.executeQuery()) {
                    adminExists = rsAdmin.next();
                }
            }

            // 3) Mensajes según el resultado de las verificaciones
            if (!userExists && !adminExists) {
                System.out.println("Ni el usuario (ID " + idUsuario + ") ni el administrador (ID " + idAdmin + ") fueron encontrados. Verifique ambos IDs.");
                return;
            } else if (!userExists) {
                System.out.println("El usuario con ID " + idUsuario + " no está registrado. No se puede crear la reserva.");
                return;
            } else if (!adminExists) {
                System.out.println("El administrador con ID " + idAdmin + " no está registrado. No se puede crear la reserva.");
                return;
            }

            // 4) Si ambos existen
            try (PreparedStatement ps = connection.prepareStatement(queryInsert)) {
                ps.setDate(1, java.sql.Date.valueOf(reserva.getFechaReserva()));
                ps.setTimestamp(2, java.sql.Timestamp.valueOf(reserva.getHoraReserva()));
                ps.setBoolean(3, reserva.isEntrenamientoAsistido());
                ps.setInt(4, idUsuario);
                ps.setInt(5, idAdmin);

                int filas = ps.executeUpdate();
                if (filas > 0) {
                    System.out.println("Reserva creada correctamente.");
                } else {
                    System.out.println("No se pudo crear la reserva.");
                }
            }

        } catch (Exception e) {
            System.out.println("Error al crear la reserva: " + e.getMessage());
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
                System.out.println("Reserva actualizada correctamente.");
            } else {
                System.out.println("No se encontró la reserva con id " + reserva.getIdReserva());
            }

        } catch (Exception e) {
            System.out.println("Error al actualizar la reserva: " + e.getMessage());
        }
    }
    // Buscar reserva porID
    public void buscarReservaPorId(int id_reserva){
        PreparedStatement ps = null;
        ResultSet rs = null;

        try(Connection connection= conexion.connect()){

            String query = "SELECT * FROM reserva WHERE id_reserva = ?";

            ps = connection.prepareStatement(query);

            ps.setInt(1,id_reserva);

            rs=ps.executeQuery();

            while (rs.next()){

                Integer idReserva = rs.getInt("id_reserva");
                LocalDate fechaReserva = rs.getDate("fecha_reserva").toLocalDate();
                LocalDateTime horaReserva = rs.getTimestamp("hora_reserva").toLocalDateTime();
                Boolean entrenamientoAsistido = rs.getBoolean("entrenamiento_asistido");
                int idUsuario = rs.getInt("id_usuario");
                int idAdmin = rs.getInt("id_admin");

                if (idReserva != null){

                    System.out.println("ID reserva: "+idReserva+"\n"+
                            "Fecha de la reserva: "+fechaReserva+"\n"+
                            "Hora de la reserva: "+horaReserva+"\n"+
                            "Entrenamiento asistido: "+entrenamientoAsistido+"\n"+
                            "Id usuario: "+idUsuario+"\n"+
                            "Id admin: "+idAdmin+"\n");

                }else {
                    System.out.println("ESTE ID NO EXISTE EN LA BASE DE DATOS");
                }


            }

        }catch (Exception e){
            System.out.println("Error al conectar "+e.getMessage());
        }


    }

    // Listar las reservas
    public void listarReservas(){

        PreparedStatement ps = null;
        ResultSet rs = null;

        try (Connection connection = conexion.connect()) {

            String query = "SELECT * FROM reserva";

            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {

                Integer idReserva = rs.getInt("id_reserva");
                LocalDate fechaReserva = rs.getDate("fecha_reserva").toLocalDate();
                LocalDateTime horaReserva = rs.getTimestamp("hora_reserva").toLocalDateTime();
                Boolean entrenamientoAsistido = rs.getBoolean("entrenamiento_asistido");
                int idUsuario = rs.getInt("id_usuario");
                int idAdmin = rs.getInt("id_admin");


                System.out.println("ID reserva: " + idReserva + "\n" +
                        "Fecha de la reserva: " + fechaReserva + "\n" +
                        "Hora de la reserva: " + horaReserva + "\n" +
                        "Entrenamiento asistido: " + entrenamientoAsistido + "\n" +
                        "Id usuario: " + idUsuario + "\n" +
                        "Id admin: " + idAdmin + "\n");


            }
        } catch (Exception e){
            System.out.println("error al conectar "+ e.getMessage());
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



