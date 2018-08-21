package Dao;

import java.sql.*;

public class SelectTest {
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        try {

            connection = getConnection();
            System.out.println("是否成功连接pg数据库" + connection);
            String sql = "select * from student";
            statement = connection.createStatement();
            /**
             * 关于ResultSet的理解：Java程序中数据库查询结果的展现形式，或者说得到了一个结果集的表
             * 在文档的开始部分有详细的讲解该接口中应该注意的问题，请阅读JDK
             * */
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                //取出列值
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                System.out.println(id + "," + name + ",");

            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            } finally {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                    throw new RuntimeException(e);
                }
            }

        }
    }

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        //String url = "jdbc:mysql://192.168.101.44/amon";
        String url = "jdbc:postgresql://localhost:5432/postgres";//换成自己PostgreSQL数据库实例所在的ip地址，并设置自己的端口
        //String user = "root";
        String user = "postgres";
        //String password = "560128";
        String password = "ABC1616abc";  //在这里我的密码为空，读者可以自己选择是否设置密码
        //Class.forName("com.mysql.jdbc.Driver");
        Class.forName("org.postgresql.Driver");  //一定要注意和上面的MySQL语法不同
       return DriverManager.getConnection(url, user, password);
    }
}
