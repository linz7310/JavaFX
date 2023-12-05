package Model;

import Model.Obstruction;
import Model.Player;

/**
 * Represents a Teleporter Model.Obstruction.
 */
public class TeleporterObstruction extends Obstruction {
	private Player thePlayerToMove;
	private int pathLength;

	/**
	 * Creates a new Model.TeleporterObstruction.
	 * 
	 * @param row    row of position
	 * @param column column of position
	 */
	public TeleporterObstruction(int row, int column, int pathLength) {
		super(row, column);
		this.pathLength = pathLength;
	}

	/**
	 * Set the thePlayerToMove.
	 *
	 * @param thePlayerToMove the thePlayerToMove to set
	 */
	public void setThePlayerToMove(Player thePlayerToMove) {
		this.thePlayerToMove = thePlayerToMove;
	}
 
	/**
	 * Process the pass action of a player.
	 * 
	 * @param player the player to play
	 */
	public String pass(Player player) {
		int randomPosition = (int) (Math.random() * pathLength);
		thePlayerToMove.setPosition(randomPosition);
		if (thePlayerToMove != player) {
			player.setPosition(getIndex());
		}
		return thePlayerToMove.toString() + " moves to a random position";
	}

	/**
	 * Process the land action of a player.
	 * 
	 * @param player the player to play
	 */
	public String land(Player player) {
		return pass(player);
	}
}
