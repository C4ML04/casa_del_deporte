package modelo.dominio;

public class UsuarioExterno extends Persona{

    //atributos
    private boolean haciendoMusculacion;
    private boolean EsDeportistaActivo;

    //constructor

    public UsuarioExterno(int id, String nombre, String apellido, String telefono, String tipoDeDoc, String numberCc, boolean haciendoMusculacion, boolean esDeportistaActivo) {
        super(id, nombre, apellido, telefono, tipoDeDoc, numberCc);
        this.haciendoMusculacion = haciendoMusculacion;
        EsDeportistaActivo = esDeportistaActivo;
    }

    public UsuarioExterno() {
        super();
    }

    //getters y setters


    public boolean isHaciendoMusculacion() {
        return haciendoMusculacion;
    }

    public void setHaciendoMusculacion(boolean haciendoMusculacion) {
        this.haciendoMusculacion = haciendoMusculacion;
    }

    public boolean isEsDeportistaActivo() {
        return EsDeportistaActivo;
    }

    public void setEsDeportistaActivo(boolean esDeportistaActivo) {
        EsDeportistaActivo = esDeportistaActivo;
    }
}
