package dao.questiondao;

import com.mysql.cj.jdbc.JdbcConnection;
import entity.question.Question;
import mysqlconnect.JDBCconnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Questiondao {
    private Connection conn;
    private Question question;
    public  Questiondao(Question question){
        this.question  = question;
        conn= JDBCconnect.getConnect();
    }
    public boolean addquestion(){
        String sql="insert into question(question,answer) values (?,?)";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1,question.getQuestion());
            pre.setString(2,question.getAnswer());
            pre.executeUpdate();
            pre.close();
            conn.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    public boolean updatequestion(int id){
        String sql="update question set question=?,answer=? where id=?";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1,question.getQuestion());
            pre.setString(2,question.getAnswer());
            pre.setInt(3,id);
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
