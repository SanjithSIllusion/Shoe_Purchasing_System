package Dao;
import java.sql.PreparedStatement;
import java.util.*;
import Model.Cart;
import Model.EstablishConnection;

import java.sql.*;

public class CartDaoImpl implements CartDAO {
    private Connection con;
    public CartDaoImpl(){
        con=EstablishConnection.getDbConnection();
    }
    public ArrayList<Cart> getCartDetails(int sid){
        String query="Select * from cart where user_id=?";
        ArrayList<Cart> al=new ArrayList<>();
        PreparedStatement pst;
        try {
            pst=con.prepareStatement(query);
            pst.setInt(1, sid);
            ResultSet rs=pst.executeQuery();
            while(rs.next()){
            Cart cart=new Cart(rs.getInt(3), rs.getInt(2), rs.getInt(1));
            al.add(cart);
            }
            return al;
        } catch (Exception e) {
            // TODO: handle exception
        }
        return al;
    }
    public boolean insertToCart(int uid,int sid){
        String query="Select * from cart where sid=?";
        PreparedStatement pst;
        try {
            pst=con.prepareStatement(query);
            pst.setInt(1, sid);
            ResultSet rs=pst.executeQuery();
            if(rs.next()){
            return true;
            }
            String insertCart="Insert into cart(user_id,sid) values(?,?)";
            pst=con.prepareStatement(insertCart);
            pst.setInt(1, uid);
            pst.setInt(2, sid);
            int x=pst.executeUpdate();
            if(x==1){
                return true;
            }
            else{
                return false;
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
        return false;
    }
}
