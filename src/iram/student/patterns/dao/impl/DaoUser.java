package iram.student.patterns.dao.impl;

import iram.student.patterns.dao.Dao;
import iram.student.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DaoUser extends Dao<User> {
    public DaoUser(Connection conn) {
        super(conn);
    }

    @Override
    public boolean insert(User user) {
        try{
            PreparedStatement statement = conn.prepareStatement(
                    "insert into utilisateur(username,password,mail,id_client) " +
                            "values (?,?,?,?);"
            );
            statement.setString(1,user.getUsername());
            statement.setString(2,user.getPswd());
            statement.setString(3,user.getMail());
            statement.setInt(4,user.getLienClient());

            statement.executeUpdate();
            statement.close();

            System.out.println("INSERT : insert went well");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return true;
    }
    @Override
    public boolean update(User user) {
        try{
            PreparedStatement statement = conn.prepareStatement(
                    "update utilisateur " +
                            "set username = ?, password = ?, mail = ?, id_client = ? " +
                            "where id = ?;"
            );
            statement.setString(1,user.getUsername());
            statement.setString(2,user.getPswd());
            statement.setString(3,user.getMail());
            statement.setInt(4,user.getLienClient());
            statement.setInt(5,user.getId());

            statement.executeUpdate();
            statement.close();

            System.out.println("UPDATE : udpate went well");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return true;
    }
    @Override
    public boolean delete(User user) {
        try{
            PreparedStatement statement = conn.prepareStatement(
                    "delete from utilisateur where id = ?;"
            );
            statement.setInt(1,user.getId());
            statement.executeUpdate();
            System.out.println("DELETE : delete went well");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return true;
    }
    @Override
    public User select(int id) {
        User u = null;
        try {
            PreparedStatement statement = conn.prepareStatement(
                    "select * from utilisateur " +
                            "where id = ?;");
            statement.setInt(1,id);
            ResultSet set = statement.executeQuery();
            while (set.next()){
                u = new User(
                        set.getInt("id"),
                        set.getString("username"),
                        set.getString("password"),
                        set.getString("mail"),
                        set.getInt("id_client")
                );
            }
            set.close();
            statement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return u;
    }
    @Override
    public List<User> selectAll() {
        List<User> users = new ArrayList<>();
        try{
            PreparedStatement statement = conn.prepareStatement("select * from utilisateur");
            ResultSet set = statement.executeQuery();
            while(set.next()){
                users.add(new User(
                        set.getInt("id"),
                        set.getString("username"),
                        set.getString("password"),
                        set.getString("mail"),
                        set.getInt("id_client"))
                );
            }
            set.close();
            statement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return users;
    }
}
