package iram.student.controller;

import iram.student.Main;
import iram.student.model.Client;
import iram.student.patterns.dao.impl.DaoClient;
import iram.student.patterns.singleton.DBConnexion;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.util.List;
import java.util.stream.Collectors;

public class ClientController {

    //region variables
    ObservableList<Client> observableList;
    DaoClient dao = new DaoClient(DBConnexion.getInstance());
    @FXML
    private TableView<Client> clientTable;
    @FXML
    private TableColumn<Client,String> firstNameColumn;
    @FXML
    private TableColumn<Client,String> lastNameColumn;

    @FXML
    private Label idLabel;
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
        List<Client> clients = dao.selectAll()
                .stream()
                .filter(c -> c.isActif())
                .collect(Collectors.toList());
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

    @FXML
    private void handleDeleteClient(){
        int selectedIndex = clientTable.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            dao.delete(clientTable.getItems().get(selectedIndex));
            initialize();
        }else {

            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("No selection");
            alert.setHeaderText("No Client selected");
            alert.setContentText("Please select a client in the table");

            alert.showAndWait();
        }
    }

    private void showClientDetails(Client client){
        if(client != null){
            //fill labels
            idLabel.setText(String.valueOf(client.getId()));
            firstNameLabel.setText(client.getNom());
            lastNameLabel.setText(client.getPrenom());
            landLabel.setText(client.getPays());
            cityLabel.setText(client.getVille());
            streetLabel.setText(client.getRue());
            numberLabel.setText(client.getNum());
            cpLabel.setText(String.valueOf(client.getCp()));
        }else {
            idLabel.setText("lorem ipsum");
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
