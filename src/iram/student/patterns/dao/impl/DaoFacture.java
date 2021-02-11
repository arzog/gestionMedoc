package iram.student.patterns.dao.impl;

import iram.student.patterns.dao.Dao;
import iram.student.model.Facture;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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

    @Override
    public int lastID() {
        int lastId;
        try{
            PreparedStatement statement = conn.prepareStatement(
                    "select max(id) as maxi from facture;");
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
