package iram.student.controller;

import iram.student.enums.RoleUser;
import iram.student.model.Client;
import iram.student.model.User;
import iram.student.patterns.dao.impl.DaoClient;
import iram.student.patterns.dao.impl.DaoUser;
import iram.student.patterns.singleton.DBConnexion;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class SubscribeController {

    //region variables
    private DaoUser daoUser = new DaoUser(DBConnexion.getInstance());
    private DaoClient daoClient = new DaoClient(DBConnexion.getInstance());
    private Stage dialogStage;

    @FXML
    private TextField lastNameTF;
    @FXML
    private TextField firstNameTF;
    @FXML
    private TextField landTF;
    @FXML
    private TextField cityTF;
    @FXML
    private TextField streetTF;
    @FXML
    private TextField numberTF;
    @FXML
    private TextField cpTF;
    @FXML
    private TextField userNameTF;
    @FXML
    private TextField pswdTF;
    @FXML
    private TextField verifTF;
    @FXML
    private TextField mailTF;
    //endregion

    @FXML
    private void initialize(){
    }

    @FXML
    private void handleQuit(){
        Platform.exit();
    }

    @FXML
    private void handleCancel(){
        dialogStage.close();
    }

    @FXML
    private void handleSubscribe(){
        if (isValid()){
            Client client = new Client(
                    lastNameTF.getText(),
                    firstNameTF.getText(),
                    landTF.getText(),
                    cityTF.getText(),
                    streetTF.getText(),
                    numberTF.getText(),
                    Integer.parseInt(cpTF.getText()),
                    true);
            System.out.println("ok");
            daoClient.insert(client);

            daoUser.insert(
                    new User(
                            RoleUser.USER,
                            userNameTF.getText(),
                            pswdTF.getText(),
                            mailTF.getText(),
                            daoClient.lastID())
            );

            dialogStage.close();
        }
    }

    private boolean isValid(){
        String errorMsg = "";

        if (firstNameTF.getText() == null || firstNameTF.getText().length() == 0 || firstNameTF.getText().equals("first name")) {
            errorMsg += "No valid first name!\n";
        }
        if (lastNameTF.getText() == null || lastNameTF.getText().length() == 0 || lastNameTF.getText().equals("last name")) {
            errorMsg += "No valid last name!\n";
        }
        if (landTF.getText() == null || landTF.getText().length() == 0 || landTF.getText().equals("land")) {
            errorMsg += "No valid land!\n";
        }
        if (cityTF.getText() == null || cityTF.getText().length() == 0|| cityTF.getText().equals("city")){
            errorMsg += "No valid city name\n";
        }
        if (streetTF.getText() == null || streetTF.getText().length() == 0|| streetTF.getText().equals("street")){
            errorMsg += "No valid street name\n";
        }
        if (numberTF.getText() == null || numberTF.getText().length() == 0|| numberTF.getText().equals("house number")){
            errorMsg += "No valid house number\n";
        }
        if (cpTF.getText() == null || cpTF.getText().length() == 0|| cpTF.getText().equals("0")){
            errorMsg += "No valid postal code number\n";
        }
        if (userNameTF.getText() == null || userNameTF.getText().length() == 0|| userNameTF.getText().equals("")){
            errorMsg += "No valid password \nIt must contain between 8 to 15 characters with, at least, one MAJ and, at least, one special character\n";
        }
        if (pswdTF.getText() == null || pswdTF.getText().length() == 0|| pswdTF.getText().equals("") || !pswdTF.getText().matches("^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[-+!*$@%_])([-+!*$@%_\\w]{8,15})$")){
            errorMsg += "No valid password \nIt must contain between 8 to 15 characters with, at least, one MAJ and, at least, one special character\n";
        }
        if (!verifTF.getText().equals(pswdTF.getText())){
            errorMsg += "The verif doesn't match the password\n";
        }
        if (mailTF.getText() == null || mailTF.getText().length() == 0|| mailTF.getText().equals("") || !mailTF.getText().matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")){
            errorMsg += "No valid mail address\n";
        }

        if (errorMsg.length() == 0){
            return true;
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initOwner(dialogStage);
            alert.setTitle("Invalid fields");
            alert.setHeaderText("Please correct invalid fields");
            alert.setContentText(errorMsg);

            alert.showAndWait();

            return false;
        }
    }

    public void setDialogStage(Stage stage){
        this.dialogStage = stage;
    }
}
