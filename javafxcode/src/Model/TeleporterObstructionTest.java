package Model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * 
 */
class TeleporterObstructionTest {
	TeleporterObstruction obstruction;
	Player player1;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		player1 = new Player(1, "P1");
		player1.setPosition(0);

		obstruction = new TeleporterObstruction(1, 2, 100);
		obstruction.setIndex(10);
	}

	/**
	 * Test method for {@link TeleporterObstruction#pass(Player)}.
	 */
	@Test
	void testPass() {
		obstruction.setThePlayerToMove(player1);
		obstruction.pass(player1);
		
		assertNotEquals(10, player1.getPosition());
		assertNotEquals(0, player1.getPosition());
	}

	/**
	 * Test method for {@link TeleporterObstruction#land(Player)}.
	 */
	@Test
	void testLand() {
		obstruction.setThePlayerToMove(player1);
		obstruction.pass(player1);
		
		assertNotEquals(10, player1.getPosition());
		assertNotEquals(0, player1.getPosition());
	}

}
