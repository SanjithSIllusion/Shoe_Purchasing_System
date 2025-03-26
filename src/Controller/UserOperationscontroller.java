package Controller;
import Dao.ShoeDAO;
import Model.Shoe;
import java.util.*;
import Dao.CartDAO;
import Model.Cart;
public class UserOperationscontroller {
    ShoeDAO shoeDAO;
    CartDAO cartDAO;
    public UserOperationscontroller(ShoeDAO shoeDAO,CartDAO cartDAO){
        this.cartDAO=cartDAO;
        this.shoeDAO=shoeDAO;
    }
    public ArrayList<Shoe> viewById(int id){
        ArrayList<Shoe> al=shoeDAO.viewById(id);
        return al;
    }
    public ArrayList<Shoe> viewByBrand(String brand){
        ArrayList<Shoe> al=shoeDAO.viewByBrand(brand);
        return al;
    }

    public ArrayList<Shoe> viewBySize(int size){
        ArrayList<Shoe> al=shoeDAO.viewBySize(size);
        return al;
    }


    public boolean insertToCart(int sid,int user_id){
        boolean t=cartDAO.insertToCart(user_id, sid);
        return t;
    }

    public ArrayList<Cart> getCardDetails(int id){
        ArrayList<Cart> al=cartDAO.getCartDetails(id);
        return al;
    }

    public ArrayList<Shoe> returnOrders(int id){
        ArrayList<Shoe> al=shoeDAO.returnOrders(id);
        return al;
    }
}