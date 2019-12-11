package entity.admin;

public class Admin {
    private String username;
    private String password;
    public Admin(){}
    public Admin(String username,String password){
        this.username=username;
        this.password=password;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return username+":\t"+"\n"+password+"\t";
    }
}
