package Dao;
import Model.Cart;
import java.util.*;
public interface CartDAO {
    public ArrayList<Cart> getCartDetails(int uid);
    public boolean insertToCart(int uid,int sid);
}