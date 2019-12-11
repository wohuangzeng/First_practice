package dao.admindao;

import entity.admin.Admin;
import mysqlconnect.JDBCconnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Admindao {
    private Admin admin;
    private Connection conn;
    public Admindao(Admin admin){
        this.admin=admin;
        conn= JDBCconnect.getConnect();
    }
    public boolean login(){
        String sql = "select * from admin where name like ? and password like ?";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1,admin.getUsername());
            pre.setString(2,admin.getPassword());
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
}
