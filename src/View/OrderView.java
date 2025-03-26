package View;

import java.util.Scanner;

import Controller.BillController;
import Controller.CartContoller;
import Controller.OrderController;
import Dao.CartDAO;
import Dao.CartDaoImpl;
import Dao.OrderDaoImpl;
import Dao.OrdersDAO;
import Dao.ShoeDAO;
import Dao.ShoeDaoImpl;

public class OrderView {
    Scanner in=new Scanner(System.in);
    ShoeDAO shoeDAO=new ShoeDaoImpl();
    public void SpecificSneaker(int user_id){
            System.out.print("Enter Sneaker ID: ");
            int sid=in.nextInt();
            BillController billController=new BillController(shoeDAO);
            BillView billView=new BillView(billController);
            int x=billView.generateBill(user_id,sid);
            if(x==0){
                CartDAO cartDAO=new CartDaoImpl();
                CartContoller cartContoller=new CartContoller(cartDAO);
                CartView cartView=new CartView(cartContoller);
                cartView.getCartDetails(user_id);
            }
            else if(x==200){ 
            System.out.println();
            OrdersDAO ordersDAO=new OrderDaoImpl();
            OrderController orderController=new OrderController(ordersDAO);
            boolean check=orderController.placeOrder(sid,user_id);
            if(check==true){
                System.out.println("Order Placed Successfully...Happy Kicking...");
            }
            else{
                System.out.println("Couldn't Place Order");
            }
            }
    }
}
