package iram.student.controller;

import iram.student.Main;
import iram.student.model.Client;
import iram.student.patterns.dao.impl.DaoClient;
import iram.student.patterns.singleton.DBConnexion;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class ClientController {

    //region variables
    ObservableList<Client> observableList;
    private DaoClient dao = new DaoClient(DBConnexion.getInstance());

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
                .filter(Client::isActif)
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

    @FXML
    private void handleNewClient(){
        Client client = new Client();
        boolean okClicked = showClientEditDialog(client);
        if (okClicked){
            client.setActif(true);
            dao.insert(client);
            initialize();
        }
    }

    @FXML
    private void handleEditClient(){
        Client selectedClient = clientTable.getSelectionModel().getSelectedItem();
        if (selectedClient != null){
            boolean okClicked = showClientEditDialog(selectedClient);
            if (okClicked){
                showClientDetails(selectedClient);
                dao.update(selectedClient);
            }
        }else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("No selection");
            alert.setHeaderText("No client selected");
            alert.setContentText("Please select a person in the table");

            alert.showAndWait();
        }
    }

    public void showClientsScreen(Main main){
        try{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("/iram/student/view/ClientsOverview.fxml"));
            AnchorPane clientView = loader.load();

            Stage stage = main.getPrimaryStage();
            Scene scene = new Scene(clientView);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
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

    private boolean showClientEditDialog(Client client){
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("/iram/student/view/EditClient.fxml"));
            AnchorPane page= loader.load();

            //create dialog stage
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Edit person");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            //set the client into the controller
            EditClientController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setClient(client);

            dialogStage.showAndWait();

            return controller.isOkClicked();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}
