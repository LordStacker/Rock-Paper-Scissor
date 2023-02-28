package rps.gui.controller;

// Java imports
import javafx.fxml.FXML;
import javafx.fxml.Initializable;


import java.io.File;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import io.github.palexdev.materialfx.controls.*;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import rps.bll.game.GameManager;
import rps.bll.player.IPlayer;
import rps.bll.player.Player;
import rps.bll.player.PlayerType;

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
        bot = new Player(getRandomBotName(), PlayerType.AI);
        //TODO BRING THE NAME FROM FIRST FXML
        player = new Player("Nicola", PlayerType.Human);
        botName.setText(bot.getPlayerName());
    }
    private String getRandomBotName() {
        String[] botNames = new String[] {"Terminator", "Vegeta", "Patrik Upset", "Jeppe", "Hola", "Mr.Robot", "Ni Hao"};
        return botNames[new Random().nextInt(botNames.length - 1)];
    }

}
