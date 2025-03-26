package Controller;

import java.util.ArrayList;

import Dao.ShoeDAO;
import Model.Shoe;

public class AdminOperationsController {
    ShoeDAO shoeDAO;
    public AdminOperationsController(ShoeDAO shoeDAO){
        this.shoeDAO=shoeDAO;
    }
    public ArrayList<Shoe> viewById(int id){
        ArrayList<Shoe> al=shoeDAO.viewById(id);
        return al;
    }
    public ArrayList<Shoe> viewByBrand(String brand){
        ArrayList<Shoe> al=shoeDAO.viewByBrand(brand);
        return al;
    }

    public ArrayList<Shoe> viewBySize(int size){
        ArrayList<Shoe> al=shoeDAO.viewBySize(size);
        return al;
    }

    public boolean insertShoe(String sname,String sbrand,int ssize,int scount,String sprice,String gender){
        boolean t=shoeDAO.insertShoe(sname, sbrand, ssize, scount, sprice, gender);
        return t;
    }

    public boolean updateShoe(int id,String field,String val){
        boolean t=shoeDAO.updateShoe(id,field,val);
        return t;
    }


    public boolean deleteShoeById(int id){
        boolean t=shoeDAO.deleteShoeById(id);
        return t;
    }

    public boolean deleteShoeByBrand(String brand){
        boolean t=shoeDAO.deleteShoeByBrand(brand);
        return t;
    }

    public boolean deleteShoeBySize(int size){
        boolean t=shoeDAO.deleteShoeBySize(size);
        return t;
    }
}
