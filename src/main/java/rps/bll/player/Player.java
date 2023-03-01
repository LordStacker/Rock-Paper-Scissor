package rps.bll.player;

//Project imports

import rps.bll.game.IGameState;
import rps.bll.game.Move;
import rps.bll.game.Result;

import java.util.ArrayList;
import java.util.Random;

/**
 * Example implementation of a player.
 *
 * @author smsj
 */
public class Player implements IPlayer {

    private static final Random RANDOM = new Random();
    private int[][] markovChain;

    private final String name;
    private final PlayerType type;

    /**
     * @param name
     */
    public Player(String name, PlayerType type) {
        this.name = name;
        this.type = type;
        init();
    }

    private void init() {
        int length = Move.values().length;
        markovChain = new int[length][length];

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                markovChain[i][j] = 0;
            }
        }
    }


    @Override
    public String getPlayerName() {
        return name;
    }


    @Override
    public PlayerType getPlayerType() {
        return type;
    }


    /**
     * Decides the next move for the bot...
     * @param state Contains the current game state including historic moves/results
     * @return Next move
     */
    @Override
    public Move doMove(IGameState state) {
        //Historic data to analyze and decide next move...
        ArrayList<Result> results = (ArrayList<Result>) state.getHistoricResults();
        Move last = null;
        Move lastPair = null;
        if (results.size() > 1) {
            if (results.get(results.size() - 1).getWinnerPlayer().getPlayerType() == PlayerType.Human) {
                last = results.get(results.size() - 1).getWinnerMove();
            } else {
                last = results.get(results.size() - 1).getLoserMove();
            }
            if (results.get(results.size() - 2).getWinnerPlayer().getPlayerType() == PlayerType.Human) {
                lastPair = results.get(results.size() - 2).getWinnerMove();
            } else {
                lastPair = results.get(results.size() - 2).getLoserMove();
            }
            updateMarkovChain(lastPair, last);
        }
        //Implemented better AI here...
        return nextMove(last);
    }

    //The ordinal() function gives the position of the Move in its enum declaration
    private void updateMarkovChain(Move prev, Move next) {
        markovChain[prev.ordinal()][next.ordinal()]++;
    }
    private Move nextMove(Move prev) {
        if (prev == null) {
            //Random function on Move list for the first move
            return Move.values()[RANDOM.nextInt(Move.values().length)];
        }

        //Predicting next Move chosen by the user - reading data in our Markov chain/matrix
        //Done by looking into our previous Move
        int nextIndex = 0;
        int prevIndex = prev.ordinal();

        for (int i = 0; i < Move.values().length; i++) {
            if (markovChain[prevIndex][i] > markovChain[prevIndex][nextIndex]) {
                nextIndex = i;
            }
        }

        //Next Move played by the user is in nextIndex
        Move predictedNext = Move.values()[nextIndex];

        //Choosing the move for which this next Move would lose
        return losesTo(predictedNext);
    }

    private Move losesTo(Move move) {
        Move losesTo = null;
        if (move == Move.Rock) {
            losesTo = Move.Paper;
        } else if (move == Move.Paper) {
            losesTo = Move.Scissor;
        } else if (move == Move.Scissor) {
            losesTo = Move.Rock;
        }
        return losesTo;
    }
}
