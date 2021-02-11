package iram.student.patterns.dao.impl;

import iram.student.patterns.dao.Dao;
import iram.student.model.Medicament;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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

    @Override
    public int lastID() {
        int lastId;
        try{
            PreparedStatement statement = conn.prepareStatement(
                    "select max(id) as maxi from medicament;");
            ResultSet set = statement.executeQuery();
            while (set.next()){
                lastId = set.getInt("maxi");
                return lastId;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return 0;
    }
}
