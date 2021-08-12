package Notificador;

import Users.Persona;

public interface Notifier {
    public void notify(Persona aPerson, Notification message);
}
