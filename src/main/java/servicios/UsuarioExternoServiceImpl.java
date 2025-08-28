package servicios;

import modelo.dominio.UsuarioExterno;
import repositorio.UsuarioExternoRepositorio;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class UsuarioExternoServiceImpl implements UsuarioExternoInterface{

    Scanner sc = new Scanner(System.in);
    UsuarioExternoRepositorio usuarioExternoRepositorio = new UsuarioExternoRepositorio();

    public UsuarioExternoServiceImpl(UsuarioExternoRepositorio usuarioExternoRepositorio){
        this.usuarioExternoRepositorio = usuarioExternoRepositorio;
    }

    @Override
    public void registrarUsuarioExterno(UsuarioExterno usuarioExterno) {
        System.out.println("Ingrese ID del usuario:");
        int id = sc.nextInt();
        sc.nextLine(); // Consumir el salto de línea pendiente
        System.out.println("Ingrese nombre del usuario:");
        String nombre = sc.nextLine();
        System.out.println("Ingrese apellido del usuario:");
        String apellido = sc.nextLine();
        System.out.println("Ingrese telefono del usuario:");
        String telefono = sc.nextLine();
        Date fechaDeNacimiento = null;
        while (fechaDeNacimiento==null) {
            System.out.println("Ingresa la fecha de nacimiento (YYYY-MM-DD):");
            String fechaTexto = sc.nextLine();

            try {
                fechaDeNacimiento = new SimpleDateFormat("yyyy-MM-dd").parse(fechaTexto);
            } catch (Exception e) {
                System.out.println("❌ Formato de fecha inválido. Use YYYY-MM-DD");
            }
        }
        System.out.println("¿Es deportista activo? (Si/No):");
        String respuesta = sc.nextLine();
        boolean esDeportistaActivo;
        if (respuesta.equalsIgnoreCase("si")) {
            esDeportistaActivo = true;
        } else {
            esDeportistaActivo = false;
        }
        System.out.println("¿Está haciendo musculación? (Si/No):");
        respuesta = sc.nextLine();
        boolean haciendoMusculacion;
        if (respuesta.equalsIgnoreCase("si")) {
            haciendoMusculacion = true;
        } else {
            haciendoMusculacion = false;
        }
        usuarioExterno.setId(id);
        usuarioExterno.setNombre(nombre);
        usuarioExterno.setApellido(apellido);
        usuarioExterno.setTelefono(telefono);
        usuarioExterno.setFechaDeNacimiento(fechaDeNacimiento);
        usuarioExterno.setEsDeportistaActivo(esDeportistaActivo);
        usuarioExterno.setHaciendoMusculacion(haciendoMusculacion);

        usuarioExternoRepositorio.crearUsuarioExternoRepositorio(usuarioExterno);
        usuarioExternoRepositorio.crearUsuarioExternoDB(usuarioExterno);
    }

    @Override
    public void actualizarUsuarioExterno(UsuarioExterno usuarioExterno) {

    }


    @Override
    public void listarUsuariosExternos() {

    }
}
