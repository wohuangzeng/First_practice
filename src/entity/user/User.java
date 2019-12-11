package entity.user;

public class User {
    private String username;
    private String password;
    private String email;
    private String sex;
    private String phone;
    public String getEmail() {
        return email;
    }
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getPhone() {
        return phone;
    }

    public String getSex() {
        return sex;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    public User(){}
    public User(String username,String password,String sex,String email,String phone){
        this.username=username;
        this.password=password;
        this.sex =sex;
        this.email=email;
        this.phone = phone;
    }

    @Override
    public String toString() {
        return username+password+email+sex+phone;
    }
}
