package db;

import java.util.List;

public class UserDao<K> implements  BaseDao<K>{
    @Override
    public <T> List<T> query(K k) {
        return null;
    }

    @Override
    public <T> List<T> pageQuery(K k) {
        return null;
    }

    @Override
    public boolean insert(K k) {
        return false;
    }

    @Override
    public boolean insertAll(List<K> k) {
        return false;
    }

    @Override
    public boolean delete(K k) {
        return false;
    }

    @Override
    public boolean deleteAll(List<K> k) {
        return false;
    }

    @Override
    public boolean update(K k) {
        return false;
    }

    @Override
    public boolean updateAll(List<K> k) {
        return false;
    }
}
