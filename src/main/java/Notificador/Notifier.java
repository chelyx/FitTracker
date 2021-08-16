package Notificador;

import entities.Usuario;

public interface Notifier {
    public void notify(Usuario aPerson, Notification message);
}
