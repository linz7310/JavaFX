package Model;

import static org.junit.jupiter.api.Assertions.*;

import Model.BottomlessPitObstruction;
import Model.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * 
 */
class BottomlessPitObstructionTest {
	BottomlessPitObstruction obstruction;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		obstruction = new BottomlessPitObstruction(1, 2);
		obstruction.setIndex(10);
	}

	/**
	 * Test method for {@link BottomlessPitObstruction#pass(Player)}.
	 */
	@Test
	void testPass() {
		Player player = new Player(1, "P1");
		obstruction.pass(player);

		assertEquals(obstruction.getIndex(), player.getPosition());
	}

	/**
	 * Test method for {@link BottomlessPitObstruction#land(Player)}.
	 */
	@Test
	void testLand() {
		Player player = new Player(1, "P1");
		obstruction.land(player);

		assertEquals(0, player.getPosition());
	}

}
