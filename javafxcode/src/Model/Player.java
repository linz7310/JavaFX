package Model;

/**
 * Represents a player.
 */
public class Player {
	/** id of player */
	private int id;

	/** position on path */
	private int position;

	/** the last valid position */
	private int latestValidPosition;

	/** miss the next turn */
	private boolean missNextTurn;

	/** indicates whether this player win */
	private boolean win;

	/** the name of player */
	private String name;

	/** the score of player*/
	private int score;
	
	/**
	 * Creates a new player.
	 * 
	 * @param id
	 * @param name
	 */
	public Player(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public String getName() {
		return name;
	}
	
	@Override
	public String toString() {
		return "Model.Player " + id + " - " + name;
	}

	/**
	 * Set the latestValidPosition.
	 *
	 * @param latestValidPosition the latestValidPosition to set
	 */
	public void setLatestValidPosition(int latestValidPosition) {
		this.latestValidPosition = latestValidPosition;
	}

	/**
	 * Get the latestValidPosition.
	 *
	 * @return the latestValidPosition
	 */
	public int getLatestValidPosition() {
		return latestValidPosition;
	}

	/**
	 * Get the win.
	 *
	 * @return the win
	 */
	public boolean isWin() {
		return win;
	}

	/**
	 * Set the win.
	 *
	 * @param win the win to set
	 */
	public void setWin(boolean win) {
		this.win = win;
	}

	/**
	 * Get the missNextTurn.
	 *
	 * @return the missNextTurn
	 */
	public boolean isMissNextTurn() {
		return missNextTurn;
	}

	/**
	 * Set the missNextTurn.
	 *
	 * @param missNextTurn the missNextTurn to set
	 */
	public void setMissNextTurn(boolean missNextTurn) {
		this.missNextTurn = missNextTurn;
	}

	/**
	 * Get the id.
	 *
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Get the position.
	 *
	 * @return the position
	 */
	public int getPosition() {
		return position;
	}

	/**
	 * Set the position.
	 *
	 * @param position the position to set
	 */
	public void setPosition(int position) {
		this.position = position;
	}
	
	/**
	 * Get the score.
	 *
	 * @return the score
	 */
	public int getScore() {
		return score;
	}
	
	/**
	 * Set the score.
	 *
	 * @param score the score to set
	 */
	public void setScore(int score) {
		this.score = score;
	}
}
