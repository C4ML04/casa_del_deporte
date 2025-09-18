package servicios;

import modelo.dominio.UserLogin;

public interface UsserLoginInterface {

    public void registerUsserLogIn(UserLogin userLogin);

    public void listarUsserLoogin();

    public void buscarUsserLoginPorUsser(String user);

    public void deleteUsserPorIdLog(int id);

    public  void updateUsserPorEmail(UserLogin userLogin);

    public void sesionAcces();
}
