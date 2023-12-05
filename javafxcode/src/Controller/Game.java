package Controller;

import Model.Dice;
import Model.Obstruction;
import Model.Player;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 */
public class Game {
    private Dice dice;
    private List<Player> players;
    private int currentPlayerIndex;
    private List<Obstruction> path;

    /**
     * 
     */
    public Game(int numPlayers) {
        dice = new Dice();

        players = new ArrayList<Player>();
        for (int i = 1; i <= numPlayers; i++) {
            players.add(new Player(i,"Model.Player" + i));
        }

        path = new ArrayList<Obstruction>();

        // generate path
    }

    public Player getWinner() {
        for (Player player : players) {
            if (player.isWin()) {
                return player;
            }
        }
        return null;
    }

    public void move() {
        int steps = dice.getValue();
        Player player = getCurrentPlayer();

        for (int i = 0; i < steps; i++) {
            Obstruction obstruction = path.get(player.getPosition());
            if (i < steps - 1) {
                obstruction.pass(player);
            } else {
                obstruction.land(player);
            }
        }
    }

    /**
     * Get the path.
     *
     * @return the path
     */
    public List<Obstruction> getPath() {
        return path;
    }

    public Player getCurrentPlayer() {
        return players.get(currentPlayerIndex);
    }

    public int rollDice() {
        return dice.roll();
    }
}
