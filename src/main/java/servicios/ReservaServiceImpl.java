package servicios;

import modelo.dominio.Reserva;
import repositorio.ReservaRepositorio;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

public class ReservaServiceImpl implements ReservaInterface {


     ReservaRepositorio reservaRepositorio = new ReservaRepositorio();
    private Scanner sc = new Scanner(System.in);

    public ReservaServiceImpl(ReservaRepositorio reservaRepositorio) {
        this.reservaRepositorio = reservaRepositorio;
    }

    @Override
    public void registrarReserva(Reserva reserva) {
        System.out.println("=== Registrar Reserva ===");


        System.out.print("Ingrese la fecha de la reserva (YYYY-MM-DD): ");
        String fechaTexto = sc.nextLine();
        LocalDate fechaReserva = LocalDate.parse(fechaTexto);

        System.out.print("Ingrese la hora de la reserva (HH:mm): ");
        String horaTexto = sc.nextLine();
        LocalDateTime horaReserva = LocalDateTime.parse(fechaTexto + "T" + horaTexto);

        System.out.print("¿Entrenamiento asistido? (Si/No): ");
        String respuesta = sc.nextLine();
        boolean entrenamientoAsistido = respuesta.equalsIgnoreCase("si");

        System.out.print("Ingrese el ID del usuario externo: ");
        int idUsuario = sc.nextInt();

        System.out.print("Ingrese el ID del administrador: ");
        int idAdmin = sc.nextInt();

        // Setear datos en el objeto
        reserva.setFechaReserva(fechaReserva);
        reserva.setHoraReserva(horaReserva);
        reserva.setEntrenamientoAsistido(entrenamientoAsistido);

        // Guardar en BD
        reservaRepositorio.crearReserva(reserva, idUsuario, idAdmin);
    }

    @Override
    public void actualizarReserva(Reserva reserva) {
        System.out.println("=== Actualizar Reserva ===");

        System.out.print("Ingrese el ID de la reserva a actualizar: ");
        int idReserva = sc.nextInt();
        sc.nextLine();

        System.out.print("Ingrese la nueva fecha (YYYY-MM-DD): ");
        String fechaTexto = sc.nextLine();
        LocalDate fechaReserva = LocalDate.parse(fechaTexto);

        System.out.print("Ingrese la nueva hora (HH:mm): ");
        String horaTexto = sc.nextLine();
        LocalDateTime horaReserva = LocalDateTime.parse(fechaTexto + "T" + horaTexto);

        System.out.print("¿Entrenamiento asistido? (Si/No): ");
        String respuesta = sc.nextLine();
        boolean entrenamientoAsistido = respuesta.equalsIgnoreCase("si");

        System.out.print("Ingrese el ID del usuario externo: ");
        int idUsuario = sc.nextInt();

        System.out.print("Ingrese el ID del administrador: ");
        int idAdmin = sc.nextInt();

        // Setear datos en objeto
        reserva.setIdReserva(idReserva);
        reserva.setFechaReserva(fechaReserva);
        reserva.setHoraReserva(horaReserva);
        reserva.setEntrenamientoAsistido(entrenamientoAsistido);

        // Actualizar en BD
        reservaRepositorio.actualizarReserva(reserva, idUsuario, idAdmin);
    }

    @Override
    public void listarReservas() {

    }
}
