package iram.student.dao.impl;

import iram.student.dao.Dao;
import iram.student.model.User;

import java.sql.Connection;
import java.util.List;

public class DaoUser extends Dao<User> {
    public DaoUser(Connection conn) {
        super(conn);
    }

    @Override
    public boolean insert(User user) {
        return false;
    }
    @Override
    public boolean update(User user) {
        return false;
    }
    @Override
    public boolean delete(User user) {
        return false;
    }
    @Override
    public User select(int id) {
        return null;
    }
    @Override
    public List<User> selectAll() {
        return null;
    }
}
