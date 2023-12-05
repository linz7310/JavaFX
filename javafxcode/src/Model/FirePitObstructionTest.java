package Model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * 
 */
class FirePitObstructionTest {
	FirePitObstruction obstruction;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		obstruction = new FirePitObstruction(1, 2);
		obstruction.setIndex(10);
	}

	/**
	 * Test method for {@link FirePitObstruction#pass(Player)}.
	 */
	@Test
	void testPass() {
		Player player = new Player(1, "P1");
		obstruction.pass(player);

		assertTrue(player.isMissNextTurn());
	}

	/**
	 * Test method for {@link FirePitObstruction#land(Player)}.
	 */
	@Test
	void testLand() {
		Player player = new Player(1, "P1");
		obstruction.land(player);

		assertTrue(player.isMissNextTurn());
	}

}
