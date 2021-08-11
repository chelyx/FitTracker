import DBConnection.DBConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main { /* pa probar cosas*/
    public static void main(String[] args) {
        DBConnection cn = new DBConnection();
        Statement st;
        ResultSet rs;
        Connection DB = (Connection) cn.getConexion();

        try {
            st=DB.createStatement();
            rs=st.executeQuery("select * from TEST1");
            while (rs.next()) {
                System.out.println(rs.getString("id")+" " +rs.getString("Nombre")+" " +rs.getString("Contraseña"));
            }
            DB.close();
        } catch (Exception e) {
        }
    }





}
