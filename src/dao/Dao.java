package dao;

import mysqlconnect.JDBCconnect;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Dao {
    private Connection conn;
    public Dao(){
        conn=JDBCconnect.getConnect();
    }
    public ResultSet select(String sql){
        try {
            Statement stat=conn.createStatement();
            return stat.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public boolean other(String sql){
        try {
            Statement stat = conn.createStatement();
            stat.execute(sql);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
