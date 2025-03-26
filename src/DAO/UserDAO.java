package Dao;
import Model.User;
public interface UserDAO {
    int addUser(User user);
    int validateLogin(User user);
}
