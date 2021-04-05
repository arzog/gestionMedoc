package iram.student.patterns.dao.impl;

import iram.student.enums.RoleUser;
import iram.student.model.Concentration;
import iram.student.model.User;
import iram.student.patterns.dao.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DaoConcentration extends Dao<Concentration> {
    public DaoConcentration(Connection conn) {
        super(conn);
    }

    @Override
    public boolean insert(Concentration concentration) {
        try{
            PreparedStatement statement = conn.prepareStatement(
                    "insert into concentration(concentration,unite,perime) " +
                            "values (?,?,?);"
            );
            statement.setInt(1,concentration.getConcentration());
            statement.setString(2,concentration.getUnite());
            statement.setBoolean(3,concentration.isPerime());
            statement.executeUpdate();
            statement.close();

            System.out.println("INSERT : insert went well");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return true;
    }

    @Override
    public boolean update(Concentration concentration) {
        try{
            PreparedStatement statement = conn.prepareStatement(
                    "update concentration " +
                            "set concentration = ?, unite = ? " +
                            "where id = ?;"
            );
            statement.setInt(1,concentration.getConcentration());
            statement.setString(2,concentration.getUnite());
            statement.setBoolean(3,concentration.isPerime());
            statement.setInt(4,concentration.getId());

            statement.executeUpdate();
            statement.close();

            System.out.println("UPDATE : udpate went well");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return true;
    }

    @Override
    public boolean delete(Concentration concentration) {
        try{
            PreparedStatement statement = conn.prepareStatement(
                    "update concentration " +
                            "set perime = false " +
                            "where id = ?;"
            );
            statement.setInt(1,concentration.getId());

            statement.executeUpdate();
            statement.close();

            System.out.println("UPDATE : udpate went well");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return true;
    }

    @Override
    public Concentration select(int id) {
        Concentration c = null;
        try {
            PreparedStatement statement = conn.prepareStatement(
                    "select * from concentration " +
                            "where id = ?;");
            statement.setInt(1,id);
            ResultSet set = statement.executeQuery();
            RoleUser role;
            while (set.next()){

                c = new Concentration(
                        set.getInt("id"),
                        set.getInt("concentration"),
                        set.getString("unite"),
                        set.getBoolean("perime")
                );
            }
            set.close();
            statement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return c;
    }

    @Override
    public List<Concentration> selectAll() {
        List<Concentration> concentrations = new ArrayList<>();
        try{
            PreparedStatement statement = conn.prepareStatement("select * from concentration;");
            ResultSet set = statement.executeQuery();
            while(set.next()){

                concentrations.add(
                        new Concentration(
                            set.getInt("id"),
                            set.getInt("concentration"),
                            set.getString("unite"),
                            set.getBoolean("perime")
                        )
                );
            }
            set.close();
            statement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return concentrations;
    }

    @Override
    public int lastID() {
        int lastId;
        try{
            PreparedStatement statement = conn.prepareStatement(
                    "select max(id) as maxi from concentration;");
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
