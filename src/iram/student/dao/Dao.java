package iram.student.dao;

import java.sql.Connection;
import java.util.List;

public abstract class Dao<T> {
    protected Connection conn;

    public Dao(Connection conn) {
        this.conn = conn;
    }

    public abstract boolean insert(T t);
    public abstract boolean update(T t);
    public abstract boolean delete(T t);
    public abstract T select(int id);
    public abstract List<T> selectAll();
}
