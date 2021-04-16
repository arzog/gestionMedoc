package iram.student.controller;

import iram.student.Main;
import iram.student.model.User;
import iram.student.patterns.dao.impl.DaoUser;
import iram.student.patterns.singleton.DBConnexion;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;

import java.util.List;

public class UserController {

    //region variables
    private Main main;
    private final DaoUser dao = new DaoUser(DBConnexion.getInstance());

    private Label usernameLabel;
    private Label nameLabel;
    private Label firstnameLabel;

    private TableColumn<User,String> usernameColumn;
    //endregion

    private void initialize(){
        List<User> users = dao.selectAll();
        ObservableList<User> observableList = FXCollections.observableArrayList(users);

        usernameColumn.setCellValueFactory(celldata -> celldata.getValue().usernameProperty());

    }
}
