package Model;

/**
 * Represents a 9-sided dice.
 */
public class Dice {
    private static final int SIDE = 9;

    private int value;

    /**
     * Creates a new dice.
     */
    public Dice() {

    }

    /**
     * Roll the dice, and set value to a random number between 1 and SIDE
     * 
     * @return the value of dice
     */
    public int roll() {
        value = (int) (Math.random() * (SIDE) + 1);
        return value;
    }

    /**
     * Get the value of dice.
     *
     * @return the value of dice
     */
    public int getValue() {
        return value;
    }
}
