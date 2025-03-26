package View;

import Controller.BillController;
import java.util.*;
import Model.*;
public class BillView {
    Scanner in=new Scanner(System.in);
    BillController billController;
    public BillView(BillController billController){
    this.billController=billController;
    }
    public int generateBill(int user_id,int sid){
        System.out.println();
            Shoe shoeDetails=billController.generateBill(user_id, sid);
            if(shoeDetails.getSid()!=0){
                int choice;
                do{
                    System.out.println("1.To Proceed With Payment");
                    System.out.println("2.Go Back");
                    System.out.println();
                    System.out.print("Enter Value: ");
                    choice=in.nextInt();
                    if(choice<1 || choice>2){
                        System.out.println("Invalid Input...Try Again");
                    }
                }while(choice<1 || choice>2);
                if(choice==2){
                    System.out.println("Booking Cancelled...");
                    return 0;
                }
                if(choice==1){
                    System.out.println();
                    System.out.println("Your Order Details: ");
                    System.out.println();
                    System.out.println(shoeDetails.toString());
                    System.out.println();
                    System.out.println("Amount to pay: "+shoeDetails.getSprice());
                    int pay;
                    do{
                        System.out.println("1. To pay");
                        System.out.println("2. Cancel Booking");
                        System.out.println();
                        System.out.print("Enter value: ");
                        pay=in.nextInt();
                        if(pay<1 || pay >2){
                            System.out.println();
                            System.out.println("Invalid Input...Try Again!!!");
                        }
                    }while(pay<1 || pay>2);
                    if(pay==2){
                        System.out.println("Booking Cancelled...");
                        return 0;
                    }
                    if(pay==1){
                        System.out.println("Payment Received");
                        return 200;
                    }
                }
            }
            else{
                System.out.println("Invalid Sneaker ID...Try Again");
                return 0;
            }
        return 1;
    }
}
