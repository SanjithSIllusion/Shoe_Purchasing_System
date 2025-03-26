package Dao;
import Model.EstablishConnection;
import Model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class UserDaoImpl implements UserDAO{
Connection con;
public UserDaoImpl(){
    con=EstablishConnection.getDbConnection();
}
public int addUser(User user){
String username=user.getUsername().trim();
String email=user.getEmail().trim();
String password=user.getPassword().trim();
String phone=user.getPhone().trim();
String gender=user.getGender().trim();
String role=user.getRole().trim();

String numbercheck="Select * from User_Details where user_phone=?";
PreparedStatement pst;
try {
    pst=con.prepareStatement(numbercheck);
    pst.setString(1, phone);
    ResultSet rs=pst.executeQuery();
    if(rs.next()){
        return 101;
    }
    else{
        String emailcheck="Select * from User_Details where user_email=?";
        pst=con.prepareStatement(emailcheck);
        pst.setString(1, email);
        ResultSet rs1=pst.executeQuery();
        if(rs1.next()){
            return 102;
        }
        else{
            String insert="Insert into User_Details(user_email,user_name,user_phone,user_role,user_pass,user_gender) values (?,?,?,?,?,?)";
            pst=con.prepareStatement(insert);
            pst.setString(1, email);
            pst.setString(2,username);
            pst.setString(3, phone);
            pst.setString(4, role);
            pst.setString(5, password);
            pst.setString(6, gender);
            int x=pst.executeUpdate();
            if(x==1){
                if(role.equals("Admin")){
                    return -1;
                }
                else{
                    String y="Select user_id from User_Details where user_email=?";
                    pst=con.prepareStatement(y);
                    pst.setString(1, email);
                    ResultSet u=pst.executeQuery();
                    if(u.next()){
                        return u.getInt(1);
                    }
                }
            }
            else{
                return 99;
            }
        }
    }
} catch (Exception e) {
    // TODO: handle exception
}

return 0;
}
public int validateLogin(User user){
    String email=user.getEmail().trim();
    String password=user.getPassword().trim();
    String checkUser="Select * from User_Details where user_email=?";
    PreparedStatement pst;
    try {
        pst=con.prepareStatement(checkUser);
        pst.setString(1, email);
        ResultSet rs=pst.executeQuery();
        if(!rs.next()){
            return 404;
        }
        else{
            String getPassword=rs.getString(6);
            if(getPassword.equals(password)){
                if(rs.getString(5).equals("Admin")){
                    return -1;
                }
                return rs.getInt(1);
            }
            else{
                return 99;
            }
        }
    } catch (Exception e) {
        // TODO: handle exception
    }
    return 0;
}
}