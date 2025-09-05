package servicios;

import modelo.dominio.Reserva;
public interface ReservaInterface {

    public void registrarReserva(Reserva reserva);

    public void actualizarReserva(Reserva reserva);

    public void listarReservas ();

    public void elimiarReserva(int id_reserva);

}
