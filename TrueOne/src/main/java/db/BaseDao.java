package db;

import java.util.List;

public interface BaseDao<K> {

    //根据条件查询
    <T> List<T> query(K k);

    //分页查询
    <T> List<T> pageQuery(K k);

    //插入
    boolean insert(K k);

    //批量插入
    boolean insertAll(List<K> k);

    //删除
    boolean delete(K k);

    //批量删除
    boolean deleteAll(List<K> k);

    //修改
    boolean update(K k);

    //批量修改
    boolean updateAll(List<K> k);

}
