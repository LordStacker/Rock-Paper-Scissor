package rps.gui;

// Java imports

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import rps.Main;

/**
 * JavaFX implementation of the RPS game
 *
 * @author smsj
 */
public class JavaFXApp extends Application {

    public static void launch() {
        Application.launch();
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(Main.class.getResource("view/StartScreen.fxml"));
        stage.setTitle("Welcome to Rock-Paper-Scissor game!");
        stage.getIcons().addAll(new Image(Main.class.getResource("icons/RPSLogo.png").toExternalForm()));
        stage.setScene(new Scene(root));
        stage.setResizable(false);
        stage.show();
    }
}
