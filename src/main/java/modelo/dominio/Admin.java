package modelo.dominio;

public class Admin extends Persona{

    //atributos
    private String actividadDirecta;

    //cosntructor

    public Admin(){
        super();
    }

    public Admin(int id, String nombre, String apellido, String telefono, String tipoDeDoc, String numberCc, String actividadDirecta) {
        super(id, nombre, apellido, telefono, tipoDeDoc, numberCc);
        this.actividadDirecta = actividadDirecta;
    }

    //getters y setters

    public String getActividadDirecta() {
        return actividadDirecta;
    }

    public void setActividadDirecta(String actividadDirecta) {
        this.actividadDirecta = actividadDirecta;
    }
}
