package iram.student.controller;

import iram.student.Main;
import iram.student.model.Client;
import iram.student.patterns.dao.impl.DaoClient;
import iram.student.patterns.singleton.DBConnexion;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.util.List;

public class ClientController {

    ObservableList<Client> observableList;

    @FXML
    private TableView<Client> clientTable;
    @FXML
    private TableColumn<Client,String> firstNameColumn;
    @FXML
    private TableColumn<Client,String> lastNameColumn;

    @FXML
    private Label firstNameLabel;
    @FXML
    private Label lastNameLabel;
    @FXML
    private Label landLabel;
    @FXML
    private Label cityLabel;
    @FXML
    private Label streetLabel;
    @FXML
    private Label numberLabel;
    @FXML
    private Label cpLabel;

    private Main main;

    @FXML
    private void initialize(){
        DaoClient dao = new DaoClient(DBConnexion.getInstance());
        List<Client> clients = dao.selectAll();
        observableList = FXCollections.observableArrayList(clients);

        firstNameColumn.setCellValueFactory(cellData -> cellData.getValue().prenomProperty());
        lastNameColumn.setCellValueFactory(cellData -> cellData.getValue().nomProperty());

        setMain();
    }

    public void  setMain(/*Main main*/){
//        this.main = main;
        clientTable.setItems(observableList);
    }
}
