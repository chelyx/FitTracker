package Users;
import DBConnection.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SqlUsers {

    public boolean registrateUser(String user, String pw){
        Connection conexion = new DBConnection().getConexion();
        String sql = "INSERT INTO TUSERS (USERNAME,PASSWORD) VALUES (?,?)";
        try {
            PreparedStatement st = conexion.prepareStatement(sql);
            st.setString(1, user);
            st.setString(2, pw);
            st.execute();
            conexion.close();
            return true;
        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }
    }
    public int getId(String user){
        Connection conexion = new DBConnection().getConexion();
        String sql = "SELECT ID FROM TUSERS WHERE USERNAME = ?";
        try{
            PreparedStatement st = conexion.prepareStatement(sql);
            st.setString(1,user);
            ResultSet rs =  st.executeQuery();
            rs.next();
            return rs.getInt("ID");

        }catch (SQLException throwables){
            throwables.printStackTrace();
            return -1;
        }
    }
    public boolean registratePerson(Integer id, String name, String lastName, Integer age, Long phone, String mail, Float weight, Integer height){
        Connection conexion = new DBConnection().getConexion();
        String sql = "INSERT INTO TPEOPLE VALUES (?,?,?,?,?,?,?,?)";
        try{
            PreparedStatement st = conexion.prepareStatement(sql);
            st.setInt(1, id);
            st.setString(2, name);
            st.setString(3, lastName);
            st.setInt(4, age);
            st.setFloat(5, weight);
            st.setInt(6, height);
            st.setLong(7, phone);
            st.setString(8, mail);
            st.execute();
            conexion.close();
            return true;
        }catch(SQLException throwables){
            throwables.printStackTrace();
            return false;
        }
    }


}
