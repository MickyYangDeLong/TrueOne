package Dao.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDbManager {

    //后续可以写到配置文件中
    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        String url = "jdbc:postgresql://localhost:5432/postgres";//换成自己PostgreSQL数据库实例所在的ip地址，并设置自己的端口
        String user = "postgres";
        String password = "ABC1616abc";  //在这里我的密码为空，读者可以自己选择是否设置密码
        Class.forName("org.postgresql.Driver");  //一定要注意和上面的MySQL语法不同
        return DriverManager.getConnection(url, user, password);
    }
}
