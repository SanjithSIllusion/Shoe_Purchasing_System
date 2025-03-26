package Controller;

import Dao.UserDAO;
import Model.User;
public class UserController {
    UserDAO userDAO;
    public UserController(UserDAO userDAO){
        this.userDAO=userDAO;
    }

    public int validateRegistration(String username,String email,String phone,String password,String confirmpassword,String gender,String role){
        if(username.length()>0 && email.length()>0 && phone.length()>0 && password.length()>0 && confirmpassword.length()>0 && gender.length()>0 && role.length()>0){
            if(!email.matches( "^[A-Za-z0-9_+&-]+(?:\\.[A-Za-z0-9_+&-]+)*@(?:[A-Za-z0-9-]+\\.)+[A-Za-z]{2,7}$")){
                return 401;
            }
            if(!confirmpassword.equals(password)){
                return 402;
            }
            if(!phone.matches("^[0-9]{10}$")){
                return 403;
            }
            User user=new User(username, email, phone, password, confirmpassword, gender, role);
            int k=userDAO.addUser(user);
            return k;
        }
        else{
            return 404;
        }
    }

    public int validateLogin(String email,String password){
        if(email!=null && password!=null){
            if(!email.matches( "^[A-Za-z0-9_+&-]+(?:\\.[A-Za-z0-9_+&-]+)*@(?:[A-Za-z0-9-]+\\.)+[A-Za-z]{2,7}$")){
                return 401;
            }
            User user=new User(null,email, null, password, null, null, null);
            int k=userDAO.validateLogin(user);
            return k;
        }
        else{
            return 404;
        }
    }
    
}
