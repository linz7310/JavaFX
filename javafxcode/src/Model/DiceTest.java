package Model;

import static org.junit.jupiter.api.Assertions.*;

import Model.Dice;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Test Model.Dice.
 */
class DiceTest {
	Dice dice;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		dice = new Dice();
	}

	/**
	 * Test method for {@link Dice#roll()}.
	 */
	@Test
	void testRoll() {
		int value1 = dice.roll();

		assertTrue(value1 >= 1 && value1 <= 9);
		assertEquals(value1, dice.getValue());
		
		int value2 = dice.roll();
		assertFalse(value1 == value2);
	}

}
