package Dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.*;

import Model.EstablishConnection;
import Model.Order;
public class OrderDaoImpl implements OrdersDAO{
    Connection con;
    public OrderDaoImpl(){
        con=EstablishConnection.getDbConnection();
    }
    public ArrayList<Order> getOrders(int id){
        return new ArrayList<>();
    }
    public boolean placeOrder(int id,int user_id){
        String query="Insert into orders(user_id,sid,odate) values(?,?,CURDATE())";
        PreparedStatement pst;
        try {
            pst=con.prepareStatement(query);
            pst.setInt(1, user_id);
            pst.setInt(2, id);
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
