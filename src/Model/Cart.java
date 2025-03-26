package Model;

public class Cart {
    private int cid;
    private int sid;
    private int user_id;
    public Cart(int sid,int user_id,int cid){
        this.cid=cid;
        this.sid=sid;
        this.user_id=user_id;
    }
    public void setSid(int sid){
        this.sid=sid;
    }
    public int getSid(){
        return sid;
    }
    public void setCid(int cid){
        this.cid=cid;
    }
    public int getCid(){
        return cid;
    }
    public void  setUserId(int user_id){
        this.user_id=user_id;
    }
    public int getUserId(){
        return user_id;
    }
}
