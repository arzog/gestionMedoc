package iram.student.dao.impl;

import iram.student.dao.Dao;
import iram.student.model.Medicament;

import java.sql.Connection;
import java.util.List;

public class DaoMedicament extends Dao<Medicament> {
    public DaoMedicament(Connection conn) {
        super(conn);
    }

    @Override
    public boolean insert(Medicament medicament) {
        return false;
    }
    @Override
    public boolean update(Medicament medicament) {
        return false;
    }
    @Override
    public boolean delete(Medicament medicament) {
        return false;
    }
    @Override
    public Medicament select(int id) {
        return null;
    }
    @Override
    public List<Medicament> selectAll() {
        return null;
    }
}
