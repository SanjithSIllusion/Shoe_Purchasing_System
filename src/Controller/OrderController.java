package Controller;

import Dao.OrdersDAO;

public class OrderController {
    OrdersDAO ordersDAO;
    public OrderController(OrdersDAO ordersDAO){
        this.ordersDAO=ordersDAO;
    }

    public boolean placeOrder(int id,int user_id){
        boolean t=ordersDAO.placeOrder(id, user_id);
        return t;
    }
}
