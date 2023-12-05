package Model;

import Model.Player;

/**
 * Represents a Fire Pit Model.Obstruction.
 * @author zyl
 */
public class FirePitObstruction extends Obstruction {

	/**
	 * Creates a new Model.TeleporterObstruction.
	 * 
	 * @param row    row of position
	 * @param column column of position
	 */
	public FirePitObstruction(int row, int column) {
		super(row, column);
	}

	/**
	 * Process the pass action of a player.
	 * 
	 * @param player the player to play
	 */
	public String pass(Player player) {
		player.setPosition(getIndex());
	     return "";
	}

	/**
	 * Process the land action of a player.
	 * 
	 * @param player the player to play
	 */
	public String land(Player player) {
		player.setPosition(getIndex());
		player.setMissNextTurn(true);
        return player.toString() + " fell into a fire pit";
	}
}
