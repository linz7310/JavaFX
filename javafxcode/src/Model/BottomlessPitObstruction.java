package Model;

import Model.Player;

/**
 * Represents a Bottomless Pit Model.Obstruction.
 */
public class BottomlessPitObstruction extends Obstruction {

	/**
	 * Creates a new Model.BottomlessPitObstruction.
	 * 
	 * @param row    row of position
	 * @param column column of position
	 */
	public BottomlessPitObstruction(int row, int column) {
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
		player.setPosition(0);
		return (player.getName() + " fall in a bottomless pit and return to the start");
	}
}
