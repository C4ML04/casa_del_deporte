package servicios;

import modelo.dominio.Admin;
import  repositorio.AdminRepositorio;

import java.util.Scanner;

public class AdminServiceImpl  implements  AdminInterface{

    Scanner sc =new Scanner(System.in);
    AdminRepositorio adminRepositorio =new AdminRepositorio();

    public AdminServiceImpl (AdminRepositorio adminRepositorio){
        this.adminRepositorio=adminRepositorio;
    }

    @Override
    public void registrarAdmin(Admin admin) {

        System.out.println("ingrese el ID del admin: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.println("ingrese el nombre del Admin: ");
        String nombre = sc.nextLine();

        System.out.println("ingrese el apellido del Admin: ");
        String apellido = sc.nextLine();

        System.out.println("ingrese el telefono del Admin: ");
        String telefono = sc.nextLine();

        System.out.println("ingrese actividad directa del Admin: ");
        String actividadDirecta = sc.nextLine();

        admin.setId(id);
        admin.setNombre(nombre);
        admin.setApellido(apellido);
        admin.setTelefono(telefono);
        admin.setActividadDirecta(actividadDirecta);


        adminRepositorio.registraAdminDB(admin);


    }

    @Override
    public void listarAdmin() {
      adminRepositorio.mostrarAdmins();
    }

    @Override
    public void buscarAdminPorId(int id) {
 
        adminRepositorio.buscarAdminPorId(id);

    }

    @Override
    public void deleteAdminId(int id) {
        adminRepositorio.deleteAdminId(id);
    }

    @Override
    public void updateAdmin(Admin admin) {

        System.out.println("Actualizar Administrador");

        System.out.println("""
                Elija el Campo a actualizar
                1) Nombre
                2) Apellido
                3) Telefono
                4) Actividad Directa
                """);

        int option = sc.nextInt();
        sc.nextLine();

        switch (option){

            case 1:
                System.out.println("Ingrese el nuevo nombre ");
                String nombre = sc.nextLine();
                sc.nextLine(); // Consumir el salto de línea pendiente
                System.out.println("Ingrese el Id del Administrador a actualizar ");
                int id = sc.nextInt();
                admin.setId(id);
                admin.setNombre(nombre);
                admin.setApellido(null);
                admin.setActividadDirecta(null);
                admin.setTelefono(null);
                adminRepositorio.updateAdmin(admin);
                break;
            case 2:
                System.out.println("Ingrese el nuevo apellido ");
                String apellido = sc.nextLine();
                System.out.println("Ingrese el Id del Admin a actualizar ");
                id = sc.nextInt();
                admin.setId(id);
                admin.setApellido(apellido);
                admin.setNombre(null);
                admin.setActividadDirecta(null);
                admin.setTelefono(null);
                adminRepositorio.updateAdmin(admin);
                break;
            case 3:
                System.out.println("Ingrese el nuevo Telefono ");
                String telefono = sc.nextLine();
                sc.nextLine(); // Consumir el salto de línea pendiente
                System.out.println("Ingrese el Id del Administrador a actualizar ");
                id = sc.nextInt();
                admin.setId(id);
                admin.setTelefono(telefono);
                admin.setNombre(null);
                admin.setActividadDirecta(null);
                admin.setApellido(null);


                adminRepositorio.updateAdmin(admin);
                break;
            case 4:
                System.out.println("Ingrese La Nueva actividad directa ");
                String actividadDirecta = sc.nextLine();
                sc.nextLine(); // Consumir el salto de línea pendiente
                System.out.println("Ingrese el Id del Administrador a actualizar ");
                id = sc.nextInt();
                admin.setId(id);
                admin.setActividadDirecta(actividadDirecta);
                admin.setNombre(null);
                admin.setTelefono(null);
                admin.setApellido(null);
                adminRepositorio.updateAdmin(admin);
                break;
            default:
                System.out.println("Opción no válida");
                break;
        }
    }

}
