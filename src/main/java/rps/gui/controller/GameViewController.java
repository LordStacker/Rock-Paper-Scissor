package rps.gui.controller;

// Java imports
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;


import java.net.URL;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;
import java.util.ResourceBundle;
import io.github.palexdev.materialfx.controls.*;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import rps.Main;
import rps.bll.game.*;
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
    private ImageView imgPlayer, imgPlayerMove, imgBotMove, imgBot, imgTitle;
    @FXML
    private MFXButton btnRock, btnPaper, btnScissors;
    private IPlayer player;
    private IPlayer bot;
    private GameManager gameManager;
    private final IntegerProperty playerScore = new SimpleIntegerProperty();
    private final IntegerProperty botScore = new SimpleIntegerProperty();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        bot = new Player(getRandomBotName(), PlayerType.AI);
        player = new Player(playerName.getText(), PlayerType.Human);
        botName.setText(bot.getPlayerName());
        gameManager = new GameManager(player, bot);
        //getPlayersImages(bot.getPlayerName()); The icon feature is temporarily removed
        scorePlayer.textProperty().bind(playerScore.asString());
        scoreBot.textProperty().bind(botScore.asString());

    }

    public void setHumanName(String userName){
        playerName.setText(userName);
    }
    private void doMove(Move move){
        if(move != null){
            // sets the image of the player move
            setImages(move, imgPlayerMove);
            gameManager.playRound(move);
            IGameState state = gameManager.getGameState();
            ArrayList<Result> results = (ArrayList<Result>) state.getHistoricResults();
            updateScore(results);
        }
    }

    private void updateScore(ArrayList<Result> results) {
        Result result = results.get(results.size() - 1);
        if (result.getType() == ResultType.Tie){
            setImages(result.getLoserMove(), imgBotMove);
        } else if (result.getWinnerPlayer().getPlayerType() == PlayerType.Human) {
            playerScore.set(playerScore.get() + 1);
            setImages(result.getLoserMove(), imgBotMove);
        } else if (result.getWinnerPlayer().getPlayerType() == PlayerType.AI) {
            botScore.set(botScore.get() + 1);
            setImages(result.getWinnerMove(), imgBotMove);
        }
    }

    private void setImages(Move move, ImageView imageView) {
        if (move == Move.Scissor) {
            Image img = new Image(Objects.requireNonNull(Main.class.getResource("icons/scissors.png")).toExternalForm());
            imageView.setImage(img);
        } else if (move == Move.Rock) {
            Image img = new Image(Objects.requireNonNull(Main.class.getResource("icons/raise-hand.png")).toExternalForm());
            imageView.setImage(img);
        } else if (move == Move.Paper) {
            Image img = new Image(Objects.requireNonNull(Main.class.getResource("icons/palm-of-hand.png")).toExternalForm());
            imageView.setImage(img);
        }
    }

    @FXML
    private void rockSelection(ActionEvent actionEvent){
        Move selection = Move.Rock;
        doMove(selection);
    }
    @FXML
    private void paperSelection(ActionEvent actionEvent){
        Move selection = Move.Paper;
        doMove(selection);
    }
    @FXML
    private void scissorsSelection(ActionEvent actionEvent){
        Move selection = Move.Scissor;
        doMove(selection);
    }


    private String getRandomBotName() {
        String[] botNames = new String[] {"Terminator", "Patrik", "Jeppe", "Goku"};
        return botNames[new Random().nextInt(botNames.length - 1)];
    }

    /* The icon feature is temporarily removed
    private void getPlayersImages(String botImage){
        if(bot != null){
            Image img  = new Image(Main.class.getResource("Images/"+ botImage +".jpg").toExternalForm());
            imgBot.setImage(img);
        }
        Image pImg  = new Image(Main.class.getResource("Images/User.jpg").toExternalForm());
        imgPlayer.setImage(pImg);
        //Title Image
        Image titleImg = new Image(Main.class.getResource("Images/RPS.png").toExternalForm());
        imgTitle.setImage(titleImg);
    }*/

}
