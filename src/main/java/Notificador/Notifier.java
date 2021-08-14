package Notificador;

import entities.User;

public interface Notifier {
    public void notify(User aPerson, Notification message);
}
