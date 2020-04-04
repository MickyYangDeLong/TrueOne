package Dao.db;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class DbManager {

    public static <T> List<T> query(String sql, Class<T> object) {//反射复制
        Connection connection = null;
        Statement statement = null;
        List<T> resultList = new ArrayList<>();
        try {
            connection = ConnectionDbManager.getConnection();
            System.out.println("是否成功连接pg数据库" + Objects.isNull(connection));
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            if (Objects.isNull(resultSet)){
                return  resultList;
            }

            Method[] methods = object.getMethods();
            List<Method> methodList = new ArrayList<>();
            Arrays.stream(methods).filter(m->m.getName().contains("set")).forEach(methodList::add);
            Map<String,Field> fieldNameMap = new HashMap<>();
            List<String> fieldMethodNameList = new ArrayList<>();
            Field[] fieldList = object.getDeclaredFields();
            Arrays.stream(fieldList).forEach(f->{
                String name = f.getName();
                String firstChar = name.substring(0,1);
                String methodName = "set".concat(name.replaceFirst(firstChar,firstChar.toUpperCase()));
                fieldNameMap.put(methodName,f);
                fieldMethodNameList.add(methodName);
            });

            while (resultSet.next()) {//取出列值
                T obj = object.getDeclaredConstructor().newInstance();
                for(Method m : methodList){
                    final String name = m.getName();
                    if (fieldMethodNameList.contains(name)){
                        Object value = resultSet.getObject(name.replaceFirst("set","").toLowerCase());//数据库一律小写
                        Field field = fieldNameMap.get(name);
                        Class<?> type = field.getType();
                        if (type == Integer.class){
                            value = Integer.valueOf(value.toString());
                        }else if(type == String.class){
                            value = value.toString();
                        }else if (type == Float.class){
                            value = Float.valueOf(value.toString());
                        }else if(type == Long.class){
                            value = Long.valueOf(value.toString());
                        }else if (type == Double.class){
                            value = Double.valueOf(value.toString());
                        }
                        m.invoke(obj,value);//只适用于基本类型，不适用于嵌套引用类型
                    }
                }
                resultList.add(obj);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection(connection, statement);
        }
        return resultList;
    }

    //增删改
    public static boolean execute(String sql) {
        Connection connection = null;
        Statement statement = null;
        try {
            connection = ConnectionDbManager.getConnection();
            System.out.println("是否成功连接pg数据库" + Objects.isNull(connection));
            return connection.createStatement().execute(sql);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            closeConnection(connection, statement);
            return false;
        }
    }

    private static void closeConnection(Connection connection, Statement statement) {
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

    //add
    public static void execute() {

    }

    //del

    //update


    //select
}
