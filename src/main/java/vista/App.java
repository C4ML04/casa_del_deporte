package vista;

import modelo.dominio.Admin;
import modelo.dominio.Reserva;
import modelo.dominio.UserLogin;
import modelo.dominio.UsuarioExterno;
import repositorio.AdminRepositorio;
import repositorio.ReservaRepositorio;
import repositorio.UsserLogInRepositorio;
import repositorio.UsuarioExternoRepositorio;
import servicios.AdminServiceImpl;
import servicios.ReservaServiceImpl;
import servicios.UsserLogInServiceImpl;
import servicios.UsuarioExternoServiceImpl;

import java.sql.SQLOutput;
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

    private UserLogin userLogin = new UserLogin();
    private UsserLogInRepositorio usserLogInRepositorio = new UsserLogInRepositorio();
    private UsserLogInServiceImpl usserLogInService = new UsserLogInServiceImpl(usserLogInRepositorio);



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
                    3. Buscar Usuario por ID
                    4. Actualizar Usuario Externo
                    5. Volver al menú principal
                    """);
            option = sc.nextInt();
            sc.nextLine();

            switch (option) {
                case 1 -> usuarioExternoService.registrarUsuarioExterno(usuarioExterno);
                case 2 -> usuarioExternoService.listarUsuariosExternos();
                case 3 -> {
                    System.out.print("Ingrese el ID del usuario: ");
                    int idUsuario = sc.nextInt();
                    sc.nextLine(); // Limpiar el buffer
                    usuarioExternoService.obtenerUsuarioPorId(idUsuario);
                }
                case 4 -> usuarioExternoService.actualizarUsuarioExterno(usuarioExterno);
                case 5 -> System.out.println("Volviendo al menú principal...");
                default -> System.out.println("❌ Opción no válida, intente de nuevo.");
            }
        } while (option != 5);
    }


    public void externalUserRegsMenu(){

        int infoOpt;


        System.out.println("Apartado de registro de usuarios: ");
        do {
            System.out.println("""
                    1)Registrarse en la Gym List: 
                    2)Buscar sus datos en la Gym List:
                    3)Actualizar su datos en la Gym List:
                    4)Salir del menu de registros:
                    """);
            infoOpt = sc.nextInt();
            sc.nextLine();

            switch (infoOpt) {
                case 1:
                    usuarioExternoService.registrarUsuarioExterno(usuarioExterno);
                    break;
                case 2:
                    System.out.print("Ingrese el ID del usuario: ");
                    int idUsuario = sc.nextInt();
                    sc.nextLine();
                    usuarioExternoService.obtenerUsuarioPorId(idUsuario);
                    break;
                case 3:
                    usuarioExternoService.actualizarUsuarioExterno(usuarioExterno);
                    break;
                case 4:
                    System.out.println("saliendo del menu de registro de informacion: ");
                    break;
                default:
                    System.out.println("ELIJA UNA DE LAS OPCIONES INDICADAS: ");
            }
        }while (infoOpt!=4);

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
                    4. Buscar reserva por ID
                    5. Listar reservas
                    6. Volver al menú principal
                    """);
            reservaOpt = sc.nextInt();
            sc.nextLine();

            switch (reservaOpt) {
                case 1 -> reservaService.registrarReserva(new Reserva());
                case 2 -> reservaService.actualizarReserva(new Reserva());
                case 3 -> {
                    System.out.print("Ingrese el ID de la reserva a eliminar: ");
                    int id_reserva = sc.nextInt();
                    reservaRepositorio.eliminarReserva(id_reserva);
                }
                case 4 -> {
                    System.out.print("Buscar el ID de la reserva: ");
                    int id_reserva = sc.nextInt();
                    reservaRepositorio.buscarReservaPorId(id_reserva);
                }
                case 5 -> reservaRepositorio.listarReservas();
                case 6 -> System.out.println("Volviendo al menú principal...");
                default -> System.out.println("❌ Opción no válida, intente de nuevo.");
            }
        } while (reservaOpt != 5);
    }

    public void externalUserBookingMenu(){

        int bookingUser;

        System.out.println("MANEJO DE RESERVAS");
        do {


            System.out.println("selecciones una de las siguinetes opciones: ");
            System.out.println("""
                    1)Registrar Reserva de espacios: 
                    2)Actualizar reserva:
                    3)eliminar reserva:
                    4)salir del menu de manejo de reservas:
                    """);
            bookingUser = sc.nextInt();
            sc.nextLine();

            switch (bookingUser) {
                case 1:
                    reservaService.registrarReserva(new Reserva());
                    break;
                case 2:
                    reservaService.actualizarReserva(new Reserva());
                    break;

                case 3:
                    System.out.print("Ingrese el ID de la reserva a eliminar: ");
                    int id_reserva = sc.nextInt();
                    reservaRepositorio.eliminarReserva(id_reserva);
                break;
                case 4:
                    System.out.println("saliendo del menu de reserva ");
                    break;
                default:
                    System.out.println("ELIJA UNA DE LAS OPCIONES INDICADAS: ");
            }
        }while (bookingUser!=4);
    }



    // ====================== MAIN ======================
    public static void main(String[] args) {
        App app = new App();
        app.menuApp();
    }



    public void menuApartadoDeAccesos() {
        int accesosOpt;


        do {

            System.out.println("""
                    Por favor seleccione una de las siguientes opciones:
                    1)registro de nuesvos accesos
                    2)listado de todos los accesos
                    3)busqueda de acceso por email
                    4)eliminado de credenciales 
                    5)actualizacion de credenciales 
                    6)salir del area de gestion de accesos 
                    """);
            accesosOpt = sc.nextInt();
            sc.nextLine();

            switch (accesosOpt) {
                case 1:
                    usserLogInService.registerUsserLogIn(userLogin);
                    break;
                case 2:
                    usserLogInService.listarUsserLoogin();
                    break;
                case 3:
                    String targetUser;

                    System.out.println("Busqueda de acceso por email: ");
                    System.out.println("Ingrese el email del acceso que dedsea revisar: ");
                    targetUser = sc.nextLine();

                    usserLogInService.buscarUsserLoginPorUsser(targetUser);
                    break;
                case 4:
                    int idTarget;

                    System.out.println("Eliminado de acceso por ID:");
                    System.out.println("digite el id del acceso a eliminar");

                    idTarget=sc.nextInt();
                    sc.nextLine();

                    usserLogInService.deleteUsserPorIdLog(idTarget);
                    break;
                case 5:
                    usserLogInService.updateUsserPorEmail(userLogin);
                    break;
                case 6:
                    System.out.println("saliendo del area de gestion de acceso");
                    break;
                default:
                    System.out.println("elija una de las opciones indicadas ");

            }
        }while (accesosOpt !=6);



    }

    public void masterMenuAdmin(){
        int masterOpt;

        do {


            System.out.println("ELIJA UNA DE LAS SISGUIENTES OPCIONES");
            System.out.println("""
                    1)Apartado de manejo de usuarios:
                    2)Manejo de reservas:
                    3)manejo de accesos a plataforma:
                    4)manejo de Administradores:
                    5)salir del modulo de administracion: 
                    """);
            masterOpt = sc.nextInt();
            sc.nextLine();

            switch (masterOpt) {
                case 1:
                    menuUsuarioExterno();
                    break;

                case 2:
                    menuReservas();
                    break;

                case 3:
                    menuApartadoDeAccesos();
                    break;
                case 4:
                    menuAdmin();
                    break;
                case 5:
                    System.out.println("SALIENDO DEL MÓDULO DE ADMINISTRACION");
                    break;
                default:
                    System.out.println("    ELECCION INVALIDA");

            }
        }while (masterOpt!=5);
    }

    public void usserOperation(){
        int usserOperationOpt;

        System.out.println("ELIJA UNA DE LAS SIGUIENTES OPCIONES");
        do {
            System.out.println("""
                    1)Registro en plataforma:
                    2)Manejo de reservas:
                    3)salir al menu principal:
                    """);
            usserOperationOpt = sc.nextInt();
            sc.nextLine();

            switch (usserOperationOpt) {
                case 1:
                    externalUserRegsMenu();
                    break;
                case 2:
                    externalUserBookingMenu();
                    break;
                case 3:
                    System.out.println("Saliendo del menu de usuarios gym: ");
                    break;
                default:
                    System.out.println("ELIJA UNA DE LAS OPCIONES INDICADAS: ");
            }
        }while (usserOperationOpt!=3);

    }
    public void appRunner(){
        int runnerOpt;

        System.out.println("BIENVENIDO AL SISTEMA DE GESTION DE INFORMACION DE LA CASA DEL DEPORTE:");
        do {

            System.out.println("SELCCIONE DE ENTRE LAS SIGUINETES OPCIONES: ");
            System.out.println("""
                    1)Manejo de usuarios:
                    2)Inicio de sesion de ***Administracion****
                    3)salir de la App;
                    """);
            runnerOpt = sc.nextInt();
            sc.nextLine();
            switch (runnerOpt) {
                case 1:
                    usserOperation();
                    break;
                case 2:
                    usserLogInService.sesionAcces();

                    break;
                case 3:
                    System.out.println("Saliendo de la app de gestion de informacion ");
                    break;
                default:
                    System.out.println("ELIJA UNA DE LAS OPCIONES INDICADAS");
            }
        }while (runnerOpt!=3);

    }


}
