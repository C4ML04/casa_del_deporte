package vista;

import modelo.dominio.Admin;
import modelo.dominio.UsuarioExterno;
import repositorio.AdminRepositorio;
import repositorio.UsuarioExternoRepositorio;
import servicios.AdminServiceImpl;
import servicios.UsuarioExternoServiceImpl;

import java.util.Scanner;

public class App {

    Scanner sc = new Scanner(System.in);
    UsuarioExterno usuarioExterno = new UsuarioExterno();
    UsuarioExternoRepositorio usuarioExternoRepositorio = new UsuarioExternoRepositorio();
    UsuarioExternoServiceImpl usuarioExternoService = new UsuarioExternoServiceImpl(usuarioExternoRepositorio);


    Admin admin = new Admin();
    AdminRepositorio adminRepositorio = new AdminRepositorio();
    AdminServiceImpl adminService = new AdminServiceImpl(adminRepositorio);


    public void menuApp() {
        int option = 0;

            System.out.println("Bienvenido al sistema de reservas" + "presione 1 para iniciar el sistema");
            int star = sc.nextInt();

            while (star != 0) {

                do {


                    System.out.println("""
                            Seleccione una opción:
                            1. Gestionar Usuario Externo
                            2. manejo de Administradores
                            3. Salir
                            """);
                    option = sc.nextInt();
                    sc.nextLine();

                    switch (option) {

                        case 1:
                            manegarUsuarioExterno();
                            break;
                        case 2:
                            menuAdmin();
                            break;

                        case 3:
                            System.out.println("Estas saliendo del sistema...");
                            star = 0;
                            break;
                        default:
                            System.out.println("indique una opcion correcta");
                    }
                }while (option!=2);

        }
    }


    public void manegarUsuarioExterno(){

        System.out.println("Gestionar Usuario Externo \n" +
                "1. Registrar Usuario Externo \n" +
                "2. Listar Usuarios Externos \n" +
                "3. Volver al menú principal");
        int option = sc.nextInt();
        sc.nextLine();

        switch (option){
            case 1:
                System.out.println("Registrar Usuario Externo");
                usuarioExternoService.registrarUsuarioExterno(usuarioExterno);
                break;
            case 2:
                System.out.println("Listar Usuarios Externos");
                usuarioExternoService.listarUsuariosExternos();
                break;
            case 3:
                System.out.println("Volver al menú principal");
                menuApp();
                break;
            default:
                System.out.println("Opción no válida, intente de nuevo.");
                break;
        }
    }


    public void menuAdmin(){
        int adminOpt=0;

        do {


            System.out.println("seleccione una de las siguintes opciones");
            System.out.println("""
                    1)insercion de nuevo administrador
                    2)consultar admin por id
                    3)consultar lista completa de admins
                    4)actualizar datos del admin
                    5)eliminar admin
                    6)salir al menu principal
                    """);
            adminOpt = sc.nextInt();
            sc.nextLine();

            switch (adminOpt) {
                case 1:
                    System.out.println("bienvenido al apartado de insercion de datos del ADMIN: ");
                    adminService.registrarAdmin(admin);
                    break;
                case 2:
                    System.out.println("consulta de admin por id");
                    break;
                case 3:
                    System.out.println("consulta de administradores completa");
                    break;
                case 4:
                    System.out.println("actualizacion de datos del administrador");
                    break;
                case 5:
                    System.out.println("eliminar adminitrador");
                    break;
                case 6:
                    System.out.println("saliendo del menu de gestion de administradores");
                    break;
                default:
                    System.out.println("elija una de las opciones indicadas ");
            }
        }while (adminOpt!=6);



    }
}