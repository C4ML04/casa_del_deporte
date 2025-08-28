package modelo.dominio;

import java.util.Date;

public class UsuarioExterno extends Persona{

    //atributos
    Date fechaDeNacimiento;
    private boolean haciendoMusculacion;
    private boolean EsDeportistaActivo;

    //constructor

    public UsuarioExterno(int id, String nombre, String apellido, String telefono, String tipoDeDoc, String numberCc, Date fechaDeNacimiento, boolean haciendoMusculacion, boolean esDeportistaActivo) {
        super(id, nombre, apellido, telefono, tipoDeDoc, numberCc);
        this.fechaDeNacimiento = fechaDeNacimiento;
        this.haciendoMusculacion = haciendoMusculacion;
        this.EsDeportistaActivo = esDeportistaActivo;

    }

    public UsuarioExterno() {
        super();
    }

    //getters y setters

    public Date getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }

    public void setFechaDeNacimiento(Date fechaDeNacimiento) {
        this.fechaDeNacimiento = fechaDeNacimiento;
    }

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
