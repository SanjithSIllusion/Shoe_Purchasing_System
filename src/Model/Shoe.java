package Model;

public class Shoe {
    private int sid;
    private String sname;
    private String sbrand;
    private String sprice;
    private String gender;
    private int ssize;
    private int scount;
    public Shoe(int sid,String sname,String sbrand,String sprice,String gender,int ssize,int scount){
        this.sid=sid;
        this.gender=gender;
        this.sbrand=sbrand;
        this.sname=sname;
        this.sprice=sprice;
        this.ssize=ssize;
        this.scount=scount;
    }
    public void setSid(int sid){
        this.sid=sid;
    }
    public int getSid(){
        return sid;
    }
    public void setSname(String sname){
        this.sname=sname;
    }
    public String getSname(){
        return sname;
    }
    public void setSbrand(String sbrand) {
        this.sbrand = sbrand;
    }

    public String getSbrand() {
        return sbrand;
    }

    public void setSprice(String sprice) {
        this.sprice = sprice;
    }

    public String getSprice() {
        return sprice;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getGender() {
        return gender;
    }

    public void setSsize(int ssize) {
        this.ssize = ssize;
    }

    public int getSsize() {
        return ssize;
    }

    public void setScount(int scount) {
        this.scount = scount;
    }

    public int getScount() {
        return scount;
    }
    @Override
    public String  toString(){
        return "ID: "+sid+" | Name: "+sname+" | Brand: "+sbrand+" | Size: "+ssize+" | Wearable By: "+gender+" | Price: "+sprice;
    }
}
