package servicios;

import modelo.dominio.UsuarioExterno;
import repositorio.UsuarioExternoRepositorio;

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
        System.out.println("¿Es deportista activo? (true/false):");
        boolean esDeportistaActivo = sc.nextBoolean();
        System.out.println("¿Está haciendo musculación? (true/false):");
        boolean haciendoMusculacion = sc.nextBoolean();


        usuarioExterno.setId(id);
        usuarioExterno.setNombre(nombre);
        usuarioExterno.setApellido(apellido);
        usuarioExterno.setTelefono(telefono);
        usuarioExterno.setEsDeportistaActivo(esDeportistaActivo);
        usuarioExterno.setHaciendoMusculacion(haciendoMusculacion);


        usuarioExternoRepositorio.crearUsuarioExternoRepositorio(usuarioExterno);
        usuarioExternoRepositorio.crearUsuarioExternoDB(usuarioExterno);
    }

    @Override
    public void listarUsuariosExternos() {

    }
}
