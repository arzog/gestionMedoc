package iram.student.controller;

import iram.student.model.Client;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class EditClientController {

    //region variables
    @FXML
    private TextField lastNameField;
    @FXML
    private TextField firstNameField;
    @FXML
    private TextField landField;
    @FXML
    private TextField cityField;
    @FXML
    private TextField streetField;
    @FXML
    private TextField numberField;
    @FXML
    private TextField cpField;

    private Stage dialogStage;
    private Client client;
    private boolean okClicked = false;
    //endregion

    @FXML
    private void initialize(){
    }

    public void setDialogStage(Stage stage){
        this.dialogStage = stage;
    }

    public void setClient(Client client){
        this.client = client;

        lastNameField.setText(client.getNom());
        firstNameField.setText(client.getPrenom());
        landField.setText(client.getPays());
        cityField.setText(client.getVille());
        streetField.setText(client.getRue());
        numberField.setText(client.getNum());
        cpField.setText(String.valueOf(client.getCp()));
    }

    public boolean isOkClicked() {
        return okClicked;
    }

    @FXML
    private void handleOk(){
        if (isInputValid()){
            client.setNom(lastNameField.getText());
            client.setPrenom(firstNameField.getText());
            client.setPays(landField.getText());
            client.setVille(cityField.getText());
            client.setRue(streetField.getText());
            client.setNum(numberField.getText());
            client.setCp(Integer.parseInt(cpField.getText()));

            okClicked = true;
            dialogStage.close();
        }
    }

    @FXML
    private void handleCancel(){
        dialogStage.close();
    }

    private boolean isInputValid(){
        String errorMsg = "";

        if (firstNameField.getText() == null || firstNameField.getText().length() == 0 || firstNameField.getText().equals("first name")) {
            errorMsg += "No valid first name!\n";
        }
        if (lastNameField.getText() == null || lastNameField.getText().length() == 0 || lastNameField.getText().equals("last name")) {
            errorMsg += "No valid last name!\n";
        }
        if (landField.getText() == null || landField.getText().length() == 0 || landField.getText().equals("land")) {
            errorMsg += "No valid land!\n";
        }
        if (cityField.getText() == null || cityField.getText().length() == 0|| cityField.getText().equals("city")){
            errorMsg += "No valid city name\n";
        }
        if (streetField.getText() == null || streetField.getText().length() == 0|| streetField.getText().equals("street")){
            errorMsg += "No valid street name\n";
        }
        if (numberField.getText() == null || numberField.getText().length() == 0|| numberField.getText().equals("house number")){
            errorMsg += "No valid house number\n";
        }
        if (cpField.getText() == null || cpField.getText().length() == 0|| cpField.getText().equals("0")){
            errorMsg += "No valid postal code number\n";
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
}
