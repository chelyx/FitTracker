import DBConnection.DBConnection;
import Users.SqlUsers;

import javax.rmi.ssl.SslRMIClientSocketFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main { /* pa probar cosas*/
    public static void main(String[] args) {
//        DBConnection DB = new DBConnection();
        SqlUsers usTest = new SqlUsers();
        Statement st;
        ResultSet rs;
        PreparedStatement ps;
//        Connection cn = (Connection) DB.getConexion();
/*
        try {
            st=cn.createStatement();
            rs=st.executeQuery("select * from TEST1");
            while (rs.next()) {
                System.out.println(rs.getString("id")+" " +rs.getString("Nombre")+" " +rs.getString("Contraseña"));
            }

        } catch (Exception e) {
        }

        try{
           Boolean resultado = usTest.registrateUser("tubosterito97","Juan123456");
           if (resultado){
               System.out.println("Agregado con exito");
            }
        }catch (Exception e){
        }

        Integer num = usTest.getId("tubosterito98") ;
        System.out.println(num);
*/

/*
        try{
            Boolean resultado = usTest.registratePerson(1,"Juan","Ferro",21,1124789473l,"juanignacioferro_07@hotmail.com",82.2f,185);
            if (resultado){
                System.out.println("Agregado con exito");
            }
        }catch (Exception e){
        }
    }
*/

}
}
