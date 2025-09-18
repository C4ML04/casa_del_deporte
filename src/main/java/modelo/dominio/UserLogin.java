package modelo.dominio;

public class UserLogin {

    //atributos
    private String email;
    private String password;
    private int id;

    //consttructor

    public UserLogin(){

    }

    public UserLogin(String email, String password){
        this.email=email;
        this.password=password;
    }

    //getters y setters


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

