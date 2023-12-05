package Model;

import Model.Player;

/**
 * Represents an empty cell.
 */
public class EmptyObstruction extends Obstruction {

    /**
     * Creates a new Model.EmptyObstruction.
     * 
     * @param row    row of position
     * @param column column of position
     */
    public EmptyObstruction(int row, int column) {
        super(row, column);
    }

    /**
     * Process the pass action of a player.
     * 
     * @param player the player to play
     */
    public String pass(Player player) {
    	player.setPosition(getIndex());
    	player.setLatestValidPosition(getIndex());
        return "";
    }

    /**
     * Process the land action of a player.
     * 
     * @param player the player to play
     */
    public String land(Player player) {
        pass(player);
        return "";
    }
}
