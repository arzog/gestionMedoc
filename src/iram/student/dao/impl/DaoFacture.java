package iram.student.dao.impl;

import iram.student.dao.Dao;
import iram.student.model.Facture;

import java.sql.Connection;
import java.util.List;

public class DaoFacture extends Dao<Facture> {
    public DaoFacture(Connection conn) {
        super(conn);
    }

    @Override
    public boolean insert(Facture facture) {
        return false;
    }

    @Override
    public boolean update(Facture facture) {
        return false;
    }

    @Override
    public boolean delete(Facture facture) {
        return false;
    }

    @Override
    public Facture select(int id) {
        return null;
    }

    @Override
    public List<Facture> selectAll() {
        return null;
    }
}
