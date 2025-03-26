package Dao;
import java.util.*;
import Model.Shoe;
public interface ShoeDAO {
    boolean insertShoe(String sname,String sbrand,int ssize,int scount,String sprice,String gender);
    boolean deleteShoeById(int id);
    boolean deleteShoeByBrand(String brand);
    boolean deleteShoeBySize(int size);
    boolean updateShoe(int id,String field,String val);
    Shoe generateBill(int user_id,int sid);
    ArrayList<Shoe> returnOrders(int user_id);
    ArrayList<Shoe> viewById(int id);
    ArrayList<Shoe> viewByBrand(String brand);
    ArrayList<Shoe> viewBySize(int size);
}