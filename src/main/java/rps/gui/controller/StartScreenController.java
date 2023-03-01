package rps.gui.controller;

import io.github.palexdev.materialfx.controls.MFXButton;
import io.github.palexdev.materialfx.controls.MFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.application.Application;
import javafx.stage.Stage;
import rps.Main;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class StartScreenController implements Initializable {


    @FXML
    private AnchorPane mainPain;


    @FXML
    private MFXButton submitInfo;

    @FXML
    private MFXTextField playerInput;




    public static void main(String[] args) {
        Application.launch(args);
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
    @FXML
    private void openMainStage(ActionEvent actionEvent){
        try{
            FXMLLoader loader = new FXMLLoader(Main.class.getResource("view/GameView.fxml"));
            Parent root = (Parent) loader.load();

            GameViewController gameViewController = loader.getController();
            gameViewController.setHumanName(playerInput.getText());
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
            Stage startStage = (Stage) mainPain.getScene().getWindow();
            startStage.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
