package View;
import java.util.Scanner;
import Controller.UserController;
import Dao.UserDAO;
import Dao.UserDaoImpl;
public class App {
    public static void main(String[] args) {
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("                                                                          Welcome to DR4NZY Kicks..."                                                          );
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------");
        // System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------");
        Display d=new Display();
        d.display();
    }
}

class Display{
    public void display(){
        Scanner in=new Scanner(System.in);
        try {
        UserDAO userDAO=new UserDaoImpl();
        UserController userController=new UserController(userDAO);
        UserView userView=new UserView(userController);
        int n=2;
            do {
                System.out.println("Press 1 for SignUp or 0 for Login or 3 to Exit");
                n = in.nextInt();
                if (n == 1) {
                    userView.Register();
                } else if (n == 0) {
                    userView.Login();
                }
                else if(n==3){
                    System.out.println("Exiting...");
                    return;
                } 
                else {
                    System.out.println("Invalid Choice\nTry Again");
                }
            } while (n != 0 && n != 1 && n!=3);
        } catch (Exception e) {
            // TODO: handle exception
        }
        in.close();
    }
}