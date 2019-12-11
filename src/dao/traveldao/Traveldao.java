package dao.traveldao;

import entity.travel.Travel;
import mysqlconnect.JDBCconnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Traveldao {
    private Travel travel;
    private Connection conn;
    public Traveldao(Travel travel){
        this.travel =travel;
        conn = JDBCconnect.getConnect();
    }
    public boolean addhotel(){
        String sql="insert into travelpath(sceneryname,about,place,city) values (?,?,?,?)";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1,travel.getSceneryname());
            pre.setString(2,travel.getAbout());
            pre.setString(3,travel.getPlace());
            pre.setString(4,travel.getCity());
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
        String sql="update hotel set sceneryname=?,about=?,place=?,city=? where id=?";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1,travel.getSceneryname());
            pre.setString(2,travel.getAbout());
            pre.setString(3,travel.getPlace());
            pre.setString(4,travel.getCity());
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
