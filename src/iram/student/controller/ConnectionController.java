package iram.student.controller;

import iram.student.Main;
import iram.student.model.Client;
import iram.student.model.User;
import iram.student.patterns.dao.impl.DaoUser;
import iram.student.patterns.singleton.DBConnexion;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class ConnectionController {

    //region variables
    private DaoUser dao = new DaoUser(DBConnexion.getInstance());
    private Main main;

    @FXML
    private TextField userTextField;
    @FXML
    private PasswordField pswdTextField;
    //endregion

    @FXML
    private void initialize(){
    }

    @FXML
    private void handleQuit(){
        Platform.exit();
    }
    @FXML
    private void handleConnection(){
        String errorMsg = "";
        if (userTextField.getText().equals("")){
            errorMsg += "Insérez un nom d'utilisateur\n";
        }
        if (pswdTextField.getText().trim().isEmpty()){
            errorMsg += "Insérez un mot de passe\n";
        }
        if (errorMsg.length()==0) {
            User user = dao.select(userTextField.getText(), pswdTextField.getText());

            if (user != null){
                ClientController controller = new ClientController();
                controller.showClientsScreen(main);
            } else {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Mauvais identifiants");
                alert.setHeaderText("Connexion impossible");
                alert.setContentText("votre nom d'utilisateur et/ou votre mot de passe sont erronés");

                alert.showAndWait();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Invalid fields");
            alert.setHeaderText("Please correct invalid fields");
            alert.setContentText(errorMsg);

            alert.showAndWait();
        }
    }

    @FXML
    private void handleSubscribe(){
        try {
            FXMLLoader loader = new FXMLLoader( );
            loader.setLocation(Main.class.getResource("/iram/student/view/SubscribeView.fxml"));
            AnchorPane page = loader.load();

            Stage dialogStage = new Stage();
            dialogStage.setTitle("Inscription");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            SubscribeController controller = loader.getController();
            controller.setDialogStage(dialogStage);

            dialogStage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void setMain(Main main){
        this.main = main;
    }
}
