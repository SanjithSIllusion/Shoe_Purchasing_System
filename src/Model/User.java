package Model;
public class User {
    private String username;
    private String email;
    private String password;
    private String confirmpassword;
    private String phone;
    private String gender;
    private String role;
    public User(String username, String email,String phone, String password,String confirmpassword,String gender,String role) {
        this.username = username;
        this.email = email;
        this.role=role;
        this.phone=phone;
        this.gender=gender;
        this.confirmpassword=confirmpassword;
        this.password = password;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setConfirmPassword(String confirmpassword){
        this.confirmpassword=confirmpassword;
    }
    public String getConfirmPassword(){
        return confirmpassword; 
    }
    public void setGender(String gender){
        this.gender=gender;
    }
    public String getGender(){
        return gender;
    }
    public void setRole(String role){
        this.role=role;
    }
    public String getRole(){
        return role;
    }
    public void setPhone(String phone){
        this.phone=phone;
    }
    public String getPhone(){
        return phone;
    }
}


