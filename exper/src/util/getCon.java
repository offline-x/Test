package util;
import java.sql.Connection;
import java.sql.DriverManager;

public class getCon {
    public static Connection getConnection(){
        String DB_URL = "jdbc:postgresql://192.168.0.43:5432/postgres";
        String USER = "jack";
        String PASS = "jack@123";
        Connection conn = null;

        try {
//加载数据库驱动。
            Class.forName("org.postgresql.Driver").newInstance();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        try {
//创建数据库连接。
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
               System.out.println("Connection succeed!");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return conn;
    }

/*
    public static void main(String[] args) {
        getCon.GetConnection();
    }
 */
}