package dao.userdao;

import entity.user.User;
import mysqlconnect.JDBCconnect;

import javax.sql.rowset.JdbcRowSet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Userdao {
    private User uSer;
    private Connection conn;
    public Userdao(User user){
        this.uSer =user;
        this.conn=JDBCconnect.getConnect();
    }
    public boolean login(){
        String sql = "select * from user where name like ? and password like ?";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1,uSer.getUsername());
            pre.setString(2,uSer.getPassword());
            ResultSet resultSet = pre.executeQuery();
            if(resultSet.next()){
                resultSet.close();
                pre.close();
                conn.close();
                return true;
            }
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public boolean register(){
        String sql="insert into user(name,password,email,sex,phone) values(?,?,?,?,?)";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1,uSer.getUsername());
            pre.setString(2,uSer.getPassword());
            pre.setString(3,uSer.getEmail());
            pre.setString(4,uSer.getSex());
            pre.setString(5,uSer.getPhone());
            pre.executeUpdate();
            pre.close();
            conn.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    public boolean updatehotel(int id){
        String sql="update user set name=?,password=?,email=?,sex=?,phone=? where id=?";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, uSer.getUsername());
            pre.setString(2, uSer.getPassword());
            pre.setString(3,uSer.getEmail());
            pre.setString(4,uSer.getSex());
            pre.setString(5,uSer.getPhone());
            pre.setInt(6,id);
            pre.executeUpdate();
            pre.close();
            conn.close();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
