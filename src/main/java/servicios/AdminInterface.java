package servicios;

import modelo.dominio.Admin;
import modelo.dominio.Persona;

public interface AdminInterface {

    public void registrarAdmin(Admin admin);

    public void listarAdmin();

    public void buscarAdminPorId(int id);

    public void deleteAdminId(int id);

    public void updateAdmin(Admin admin);

}
