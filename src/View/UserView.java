package View;
import java.util.Scanner;
import Controller.UserOperationscontroller;
import Dao.ShoeDAO;
import Dao.ShoeDaoImpl;
import Controller.AdminOperationsController;
import Dao.CartDAO;
import Dao.CartDaoImpl;
import Controller.UserController;
public class UserView {
    UserController userController;
    public UserView(UserController userController){
        this.userController=userController;
    }
    public void Register(){
        Scanner in=new Scanner(System.in);
        System.out.print("Enter Username: ");
        String username=in.next();
        System.out.println();
        in.nextLine();
        System.out.print("Enter Your Email: ");
        String email=in.nextLine();
        System.out.println();
        System.out.print("Enter Your Phone Number: ");
        String number=in.nextLine();
        System.out.println();
        System.out.print("Enter Your Password: ");
        String password=in.nextLine();
        System.out.println();
        System.out.print("Re-Enter Your Password: ");
        String confirmpassword=in.nextLine();
        System.out.println();
        System.out.println("Choose Your Gender:");
        System.out.println("Press 1 for Male 2 for Female 3 for Others");
        System.out.println("1.) Male");
        System.out.println("2.) Female");
        System.out.println("3.) Others");
        int p=in.nextInt();
        if(p!=1 || p!=2 || p!=3) {
            while(p!=1 && p!=2 && p!=3){
                System.err.println();
                System.err.println("Invalid Choice\nTry Again");
                System.out.println();
                System.out.println("Choose Your Gender:");
                System.out.println("Press 1 for Male 2 for Female 3 for Others");
                System.out.println("1.) Male");
                System.out.println("2.) Female");
                System.out.println("3.) Others");
                p=in.nextInt();
                if(p==1 || p==2 || p==3) {
                    break;
                }
            }
        }
        String gender="";
        if(p==1){
            gender+="Male";
        }
        else if(p==2){
            gender+="Female";
        }
        else if(p==3){
            gender+="Others";
        }
        System.out.println();
        System.out.println("Choose Your Role:");
        System.out.println("Press 1 for User 2 for Vehicle Lender");
        System.out.println("1.) User");
        System.out.println("2.) Admin");
        int h=in.nextInt();
        String role="";
        if(( h!=1 && h!=2)){
            while( h!=1 || h!=2){
                System.err.println();
                System.err.println("Invalid Choice\nTry Again");
                System.out.println();
                System.out.println("Choose Your Role:");
                //change here
                System.out.println("Press 1 for User 2 for Admin");
                System.out.println("1.) User");
                System.out.println("2.) Admin");
                h=0;
                h=in.nextInt();
                if( h==1 || h==2){
                    break;
                }
            }
        }
        if(h==1){
            role+="User";
        }
        else if(h==2){
            role+="Admin";
        }
        System.out.println();
        int k=userController.validateRegistration(username, email, number, password, confirmpassword, gender, role);
        if(k==404){
            System.out.println("All the fields are required...Try Again");
            System.out.println();
            Register();
        }
        else if(k==401){
            System.out.println("Invalid Email...Try Again");
            System.out.println();
            Register();
        }
        else if(k==402){
            System.out.println("Password and Confirm Password does not match...Try Again");
            System.out.println();
            Register();
        }
        else if(k==403){
            System.out.println("Invalid Phone Number...Try Again");
            System.out.println();
            Register();
        }
        else if(k==101){
            System.out.println("Phone number already registered...Try Again");
            System.out.println();
            Register();
        }
        else if(k==102){
            System.out.println("Email already registered...Try Again");
            System.out.println();
            Register();
        }
        else if(k==99){
            System.out.println("Failed Registering...Try Again");
            System.out.println();
            Register();
        }
        else if(k==-1){
            System.out.println("Registered Successfully...");
            System.out.println("Hello ADMIN");
        }
        else{
            System.out.println("Registered Successfully...");
            System.out.println("Your User ID is "+k);
            ShoeDAO shoedao=new ShoeDaoImpl();
            CartDAO cartdao=new CartDaoImpl();
            UserOperationscontroller userOperationscontroller=new UserOperationscontroller(shoedao,cartdao);
            UserOperationsView  userOperationsView=new UserOperationsView(userOperationscontroller);
            userOperationsView.UserViewPage(k);
        }
        in.close();
    }

    public void Login(){
        Scanner in=new Scanner(System.in);
        System.out.print("Enter Your Email: ");
        String email=in.nextLine();
        System.out.println();
        System.out.print("Enter Password: ");
        String password=in.nextLine();
        int k=userController.validateLogin(email, password);
        if(k==404){
            System.out.println("Email is not registered...Try Again");
            System.out.println();
            Login();
        }
        else if(k==99){
            System.out.println("Wrong Password...Try Again");
            System.out.println();
            Login();
        }
        else if(k==-1){
            System.out.println("Login Successful");
            System.out.println("Hello ADMIN");
            ShoeDAO shoedao=new ShoeDaoImpl();
            AdminOperationsController adminOperationsController=new AdminOperationsController(shoedao);
            AdminOperationsView ad=new AdminOperationsView(adminOperationsController);
            ad.AdminOperations();
        }
        else{
            System.out.println("Login Successful");
            System.out.println("Your User ID is "+k);
            ShoeDAO shoedao=new ShoeDaoImpl();
            CartDAO cartDAO=new CartDaoImpl();
            UserOperationscontroller userOperationscontroller=new UserOperationscontroller(shoedao,cartDAO);
            UserOperationsView  userOperationsView=new UserOperationsView(userOperationscontroller);
            userOperationsView.UserViewPage(k);
        }
        in.close();
    }
}
