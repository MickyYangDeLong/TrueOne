package base;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;

public class DBTest {
    static Logger log = LoggerFactory.getLogger(DBTest.class);
    public static void main(String[] args) {
        Connection connection=null;
        Statement statement =null;
        try{
            String url="jdbc:postgresql://127.0.0.1:5432/postgres";
            String user="postgres";
            String password = "ABC1616abc";
            Class.forName("org.postgresql.Driver");
            connection= DriverManager.getConnection(url, user, password);
            System.out.println("是否成功连接pg数据库"+connection);
            String sql="select * from student";
            statement=connection.createStatement();
            ResultSet resultSet=statement.executeQuery(sql);
            while(resultSet.next()){
                String name=resultSet.getString(2);
                System.out.println(name);
                log.debug("the name is {}",name);
            }
        }catch(Exception e){
            log.error("exception happened {},{}", e, e.getMessage());
            throw new RuntimeException(e);
        }finally{
            try{
                statement.close();
            }
            catch(SQLException e){
                log.error("statement.close SQLException happened {},{}", e, e.getMessage());
                e.printStackTrace();
                throw new RuntimeException(e);
            }finally{
                try{
                    connection.close();
                }
                catch(SQLException e){
                    log.error("connection close SQLException happened {},{}", e, e.getMessage());
                    e.printStackTrace();
                    throw new RuntimeException(e);
                }
            }
        }
    }

}
