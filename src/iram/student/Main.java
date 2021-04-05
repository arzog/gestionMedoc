package iram.student;

import iram.student.controller.ClientController;
import iram.student.model.Client;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    private Stage primaryStage;
    private BorderPane rootLayout;
    private ObservableList<Client> clientData = FXCollections.observableArrayList();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Affichage clients");

        initRootLayoout();
        showClientsScreen();
    }

    public void initRootLayoout(){
        try {

            //load root
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("/iram/student/view/RootLayout.fxml"));
            rootLayout = loader.load();

            //show scene
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showClientsScreen(){
        try{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("/iram/student/view/ClientsOverview.fxml"));
            AnchorPane connexion = loader.load();

            rootLayout.setCenter(connexion);

//            ClientController controller = new ClientController();
//            controller.setMain();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public ObservableList<Client> getClientData(){
        return clientData;
    }
}
