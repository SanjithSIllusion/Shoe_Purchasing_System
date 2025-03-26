package View;
import java.util.ArrayList;
import java.util.Scanner;

import Controller.CartContoller;
import Controller.OrderController;
import Controller.UserOperationscontroller;
import Dao.CartDAO;
import Dao.CartDaoImpl;
import Dao.OrderDaoImpl;
import Dao.OrdersDAO;
import Dao.ShoeDAO;
import Dao.ShoeDaoImpl;
import Model.Cart;
import Model.Shoe;

public class CartView {
   Scanner in=new Scanner(System.in);
   CartContoller cartContoller;
   public CartView(CartContoller cartContoller){
    this.cartContoller=cartContoller;
   }
   CartDAO cartDAO=new CartDaoImpl();
   ShoeDAO shoeDAO=new ShoeDaoImpl();
   UserOperationscontroller userOperationscontroller=new UserOperationscontroller(shoeDAO, cartDAO);
   public void getCartDetails(int id){
      System.out.println();
      ArrayList<Cart> al=cartContoller.getCartDetails(id);
      if(al.size()==0){
         System.out.println("Your Cart is Empty");
      } 
      else{
         System.out.println("Your Cart: ");
         ArrayList<Integer> cl=new ArrayList<>();
          for(Cart item:al){
               System.out.println();
               ArrayList<Shoe> bl=userOperationscontroller.viewById(item.getSid());
               cl.add(item.getSid());
               for(Shoe shoe:bl){
                  System.out.println("ID: "+shoe.getSid()+" | Name: "+shoe.getSname()+" | Brand: "+shoe.getSbrand()+" | Size: "+shoe.getSsize()+" | Wearable By: "+shoe.getGender()+" | Price: "+shoe.getSprice());
              }
          }
         System.out.println();
         int process;
         do{
            System.out.println("1.Order a Sneaker");
            System.out.println("2.Go Back");
            System.out.println();
            System.out.print("Enter Value: ");
            process=in.nextInt();
            if(process<1 || process>2){
               System.out.println("Invalid Input...Try Again");
            }
         }while(process<1 || process>2);
         if(process==2){
            UserOperationsView userOperationsView=new UserOperationsView(userOperationscontroller);
            userOperationsView.UserViewPage(id);
         }
         if(process==1){
         OrderView orderView=new OrderView();
         orderView.SpecificSneaker(id);
         }
      }
   }

   public void insertToCart(int user_id){
      System.out.println();
      System.out.print("Enter Sneaker ID to add it to cart: ");
      int sid=in.nextInt();
      boolean checksts=cartContoller.addToCart(user_id, sid);
      if(checksts==true){
         System.out.println("Added To Cart");
      }
      else{
         System.out.println("Not Available");
      }
   }
}
