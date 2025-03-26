package Controller;

import java.sql.Connection;
import Dao.ShoeDAO;
import Model.Shoe;

public class BillController {
    Connection con;
    ShoeDAO shoeDAO;
    public BillController(ShoeDAO shoeDAO){
        this.shoeDAO=shoeDAO;
    }
    public Shoe generateBill(int user_id,int sid){
        Shoe shoedetails=shoeDAO.generateBill(user_id, sid);
        return shoedetails;
    }
}
