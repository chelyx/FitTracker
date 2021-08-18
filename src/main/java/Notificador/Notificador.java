package Notificador;

import entities.Usuario;

public interface Notificador {
    public void notify(Usuario aPerson, Notification message);
}
