package Model;

import Model.Obstruction;
import Model.Player;

/**
 * Represents a Spike Pit Model.Obstruction.
 */
public class SpikePitObstruction extends Obstruction {

	/**
	 * Creates a new Model.TeleporterObstruction.
	 * 
	 * @param row    row of position
	 * @param column column of position
	 */
	public SpikePitObstruction(int row, int column) {
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
		player.setPosition(player.getLatestValidPosition());
		return player.toString() + " failed to cross the spike pit";
	}
}
