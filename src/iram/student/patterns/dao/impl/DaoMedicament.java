package iram.student.patterns.dao.impl;

import iram.student.model.Concentration;
import iram.student.patterns.dao.Dao;
import iram.student.model.Medicament;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class DaoMedicament  {
    private Connection conn;
    public DaoMedicament(Connection conn) {
        this.conn = conn;
    }

    public boolean insert(Medicament medicament, Concentration concentration) {
        DaoConcentration daoConcentration = new DaoConcentration(conn);
        try{
            PreparedStatement statement = conn.prepareStatement(
                    "insert into medicament(nom,prix,quantite_boite,urlDoc) " +
                        "values (?,?,?,?);" +
                        "insert into concentration(concentration,unite,perime) " +
                        "values (?,?,?);" +
                        "insert into medic_concent(id_medic,id_concent) " +
                        "values (?,?);"
            );
            //medicament
            statement.setString(1,medicament.getNom());
            statement.setDouble(2,medicament.getPrix());
            statement.setInt(3,medicament.getQuantite_boite());
            statement.setString(4,medicament.getUrlDoc());

            //concentration
            statement.setInt(5,concentration.getConcentration());
            statement.setString(6,concentration.getUnite());
            statement.setBoolean(7,concentration.isPerime());

            //join table
            statement.setInt(8,medicament.getId());

            statement.executeUpdate();
            statement.close();

            System.out.println("INSERT : insert went well");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return true;
    }
    public boolean update(Medicament medicament, Concentration concentration) {
        return false;
    }
    public boolean delete(Medicament medicament, Concentration concentration) {
        return false;
    }
    public Medicament select(int id) {
        return null;
    }
    public List<Medicament> selectAll() {
        return null;
    }


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
