package servicios;

import modelo.dominio.UsuarioExterno;
import modelo.dominio.Persona;

public interface UsuarioExternoInterface {

    public void registrarUsuarioExterno(UsuarioExterno usuarioExterno);

    public void listarUsuariosExternos();
}
