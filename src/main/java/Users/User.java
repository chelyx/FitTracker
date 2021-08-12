package Users;

import DBConnection.DBConnection;

import java.sql.*;

public class User {
    String usuario;
    String contraseña;
    Persona persona;

    public User(String usuario, String contraseña, Persona persona) {
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.persona = persona;
    }


}
