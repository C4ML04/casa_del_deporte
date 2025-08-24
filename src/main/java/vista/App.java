package vista;

import modelo.dominio.UsuarioExterno;
import repositorio.UsuarioExternoRepositorio;
import servicios.UsuarioExternoServiceImpl;

import java.util.Scanner;

public class App {

    Scanner sc = new Scanner(System.in);
    UsuarioExterno usuarioExterno = new UsuarioExterno();
    UsuarioExternoRepositorio usuarioExternoRepositorio = new UsuarioExternoRepositorio();
    UsuarioExternoServiceImpl usuarioExternoService = new UsuarioExternoServiceImpl(usuarioExternoRepositorio);


    public void menuApp() {
        int option = 0;

            System.out.println("Bienvenido al sistema de reservas" + "presione 1 para iniciar el sistema");
            int star = sc.nextInt();

            while (star != 0) {

                do {


                    System.out.println("""
                            Seleccione una opción:
                            1. Gestionar Usuario Externo
                            2. Salir
                            """);
                    option = sc.nextInt();
                    sc.nextLine();

                    switch (option) {

                        case 1:
                            manegarUsuarioExterno();

                            break;

                        case 2:
                            System.out.println("Estas saliendo del sistema...");
                            star = 0;
                            break;
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
}