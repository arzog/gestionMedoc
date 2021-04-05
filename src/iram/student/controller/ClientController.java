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

    //region variables
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
    //endregion

    @FXML
    private void initialize(){
        DaoClient dao = new DaoClient(DBConnexion.getInstance());
        List<Client> clients = dao.selectAll();
        observableList = FXCollections.observableArrayList(clients);

        firstNameColumn.setCellValueFactory(cellData -> cellData.getValue().prenomProperty());
        lastNameColumn.setCellValueFactory(cellData -> cellData.getValue().nomProperty());

        clientTable.setItems(observableList);

        //clear person details
        showClientDetails(null);

        //listen for selection changes and show the person details when changed
        clientTable.getSelectionModel().selectedItemProperty().addListener(
                ((observable, oldValue, newValue) -> showClientDetails(newValue))
        );
    }

    private void showClientDetails(Client client){
        if(client != null){
            //fill labels
            firstNameLabel.setText(client.getNom());
            lastNameLabel.setText(client.getPrenom());
            landLabel.setText(client.getPays());
            cityLabel.setText(client.getVille());
            streetLabel.setText(client.getRue());
            numberLabel.setText(client.getNum());
            cpLabel.setText(String.valueOf(client.getCp()));
        }else {
            firstNameLabel.setText("lorem ipsum");
            lastNameLabel.setText("lorem ipsum");
            landLabel.setText("lorem ipsum");
            cityLabel.setText("lorem ipsum");
            streetLabel.setText("lorem ipsum");
            numberLabel.setText("lorem ipsum");
            cpLabel.setText("lorem ipsum");
        }
    }
}
