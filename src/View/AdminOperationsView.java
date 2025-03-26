package View;

import java.util.ArrayList;
import java.util.Scanner;

import Controller.AdminOperationsController;
import Model.Shoe;

class AdminOperationsView {
    AdminOperationsController adminOperationsController;
    public AdminOperationsView(AdminOperationsController adminOperationsController){
        this.adminOperationsController=adminOperationsController;
    }
    Scanner in=new Scanner(System.in);
    public void AdminOperations(){

        System.out.println();
        int choice;
        do{
            System.out.println("1.Add New Sneaker");
            System.out.println("2.Update Existing Sneaker");
            System.out.println("3.Delete a Sneaker Record");
            System.out.println("4.Display Sneakers");
            System.out.println("5.LogOut");
            System.out.println();
            System.out.print("Enter Value: ");
            choice=in.nextInt();
            if(choice<=0 && choice>5){
                System.out.println("Invalid Input...Try Again");
            }
        }while(choice<=0 &&  choice>5);
        if(choice==2){
            System.out.println();
            System.out.print("Enter Sneaker ID: ");
            int sid=in.nextInt();
            System.out.println();
            System.out.print("Enter the field you want to update: ");
            String field=in.next();
            System.out.println();
            System.out.print("Enter value you want to update with: ");
            in.nextLine();
            String val=in.nextLine();
            boolean upcheck=adminOperationsController.updateShoe(sid,field,val);
            if(upcheck==true){
                System.out.println("Updated Successfully");
            }
            else{
                System.out.println("Sneaker ID Invalid");
            }
        }
        if(choice==3){
            int opt;
            do{
                System.out.println();
                System.out.println("----------------------------------------------");
                System.out.println("| 1.Delete Sneaker by ID                     |");
                System.out.println("| 2.Delete Sneaker by Brand                  |");
                System.out.println("| 3.Delete Sneaker by Size                   |");
                System.out.println("----------------------------------------------");
                System.out.println();
                System.out.print("Enter Value: ");
                opt=in.nextInt();
                if(opt<1 && opt>3){
                    System.out.println("Invalid Input...Try Again");
                }
            }while(opt<1 && opt>3);
            if(opt==1){
            System.out.println();
            System.out.print("Enter Sneaker ID to delete: ");
            int sid=in.nextInt();
            System.out.println();
            boolean delcheck=adminOperationsController.deleteShoeById(sid);
            if(delcheck==true){
                System.out.println("Deleted Successfully");
            }
            else{
                System.out.println("Invalid Sneaker ID");
            }
            }
            if(opt==2){
            System.out.println();
            System.out.print("Enter Sneaker Brand to delete: ");
            String sbrand=in.next();
            System.out.println();
            boolean delcheck=adminOperationsController.deleteShoeByBrand(sbrand);
            if(delcheck==true){
                System.out.println("Deleted Successfully");
            }
            else{
                System.out.println("Brand Not Found");
            }
            }
            if(opt==3){
            System.out.println();
            System.out.print("Enter Sneaker Size to delete: ");
            int ssize=in.nextInt();
            System.out.println();
            boolean delcheck=adminOperationsController.deleteShoeBySize(ssize);
            if(delcheck==true){
                System.out.println("Deleted Successfully");
            }
            else{
                System.out.println("Size Not Found");
            }
            }
        }
        if(choice==5){
            Display display=new Display();
            display.display();
            return;
        }
        if(choice==4){
            int opt;
            do{
                System.out.println();
                System.out.println("----------------------------------------------");
                System.out.println("| 1.Search Sneaker by ID                     |");
                System.out.println("| 2.Search Sneaker by Brand                  |");
                System.out.println("| 3.Search Sneaker by Size                   |");
                System.out.println("----------------------------------------------");
                System.out.println();
                System.out.print("Enter Value: ");
                opt=in.nextInt();
                if(opt<1 && opt>3){
                    System.out.println("Invalid Input...Try Again");
                }
            }while(opt<1 && opt>3);
            if(opt==1){
                System.out.println();
                System.out.print("Enter Sneaker ID to view: ");
                int sid=in.nextInt();
                ArrayList<Shoe> al=adminOperationsController.viewById(sid);
                if(al.size()==0){
                    System.out.println("Not Available");
                }
                else{
                    Shoe shoe=al.get(0);
                    System.out.println("ID: "+shoe.getSid()+" | Name: "+shoe.getSname()+" | Brand: "+shoe.getSbrand()+" | Size: "+shoe.getSsize()+" | Wearable By: "+shoe.getGender()+" | Price: "+shoe.getSprice());
                }
            }
            if(opt==2){
                System.out.println();
                System.out.print("Enter Sneaker Brand to view: ");
                String brand=in.next().toLowerCase();
                ArrayList<Shoe> al=adminOperationsController.viewByBrand(brand);
                if(al.size()==0){
                    System.out.println("Not Available");
                }
                else{
                    for(Shoe shoe:al){
                        System.out.println();
                        System.out.println("ID: "+shoe.getSid()+" | Name: "+shoe.getSname()+" | Brand: "+shoe.getSbrand()+" | Size: "+shoe.getSsize()+" | Wearable By: "+shoe.getGender()+" | Price: "+shoe.getSprice());
                    }
                }
            }
            if(opt==3){
                System.out.println();
                System.out.print("Enter your sneaker size to view: ");
                int size=in.nextInt();
                ArrayList<Shoe> al=adminOperationsController.viewBySize(size);
                if(al.size()==0){
                    System.out.println("Not Available");
                }
                else{
                    for(Shoe shoe:al){
                        System.out.println();
                        System.out.println("ID: "+shoe.getSid()+" | Name: "+shoe.getSname()+" | Brand: "+shoe.getSbrand()+" | Size: "+shoe.getSsize()+" | Wearable By: "+shoe.getGender()+" | Price: "+shoe.getSprice());
                    }
                }
            }
        }
        if(choice==1){
            in.nextLine();
            System.out.println();
            System.out.print("Enter Sneaker Name: ");
            String sname=in.nextLine();
            System.out.println();
            System.out.print("Enter Sneaker Brand: ");
            String sbrand=in.nextLine();
            System.out.println();
            System.out.print("Enter Sneaker Price: ");
            String op=in.next();
            String sprice="";
            for(int i=0;i<op.length();i++){
                if(op.charAt(i)>='0' && op.charAt(i)<='9')
                sprice+=""+op.charAt(i);
            }
            System.out.println();
        System.out.print("Enter Gender: ");
        String gender=in.next();
        System.out.println();
        System.out.print("Enter Sneaker Size: ");
        int ssize=in.nextInt();
        System.out.println();
        System.out.print("Enter Sneaker Stock: ");
        int scount=in.nextInt();
        System.out.println();
        boolean check=adminOperationsController.insertShoe(sname.toLowerCase(), sbrand.toLowerCase(), ssize, scount, sprice, gender.toLowerCase());
        if(check==true){
            System.out.println("Inserted Successfully");
        }
        else{
            System.out.println("Sneaker Already Exists");
        }
        }
        int decision;
        do{
            System.out.println();
            System.out.println("Enter 0 to continue or 1 to logout...");
            System.out.println();
            System.out.print("Enter Value: ");
            decision=in.nextInt();
            if(decision<0 && decision>1){
                System.out.println("Invalid Input...Try Again");
            }
        }while(decision<0 && decision>1);
        if(decision==1){
            Display display=new Display();
            display.display();
        }
        else{
            AdminOperations();
        }
    }
}
