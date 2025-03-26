package Dao;
import java.util.*;

import Model.EstablishConnection;
import Model.Shoe;
import java.sql.*;
public class ShoeDaoImpl implements ShoeDAO{
    private Connection con;
    public ShoeDaoImpl(){
        con=EstablishConnection.getDbConnection();
    }
    public boolean insertShoe(String sname,String sbrand,int ssize,int scount,String sprice,String gender){
        String check="Select * from shoes where sname=?";
        PreparedStatement pst;
        try {
            pst=con.prepareStatement(check);
            pst.setString(1, sname);
            ResultSet rs=pst.executeQuery();
            if(rs.next()){
                return false;
            }
            else{
                String insertQuery="Insert into shoes(sname, sbrand, ssize, scount, sprice, gender) values(?,?,?,?,?,?)";
                pst=con.prepareStatement(insertQuery);
                pst.setString(1, sname);
                pst.setString(2, sbrand);
                pst.setInt(3, ssize);
                pst.setInt(4, scount);
                pst.setString(5, sprice);
                pst.setString(6, gender);
                int checkInsert=pst.executeUpdate();
                if(checkInsert==1){
                    return true;
                }
                else{
                    return false;
                }
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
        return false;
    }
    public boolean deleteShoeByBrand(String brand){
        String query="Delete from shoes where sbrand=?";
        PreparedStatement pst;
        try {
        pst=con.prepareStatement(query);
        pst.setString(1, brand);
        int x=pst.executeUpdate();
        if(x==1){
            return true;
        }
        else{
            return false;
        }
        } catch (Exception e) {
            // TODO: handle exception
        }
        return false;
    }

    public boolean deleteShoeById(int id){
            String shoeDel="Delete from shoes where sid=?";
            PreparedStatement pst;
            try {
            pst=con.prepareStatement(shoeDel);
            pst.setInt(1, id);
            int x=pst.executeUpdate();
            if(x==1){
                return true;
            }
            else{
                return false;
            }
            } catch (Exception e) {
                // TODO: handle exception
            }
        return false;
    }

    public boolean deleteShoeBySize(int size){
        String query="Delete from shoes where ssize=?";
        PreparedStatement pst;
        try {
            pst=con.prepareStatement(query);
            pst.setInt(1, size);
            int x=pst.executeUpdate();
            if(x==1){
                return true;
            }
            else{
                return false;
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
        return false;
    }

    public boolean updateShoe(int id,String field,String val){
        if(field.equals("ssize") || field.equals("scount")){
        String query="Update shoes set "+field+"=? where sid=?";
        PreparedStatement pst;
        int val1=Integer.parseInt(val);
        try {
            pst=con.prepareStatement(query);
            pst.setInt(1, val1);
            pst.setInt(2, id);
            int x=pst.executeUpdate();
            if(x==1){
                return true;
            }
            else{
                return false;
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
        }
        else{
            String query="Update shoes set "+field+"=? where sid=?";
            PreparedStatement pst;
            try {
                pst=con.prepareStatement(query);
                pst.setString(1, val);
                pst.setInt(2, id);
                int x=pst.executeUpdate();
                if(x==1){
                    return true;
                }
                else{
                    return false;
                }
            } catch (Exception e) {
                // TODO: handle exception
            }
        }
        return false;
    }

    public ArrayList<Shoe> viewById(int id){
        String query="Select * from shoes where sid=?";
        PreparedStatement pst;
        ArrayList<Shoe> al=new ArrayList<>();
        try {
        pst=con.prepareStatement(query);
        pst.setInt(1, id);
        ResultSet rs=pst.executeQuery();
        if(rs.next()){
            int sid=rs.getInt(1);
            String sname=rs.getString(2);
            String sbrand=rs.getString(3);
            int ssize=rs.getInt(4);
            int scount=rs.getInt(5);
            String sprice=rs.getString(6);
            String gender=rs.getString(7);
            if(scount>0){
            Shoe shoe=new Shoe(sid, sname, sbrand, sprice, gender, ssize, scount);
            al.add(shoe);
            }
        }
        return al;
        } catch (Exception e) {
            // TODO: handle exception
        }
        return al;
    }

    public ArrayList<Shoe> viewBySize(int size){
        ArrayList<Shoe> al=new ArrayList<>();
        String query="Select * from shoes where ssize=?";
        PreparedStatement pst;
        try {
            pst=con.prepareStatement(query);
            // System.out.println(pst);
            pst.setInt(1, size);
            // System.out.println(pst);
            ResultSet rs=pst.executeQuery();
            while(rs.next()){
                int sid=rs.getInt(1);
                String sname=rs.getString(2);
                String sbrand=rs.getString(3);
                int ssize=rs.getInt(4);
                int scount=rs.getInt(5);
                String sprice=rs.getString(6);
                String gender=rs.getString(7);
                if(scount>0){
                Shoe shoe=new Shoe(sid, sname, sbrand, sprice, gender, ssize, scount);
                al.add(shoe);
                }
            }
            return al;
        } catch (Exception e) {

        }
        return al;
    }

    public ArrayList<Shoe> viewByBrand(String brand){
        ArrayList<Shoe> al=new ArrayList<>();
        String query="Select * from shoes where sbrand=?";
        PreparedStatement pst;
        try {
        pst=con.prepareStatement(query);
        pst.setString(1, brand);
        ResultSet rs=pst.executeQuery();
        while(rs.next()){
            int sid=rs.getInt(1);
            String sname=rs.getString(2);
            String sbrand=rs.getString(3);
            int ssize=rs.getInt(4);
            int scount=rs.getInt(5);
            String sprice=rs.getString(6);
            String gender=rs.getString(7);
            if(scount>0){
            Shoe shoe=new Shoe(sid, sname, sbrand, sprice, gender, ssize, scount);
            al.add(shoe);
            }
        }
        return al;
        } catch (Exception e) {
            // TODO: handle exception
        }
        return al;
    }
    public Shoe generateBill(int user_id,int id){
        String query="Select * from shoes where sid=?";
        PreparedStatement pst;
        try {
            pst=con.prepareStatement(query);
            pst.setInt(1, id);
            ResultSet rs=pst.executeQuery();
            if(rs.next()){
                int sid=rs.getInt(1);
                String sname=rs.getString(2);
                String sbrand=rs.getString(3);
                int ssize=rs.getInt(4);
                int scount=rs.getInt(5);
                String sprice=rs.getString(6);
                String gender=rs.getString(7);
                if(scount>0){
                Shoe shoe=new Shoe(sid, sname, sbrand, sprice, gender, ssize, scount);
                return shoe;
                }
        }
     } catch (Exception e) {
            // TODO: handle exception
        }
        return new Shoe(0, null, null, null, null, 0, 0);
    }
    public ArrayList<Shoe> returnOrders(int user_id) {
        ArrayList<Shoe> al = new ArrayList<>();
        String query = "SELECT sid FROM orders WHERE user_id=?";
        PreparedStatement pst;
        try {
            pst = con.prepareStatement(query);
            pst.setInt(1, user_id);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                int sid = rs.getInt(1);
                String s = "SELECT * FROM shoes WHERE sid=?";
                pst = con.prepareStatement(s);
                pst.setInt(1, sid);
                ResultSet res = pst.executeQuery();
                while (res.next()) {
                    int id = res.getInt(1);
                    String sname = res.getString(2);
                    String sbrand = res.getString(3);
                    int ssize = res.getInt(4);
                    int scount = res.getInt(5);
                    String sprice = res.getString(6);
                    String gender = res.getString(7);
                    if (scount > 0) {
                        Shoe shoe = new Shoe(id, sname, sbrand, sprice, gender, ssize, scount);
                        al.add(shoe);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace(); // Handle exception appropriately, printing stack trace for now
        }
        return al;
    }
    
}