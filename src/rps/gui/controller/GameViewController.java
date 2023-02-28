package rps.gui.controller;

// Java imports
import javafx.fxml.FXML;
import javafx.fxml.Initializable;


import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import io.github.palexdev.materialfx.controls.*;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import rps.bll.game.GameManager;
import rps.bll.player.IPlayer;

/**
 *
 * @author smsj
 */
public class GameViewController implements Initializable {
    @FXML
    private Label scorePlayer, scoreBot, playerName, botName;
    @FXML
    private ImageView imgPlayer, imgPlayerMove, imgBotMove, imgBot;
    @FXML
    private MFXButton btnRock, btnPaper, btnScissors;
    private IPlayer player;
    private IPlayer bot;
    private GameManager gameManager;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        scorePlayer.setText("Score: " + 0);
        scoreBot.setText("Score: " + 0);
        playerName.setText("warmish");
        botName.setText("Terminator");
    }

}
