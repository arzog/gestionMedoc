package iram.student.controller;

import iram.student.model.Client;
import javafx.fxml.FXML;
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
        this.dialogStage = dialogStage;
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

        if (lastNameField.getText().matches("[a-zA-Z| ']{2,50}")){
            errorMsg += "No valid last name";
        }
        return false;
    }
}
