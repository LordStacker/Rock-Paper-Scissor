package rps.gui.controller;

// Java imports
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;


import java.io.File;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import io.github.palexdev.materialfx.controls.*;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import rps.Main;
import rps.bll.game.GameManager;
import rps.bll.game.Move;
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
        player = new Player(playerName.getText(), PlayerType.Human);
        botName.setText(bot.getPlayerName());
    }

    public void setHumanName(String userName){
        playerName.setText(userName);
    }
    private void imageSelection(Move move){
        if(move != null){
            if(move == Move.Scissor){
                Image img = new Image(Main.class.getResource("icons/scissors.png").toExternalForm());
                imgPlayerMove.setImage(img);
            }
            if(move == Move.Rock){
                Image img = new Image(Main.class.getResource("icons/raise-hand.png").toExternalForm());
                imgPlayerMove.setImage(img);
            }
            if(move == Move.Paper){
                Image img = new Image(Main.class.getResource("icons/palm-of-hand.png").toExternalForm());
                imgPlayerMove.setImage(img);
            }
        }
    }

    @FXML
    private void rockSelection(ActionEvent actionEvent){
        Move selection = Move.Rock;
        imageSelection(selection);
    }
    @FXML
    private void paperSelection(ActionEvent actionEvent){
        Move selection = Move.Paper;
        imageSelection(selection);
    }
    @FXML
    private void scissorsSelection(ActionEvent actionEvent){
        Move selection = Move.Scissor;
        imageSelection(selection);
    }


    private String getRandomBotName() {
        String[] botNames = new String[] {"Terminator", "Vegeta", "Patrik Upset", "Jeppe", "Mr.Robot", "Ni Hao"};
        return botNames[new Random().nextInt(botNames.length - 1)];
    }

}
