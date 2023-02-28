package rps.gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class StartScreenController extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("/rps/gui/view/StartScreen.fxml"));
        stage.setTitle("Rock, Paper, Scissors the Game");
        stage.setScene(new Scene(root));
        stage.show();

    }

    public static void launch() {
        Application.launch();
    }


}
