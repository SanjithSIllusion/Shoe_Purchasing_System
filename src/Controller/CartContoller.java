package Controller;
import java.util.*;
import Model.Cart;
import Dao.CartDAO;

public class CartContoller {
    CartDAO cartDAO;
    public CartContoller(CartDAO cartDAO){
        this.cartDAO=cartDAO;
    }
    public ArrayList<Cart> getCartDetails(int id){
        ArrayList<Cart> al=cartDAO.getCartDetails(id);
        return al;
    }

    public boolean addToCart(int user_id,int sid){
        boolean t=cartDAO.insertToCart(user_id, sid);
        return t;
    }
}
