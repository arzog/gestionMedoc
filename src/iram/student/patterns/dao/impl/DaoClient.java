package iram.student.patterns.dao.impl;

import iram.student.patterns.dao.Dao;
import iram.student.model.Client;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DaoClient extends Dao<Client> {
    public DaoClient(Connection conn) {
        super(conn);
    }

    @Override
    public boolean insert(Client client) {
        int actif;
        if(client.isActif()){
            actif = 1;
        }else {
            actif = 0;
        }
        try{
            PreparedStatement statement = conn.prepareStatement(
                    "insert into client(nom,prenom,pays,ville,rue,num,cp,actif) " +
                            "values (?,?,?,?,?,?,?,?);"
            );
            statement.setString(1,client.getNom());
            statement.setString(2,client.getPrenom());
            statement.setString(3,client.getPays());
            statement.setString(4,client.getVille());
            statement.setString(5,client.getRue());
            statement.setString(6,client.getNum());
            statement.setInt(7,client.getCp());
            statement.setInt(8,actif);

            statement.executeUpdate();
            statement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return true;
    }
    @Override
    public boolean update(Client client) {
        int actif;
        if(client.isActif()){
            actif = 1;
        }else {
            actif = 0;
        }
        try{
            PreparedStatement statement = conn.prepareStatement(
                    "update client " +
                            "set nom = ?, prenom = ?, pays = ?,ville = ?, rue = ?, num = ?, cp = ?, actif = ? " +
                            "where id = ?;"
            );
            statement.setString(1,client.getNom());
            statement.setString(2,client.getPrenom());
            statement.setString(3,client.getPays());
            statement.setString(4,client.getVille());
            statement.setString(5,client.getRue());
            statement.setString(6,client.getNum());
            statement.setInt(7,client.getCp());
            statement.setInt(8,actif);
            statement.setInt(9,client.getId());

            statement.executeUpdate();
            statement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return true;
    }
    @Override
    public boolean delete(Client client) {
        return false;
    }
    @Override
    public Client select(int id) {
        boolean actif;
        Client c = null;
        try{
            PreparedStatement statement = conn.prepareStatement("select * from client where client.id = ?");
            statement.setInt(1,id);
            ResultSet set = statement.executeQuery();
            while(set.next()){
                actif = set.getInt("actif") != 0;
                c = new Client(
                        set.getInt("id"),
                        set.getString("nom"),
                        set.getString("prenom"),
                        set.getString("pays"),
                        set.getString("ville"),
                        set.getString("rue"),
                        set.getString("num"),
                        set.getInt("cp"),
                        actif);
            }
            set.close();
            statement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return c;
    }
    @Override
    public List<Client> selectAll() {
        List<Client> clients = new ArrayList<>();
        boolean actif;
        try{
            PreparedStatement statement = conn.prepareStatement("select * from client");
            ResultSet set = statement.executeQuery();
            while(set.next()){
                actif = set.getInt("actif") != 0;
                clients.add(new Client(
                        set.getInt("id"),
                        set.getString("nom"),
                        set.getString("prenom"),
                        set.getString("pays"),
                        set.getString("ville"),
                        set.getString("rue"),
                        set.getString("num"),
                        set.getInt("cp"),
                        actif
                ));
            }
            set.close();
            statement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return clients;
    }
}
