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
        System.out.println("Actualizar Usuario Externo");
        System.out.println("Seleccione el campo a actualizar: 1. Nombre 2. Apellido 3. Teléfono 4. Fecha de Nacimiento 5. Es Deportista Activo 6. Haciendo Musculación");
        int option = sc.nextInt();
        sc.nextLine();

        System.out.println("Ingrese el Id del Usuario Externo a actualizar ");
        int id = sc.nextInt();
        sc.nextLine(); // limpiar buffer

        // ✅ Obtener usuario actual desde BD para no perder datos
        UsuarioExterno usuarioActual = usuarioExternoRepositorio.obtenerUserPorId(id);
        if (usuarioActual == null) {
            System.out.println("❌ No se encontró el usuario con ID " + id);
            return;
        }

        switch (option) {
            case 1:
                System.out.println("Ingrese el nuevo nombre: ");
                String nombre = sc.nextLine();
                usuarioActual.setNombre(nombre);
                break;

            case 2:
                System.out.println("Ingrese el nuevo apellido: ");
                String apellido = sc.nextLine();
                usuarioActual.setApellido(apellido);
                break;

            case 3:
                System.out.println("Ingrese el nuevo teléfono: ");
                String telefono = sc.nextLine();
                usuarioActual.setTelefono(telefono);
                break;

            case 4:
                Date fechaDeNacimiento = null;
                while (fechaDeNacimiento == null) {
                    System.out.println("Ingresa la fecha de nacimiento (YYYY-MM-DD):");
                    String fechaTexto = sc.nextLine();
                    try {
                        fechaDeNacimiento = new SimpleDateFormat("yyyy-MM-dd").parse(fechaTexto);
                    } catch (Exception e) {
                        System.out.println("❌ Formato de fecha inválido. Use YYYY-MM-DD");
                    }
                }
                usuarioActual.setFechaDeNacimiento(fechaDeNacimiento);
                break;

            case 5:
                System.out.println("¿Es deportista activo? (Si/No):");
                String respuesta = sc.nextLine();
                usuarioActual.setEsDeportistaActivo(respuesta.equalsIgnoreCase("si"));
                break;

            case 6:
                System.out.println("¿Está haciendo musculación? (Si/No):");
                respuesta = sc.nextLine();
                usuarioActual.setHaciendoMusculacion(respuesta.equalsIgnoreCase("si"));
                break;

            default:
                System.out.println("❌ Opción no válida");
                return;
        }

        // ✅ Guardar en BD solo con el cambio realizado
        usuarioExternoRepositorio.actualizarUsuarioExternoBD(usuarioActual);


    }

    @Override
    public void listarUsuariosExternos() {

    }

    @Override
    public void obtenerUsuarioPorId(int idUsuario) {
    usuarioExternoRepositorio usuario = usuarioExternoRepositorio.

    }
}
