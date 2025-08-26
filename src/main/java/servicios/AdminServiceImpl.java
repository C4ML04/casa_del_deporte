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

    }
}
