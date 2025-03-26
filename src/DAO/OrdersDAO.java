package Dao;
import Model.Order;
import java.util.*;
/**
 * OrdersDAO
 */
public interface OrdersDAO {
    public ArrayList<Order> getOrders(int id);
    public boolean placeOrder(int id,int user_id);
}
