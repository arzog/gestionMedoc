package iram.student.controller;

import iram.student.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class HomeController {

    //region variables
    private Main main;
    //endregion

    @FXML
    public void initialize(){}

    @FXML
    private void handleClients(){
        ClientController controller = new ClientController();
        controller.showClientsScreen(main);

    }
    @FXML
    private void handleUsers(){

    }
    @FXML
    private void handleMedics(){

    }
    @FXML
    private void handleBills(){

    }

    public void showHome(Main main){
        try {
            this.main = main;
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("/iram/student/view/HomeView.fxml"));
            AnchorPane homeView = loader.load();

            Stage stage = Main.primaryStage;
            Scene scene = new Scene(homeView);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

     public void setMain(Main main){ this.main = main; }
}
