package servicios;

import modelo.dominio.Admin;
import modelo.dominio.Persona;

public interface AdminInterface {

    public void registrarPersona(Admin admin);

    public void listarPersona();

}
