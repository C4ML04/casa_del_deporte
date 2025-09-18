package servicios;

import modelo.dominio.UserLogin;
import repositorio.UsserLogInRepositorio;
import vista.App;

import java.util.Scanner;

public class UsserLogInServiceImpl implements UsserLoginInterface{




    Scanner sc=new Scanner(System.in);
    UsserLogInRepositorio usserLogInRepositorio=new UsserLogInRepositorio();



    public UsserLogInServiceImpl(UsserLogInRepositorio usserLogInRepositorio){
        this.usserLogInRepositorio=usserLogInRepositorio;
    }


    //regex

    public boolean validarUserName(String email){
        return email.matches("^[A-Za-z0-9]+@[A-Za-z0-9]+\\.[A-Za-z]{2,}$");
    }

    public boolean validarPassword(String password){
        return password.matches("^[A-Za-z0-9]+$");
    }

    @Override
    public void registerUsserLogIn(UserLogin userLogin) {

        System.out.println("INGRESE UN EMAIL");
        String email=sc.nextLine();

        System.out.println("INGRESE UN PASSWORD");
        String password = sc.nextLine();

        if (validarUserName(email) && validarPassword(password)){
            userLogin.setEmail(email);
            userLogin.setPassword(password);
            usserLogInRepositorio.registrarUsserLogInDB(userLogin);
        }else{
            System.out.println("usuario o password invalido, intente de nuevo");
        }

    }

    @Override
    public void listarUsserLoogin() {
        usserLogInRepositorio.listarUssersLogin();

    }

    @Override
    public void buscarUsserLoginPorUsser(String user) {
      usserLogInRepositorio.buscarUsserLoginPorUsser(user);
    }

    @Override
    public void deleteUsserPorIdLog(int id) {
        usserLogInRepositorio.deleteUserPorIdLog(id);

    }

    @Override
    public void updateUsserPorEmail(UserLogin userLogin) {

        int updateLogOpt;
        do {

            System.out.println("Actualizar accesos");

            System.out.println("""
                    Por favor seleccione la opcion a actualizar:
                    1)email
                    2)password
                    3)salir del menu actuzalizacion de accesos
                    """);

            updateLogOpt = sc.nextInt();
            sc.nextLine();

            switch (updateLogOpt) {
                case 1:
                    System.out.println("Ingrese el nuevo email: ");
                    String email= sc.nextLine();
                    sc.nextLine();
                    System.out.println("ingrese el id del acceso a actualizar");
                    int id = sc.nextInt();

                    userLogin.setId(id);
                    userLogin.setEmail(email);
                    userLogin.setPassword(null);

                    usserLogInRepositorio.updateAccesoPorId(userLogin);

                    break;
                case 2:
                    System.out.println("ingrese el nuevo password: ");
                    String password = sc.nextLine();
                    sc.nextLine();
                    System.out.println("ingrese el id del acceso a actualizar: ");
                    id = sc.nextInt();

                    userLogin.setId(id);
                    userLogin.setPassword(password);
                    userLogin.setEmail(null);

                    usserLogInRepositorio.updateAccesoPorId(userLogin);
                    break;
                case 3:
                    System.out.println("terminando operacion");
                    break;
                default:
                    System.out.println("elija una de las opciones indicadas ");
            }
        }while (updateLogOpt!=3);

    }

    @Override
    public void sesionAcces() {


        App app =new App();
        System.out.println("==================INICIO DE SESIÓN===================");

        System.out.println("ingrese su email: ");
        String email = sc.nextLine();

        System.out.println("ingrese su password: ");
        String password = sc.nextLine();

          if (usserLogInRepositorio.confirmrAcceso(email,password)){
              System.out.println("succesfull acces ");
              app.masterMenuAdmin();

          }else {
              System.out.println("something is going wrong");
          }
    }
}
