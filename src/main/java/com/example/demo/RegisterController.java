package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class RegisterController {

    islemler islemler= new islemler();

    @FXML
    private Label mesaj_alani;

    @FXML
    private PasswordField password_textField;

    @FXML
    private TextField userName_textField;

    @FXML
    private Button back_button;

    @FXML
    private Button register_button;

    @FXML
    public void Register(ActionEvent event){
        MyJDBC.addUser(userName_textField.getText(),password_textField.getText());
    }

    @FXML
    public void backButtonAction(ActionEvent event) throws IOException {

        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        currentStage.close();
        FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene root = new Scene(loader.load(), 769, 517);
        Stage stage = new Stage();
        stage.setScene(root);
        stage.show();
    }
}
