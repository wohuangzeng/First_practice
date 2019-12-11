package dao.busdao;

import entity.bus.Bus;
import mysqlconnect.JDBCconnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Busdao {
    private Connection conn;
    private Bus bus;
    public Busdao(Bus bus){
        this.bus=bus;
        conn= JDBCconnect.getConnect();
    }
    public boolean addbus(){
        String sql="insert into bus(busname,route,money,city) values (?,?,?,?)";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1,bus.getBusname());
            pre.setString(2,bus.getRoute());
            pre.setString(3,bus.getMoney());
            pre.setString(4,bus.getCity());
            pre.executeUpdate();
            pre.close();
            conn.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    public boolean updatebus(int id){
        String sql="update bus set busname=?,route=?,money=?,city=? where id=?";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1,bus.getBusname());
            pre.setString(2,bus.getRoute());
            pre.setString(3,bus.getMoney());
            pre.setString(4,bus.getCity());
            pre.setInt(5,id);
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
