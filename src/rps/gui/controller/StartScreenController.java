package rps.gui.controller;

import io.github.palexdev.materialfx.controls.MFXButton;
import io.github.palexdev.materialfx.controls.MFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class StartScreenController implements Initializable {


    @FXML
    private ImageView femaleImg;

    @FXML
    private AnchorPane mainPain;

    @FXML
    private ImageView maleImg;

    @FXML
    private ImageView otherImg;

    @FXML
    private MFXButton selectOne;

    @FXML
    private MFXButton selectThree;

    @FXML
    private MFXButton selectTwo;

    @FXML
    private MFXTextField username;




    public static void main(String[] args) {
        Application.launch(args);
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
