package Model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * 
 */
class SpikePitObstructionTest {
	SpikePitObstruction obstruction;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		obstruction = new SpikePitObstruction(1, 2);
		obstruction.setIndex(10);
	}

	/**
	 * Test method for {@link SpikePitObstruction#pass(Player)}.
	 */
	@Test
	void testPass() {
		Player player = new Player(1, "P1");
		obstruction.pass(player);

		assertEquals(obstruction.getIndex(), player.getPosition());
	}

	/**
	 * Test method for {@link SpikePitObstruction#land(Player)}.
	 */
	@Test
	void testLand() {
		Player player = new Player(1, "P1");
		player.setLatestValidPosition(2);
		
		obstruction.land(player);

		assertEquals(2, player.getPosition());
	}

}
