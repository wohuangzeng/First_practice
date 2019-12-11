package dao.hoteldao;

import entity.hotel.Hotel;
import mysqlconnect.JDBCconnect;

import java.sql.*;

public class Hoteldao {
    private Hotel hotel=null;
    private Connection conn;
    public Hoteldao(Hotel hotel){
        this.hotel=hotel;
        conn=JDBCconnect.getConnect();
    }
    public Hoteldao(){
        conn=JDBCconnect.getConnect();
    }
    public boolean addhotel(){
        String sql="insert into hotel(hotelname,star,hotelmessage,place,city) values (?,?,?,?,?)";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1,hotel.getHotelname());
            pre.setString(2,hotel.getStar());
            pre.setString(3,hotel.getHotelmessage());
            pre.setString(4,hotel.getPlace());
            pre.setString(5,hotel.getCity());
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
        String sql="update hotel set hotelname=?,star=?,hotelmessage=?,place=?,city=? where id=?";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1,hotel.getHotelname());
            pre.setString(2,hotel.getStar());
            pre.setString(3,hotel.getHotelmessage());
            pre.setString(4,hotel.getPlace());
            pre.setString(5,hotel.getCity());
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
