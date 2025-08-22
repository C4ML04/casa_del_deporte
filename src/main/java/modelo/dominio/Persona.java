package modelo.dominio;

public class Persona {

    //atributos

    private int id;
    private String nombre;
    private String apellido;
    private String telefono;
    private String tipoDeDoc;
    private String numberCc;

    //cosntructor

    public Persona(int id, String nombre, String apellido, String telefono, String tipoDeDoc, String numberCc) {

        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono=telefono;
        this.tipoDeDoc = tipoDeDoc;
        this.numberCc=numberCc;
    }

    public Persona(){

    }

    //getters y setters

    public void setId(int id){
        this.id=id;
    }

    public int getId(){
        return  id;
    }

    public void setNombre(String nombre){
        this.nombre=nombre;
    }

    public String getNombre(){
        return nombre;
    }

    public void setApellido(String apellido){
        this.apellido=apellido;
    }

    public String getApellido(){
        return apellido;
    }

    public void setTelefono(String telefono){
        this.telefono=telefono;
    }

    public String getTelefono(){
        return telefono;
    }

    public void setTipoDeDoc(String tipoDeDoc){
        this.tipoDeDoc=tipoDeDoc;
    }

    public String getTipoDeDoc(){
        return tipoDeDoc;
    }

    public void setNumberCc(String numberCc){
        this.numberCc=numberCc;
    }

    public String getNumberCc(){
        return numberCc;
    }





}
