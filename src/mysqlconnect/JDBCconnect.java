package mysqlconnect;

import org.apache.commons.dbcp2.BasicDataSource;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


public class JDBCconnect {
    private  static DataSource dataSource;
    static {
        String driver = null;
        String url = null;
        String user = null;
        String psd = null;

        Properties pro = new Properties();    //新建一个properties实例，用于从DBConfig中拿到连接参数。
        try {
            pro.load(JDBCconnect.class.getClassLoader().getResourceAsStream("DBConfig.properties")); //加载DBConfig文件。
            driver = pro.getProperty("driver");
            url = pro.getProperty("url");
            user = pro.getProperty("user");
            psd = pro.getProperty("psd");
        } catch (IOException e) {
            e.printStackTrace();
        }

        dataSource = setupDataSource(url,user,psd,driver);  //获取数据库连接



    }
    public static DataSource setupDataSource(String url,String user,String psd,String driver){
        BasicDataSource ds = new BasicDataSource();
        ds.setUsername(user);
        ds.setPassword(psd);
        ds.setDriverClassName(driver);
        ds.setUrl(url);
        ds.setInitialSize(5);
        //设置最大连接数为20
        ds.setMaxTotal(20);
        //设置最大空闲数为 10
        ds.setMaxIdle(10);
        return ds;

    }
    public static Connection getConnect(){
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
