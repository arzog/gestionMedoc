package iram.student.patterns.dao.impl;

import iram.student.patterns.dao.Dao;
import iram.student.model.Client;

import java.sql.Connection;
import java.util.List;

public class DaoClient extends Dao<Client> {
    public DaoClient(Connection conn) {
        super(conn);
    }

    @Override
    public boolean insert(Client client) {
        return false;
    }
    @Override
    public boolean update(Client client) {
        return false;
    }
    @Override
    public boolean delete(Client client) {
        return false;
    }
    @Override
    public Client select(int id) {
        return null;
    }
    @Override
    public List<Client> selectAll() {
        return null;
    }
}
