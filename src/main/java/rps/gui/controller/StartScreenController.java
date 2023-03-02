package rps.gui.controller;

import io.github.palexdev.materialfx.controls.MFXButton;
import io.github.palexdev.materialfx.controls.MFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.application.Application;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import rps.Main;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class StartScreenController implements Initializable {


    @FXML
    private AnchorPane mainPain;


    @FXML
    private MFXButton submitInfo;

    @FXML
    private MFXTextField playerInput;

    @FXML
    private ImageView imgIntro;




    public static void main(String[] args) {
        Application.launch(args);
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    public static void showDefaultAlert(String content, Alert.AlertType type) {
        Alert alert = new Alert(type);
        alert.setAlertType(type);
        alert.setHeaderText(null); // maybe redundant
        alert.setContentText(content);
        alert.getDialogPane().getChildren()
                .stream()
                .filter(node -> node instanceof Label)
                .forEach(node -> ((Label) node)
                        .setMinHeight(Region.USE_PREF_SIZE));
        alert.setResizable(false);
        alert.getDialogPane().setMaxWidth(350);
        alert.initStyle(StageStyle.UNDECORATED);
        alert.getDialogPane().getStylesheets().add(Objects.requireNonNull(Main.class.getResource("css/StartScreenStyle.css")).toExternalForm());
        alert.getDialogPane().getStyleClass().add("dialog-alert-style");
        alert.show();
    }
    @FXML
    private void openMainStage(ActionEvent actionEvent){
        if (playerInput.getText().isEmpty()){
            System.out.println("You shall not pass");
            //TODO Make an alert asking for an username or name bla bla
            //1 I need to make an alert
            showDefaultAlert("Please enter valid username", Alert.AlertType.WARNING);
            //2 To notify that username is empty

        }
        else{
            try{
                FXMLLoader loader = new FXMLLoader(Main.class.getResource("view/GameView.fxml"));
                Parent root = (Parent) loader.load();
                GameViewController gameViewController = loader.getController();
                gameViewController.setHumanName(playerInput.getText());
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.setResizable(false);
                stage.show();
                Stage startStage = (Stage) mainPain.getScene().getWindow();
                startStage.close();


            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }




    }
}
