package vista;

import modelo.dominio.Admin;
import modelo.dominio.Reserva;
import modelo.dominio.UsuarioExterno;
import repositorio.AdminRepositorio;
import repositorio.ReservaRepositorio;
import repositorio.UsuarioExternoRepositorio;
import servicios.AdminServiceImpl;
import servicios.ReservaServiceImpl;
import servicios.UsuarioExternoServiceImpl;

import java.util.Scanner;

public class App {

    private Scanner sc = new Scanner(System.in);

    // Servicios
    private UsuarioExterno usuarioExterno = new UsuarioExterno();
    private UsuarioExternoRepositorio usuarioExternoRepositorio = new UsuarioExternoRepositorio();
    private UsuarioExternoServiceImpl usuarioExternoService = new UsuarioExternoServiceImpl(usuarioExternoRepositorio);

    private Admin admin = new Admin();
    private AdminRepositorio adminRepositorio = new AdminRepositorio();
    private AdminServiceImpl adminService = new AdminServiceImpl(adminRepositorio);

    private Reserva reserva = new Reserva();
    private ReservaRepositorio reservaRepositorio = new ReservaRepositorio();
    private ReservaServiceImpl reservaService = new ReservaServiceImpl(reservaRepositorio);

    // ====================== MENÚ PRINCIPAL ======================
    public void menuApp() {
        int option;
        System.out.println("=== Bienvenido al sistema de reservas ===");

        do {
            System.out.println("""
                    ----------------------------
                    Seleccione una opción:
                    1. Gestión de Usuarios Externos
                    2. Gestión de Administradores
                    3. Gestión de Reservas
                    4. Salir
                    ----------------------------
                    """);
            option = sc.nextInt();
            sc.nextLine(); // limpiar buffer

            switch (option) {
                case 1 -> menuUsuarioExterno();
                case 2 -> menuAdmin();
                case 3 -> menuReservas();
                case 4 -> System.out.println("Saliendo del sistema...");
                default -> System.out.println("❌ Opción no válida, intente de nuevo.");
            }
        } while (option != 4);
    }

    // ====================== MENÚ USUARIO EXTERNO ======================
    public void menuUsuarioExterno() {
        int option;
        do {
            System.out.println("""
                    --- Gestión de Usuarios Externos ---
                    1. Registrar Usuario Externo
                    2. Listar Usuarios Externos
                    3. Actualizar Usuario Externo
                    4. Volver al menú principal
                    """);
            option = sc.nextInt();
            sc.nextLine();

            switch (option) {
                case 1 -> usuarioExternoService.registrarUsuarioExterno(usuarioExterno);
                case 2 -> usuarioExternoService.listarUsuariosExternos();
                case 3 -> usuarioExternoService.actualizarUsuarioExterno(usuarioExterno);
                case 4 -> System.out.println("Volviendo al menú principal...");
                default -> System.out.println("❌ Opción no válida, intente de nuevo.");
            }
        } while (option != 4);
    }

    // ====================== MENÚ ADMIN ======================
    public void menuAdmin() {
        int adminOpt;
        do {
            System.out.println("""
                    --- Gestión de Administradores ---
                    1. Insertar nuevo administrador
                    2. Consultar administrador por ID
                    3. Listar administradores
                    4. Actualizar administrador
                    5. Eliminar administrador
                    6. Volver al menú principal
                    """);
            adminOpt = sc.nextInt();
            sc.nextLine();

            switch (adminOpt) {
                case 1 -> adminService.registrarAdmin(admin);
                case 2 -> {
                    System.out.print("Ingrese el ID del administrador: ");
                    int id = sc.nextInt();
                    adminService.buscarAdminPorId(id);
                }
                case 3 -> adminService.listarAdmin();
                case 4 -> adminService.updateAdmin(admin);
                case 5 -> {
                    System.out.print("Ingrese el ID del administrador a eliminar: ");
                    int idDelete = sc.nextInt();
                    adminService.deleteAdminId(idDelete);
                }
                case 6 -> System.out.println("Volviendo al menú principal...");
                default -> System.out.println("❌ Opción no válida, intente de nuevo.");
            }
        } while (adminOpt != 6);
    }

    // ====================== MENÚ RESERVAS ======================
    public void menuReservas() {
        int reservaOpt;
        do {
            System.out.println("""
                    --- Gestión de Reservas ---
                    1. Crear reserva
                    2. Actualizar reserva
                    3. Eliminar reserva
                    4. Listar reservas
                    5. Volver al menú principal
                    """);
            reservaOpt = sc.nextInt();
            sc.nextLine();

            switch (reservaOpt) {
                case 1 -> reservaService.registrarReserva(new Reserva());
                case 2 -> reservaService.actualizarReserva(new Reserva());
                case 3 -> System.out.println("🔧 Opción eliminar reserva (pendiente).");
                case 4 -> reservaService.listarReservas();
                case 5 -> System.out.println("Volviendo al menú principal...");
                default -> System.out.println("❌ Opción no válida, intente de nuevo.");
            }
        } while (reservaOpt != 5);
    }

    // ====================== MAIN ======================
    public static void main(String[] args) {
        App app = new App();
        app.menuApp();
    }
}
