package modelo.dominio;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Reserva {

    //atributos

    private int idReserva;
    private LocalDate fechaReserva;
    private LocalDateTime horaReserva;
    private boolean entrenamientoAsistido;
    private UsuarioExterno usuarioExterno;
    private Admin admin;
    private int idUsuario;
    private int idAdmin;

    //cosntructor


    public Reserva(int idReserva, LocalDate fechaReserva, LocalDateTime horaReserva, boolean entrenamientoAsistido,
                   UsuarioExterno usuarioExterno, Admin admin) {
        this.idReserva = idReserva;
        this.fechaReserva = fechaReserva;
        this.horaReserva = horaReserva;
        this.entrenamientoAsistido = entrenamientoAsistido;
        this.usuarioExterno = usuarioExterno;
        this.admin = admin;
        this.idUsuario = idUsuario;
        this.idAdmin =  idAdmin;
    }

    public Reserva(){

    }

    //getters y setters

    public int getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

    public LocalDate getFechaReserva() {
        return fechaReserva;
    }

    public void setFechaReserva(LocalDate fechaReserva) {
        this.fechaReserva = fechaReserva;
    }

    public LocalDateTime getHoraReserva() {
        return horaReserva;
    }

    public void setHoraReserva(LocalDateTime horaReserva) {
        this.horaReserva = horaReserva;
    }

    public boolean isEntrenamientoAsistido() {
        return entrenamientoAsistido;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdAdmin() {
        return idAdmin;
    }

    public void setIdAdmin(int idAdmin) {
        this.idAdmin = idAdmin;
    }

    public void setEntrenamientoAsistido(boolean entrenamientoAsistido) {
        this.entrenamientoAsistido = entrenamientoAsistido;
    }

    public UsuarioExterno getUsuarioExterno() {
        return usuarioExterno;
    }

    public void setUsuarioExterno(UsuarioExterno usuarioExterno) {
        this.usuarioExterno = usuarioExterno;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }
}
