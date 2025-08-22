package modelo.dominio;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Locale;

public class Reserva {

    //atributos

    private int idReserva;
    private LocalDate fechaReserva;
    private LocalDateTime horaReserva;
    private boolean entrenamientoAsistido;
    private UsuarioExterno usuarioExterno;
    private Admin admin;

    //cosntructor


    public Reserva(int idReserva, LocalDate fechaReserva, LocalDateTime horaReserva, boolean entrenamientoAsistido,
                   UsuarioExterno usuarioExterno, Admin admin) {
        this.idReserva = idReserva;
        this.fechaReserva = fechaReserva;
        this.horaReserva = horaReserva;
        this.entrenamientoAsistido = entrenamientoAsistido;
        this.usuarioExterno = usuarioExterno;
        this.admin = admin;
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
