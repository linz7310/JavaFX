package Model;

import Model.Player;

/**
 * Represents a cell on path.
 */
public abstract class Obstruction {
    private int row;
    private int column;

    /** the index of path */
    private int index;

    /**
     * Creates a new obstruction.
     * 
     * @param row    row of position
     * @param column column of position
     */
    public Obstruction(int row, int column) {
        this.row = row;
        this.column = column;
    }

    /**
     * Process the pass action of a player.
     * 
     * @param player the player to play
     * @return 
     */
    public abstract String pass(Player player);

    /**
     * Process the land action of a player.
     * 
     * @param player the player to play
     * @return 
     */
    public abstract String land(Player player);

    /**
     * Set the index.
     *
     * @param index the index to set
     */
    public void setIndex(int index) {
        this.index = index;
    }

    /**
     * Get the index.
     *
     * @return the index
     */
    public int getIndex() {
        return index;
    }
    
    /**
     * Get the row.
     *
     * @return the row
     */
    public int getRow() {
        return row;
    }
    
    /**
     * Get the column.
     *
     * @return the column
     */
    public int getColumn() {
        return column;
    }
}
