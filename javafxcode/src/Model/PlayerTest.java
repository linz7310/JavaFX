package Model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import Model.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * 
 */
class PlayerTest {
	Player player;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		player = new Player(1, "P1");
	}

	/**
	 * Test method for {@link Player#getName()}.
	 */
	@Test
	void testGetName() {
		assertEquals("P1", player.getName());
	}

	/**
	 * Test method for {@link Player#toString()}.
	 */
	@Test
	void testToString() {
		assertEquals("Model.Player 1 - P1", player.toString());
	}

	/**
	 * Test method for {@link Player#setLatestValidPosition(int)}.
	 */
	@Test
	void testSetLatestValidPosition() {
		player.setLatestValidPosition(1);

		assertEquals(1, player.getLatestValidPosition());
	}

	/**
	 * Test method for {@link Player#isWin()}.
	 */
	@Test
	void testIsWin() {
		assertFalse(player.isWin());
	}

	/**
	 * Test method for {@link Player#setWin(boolean)}.
	 */
	@Test
	void testSetWin() {
		player.setWin(true);
		assertTrue(player.isWin());
	}

	/**
	 * Test method for {@link Player#isMissNextTurn()}.
	 */
	@Test
	void testIsMissNextTurn() {
		assertFalse(player.isMissNextTurn());
	}

	/**
	 * Test method for {@link Player#setMissNextTurn(boolean)}.
	 */
	@Test
	void testSetMissNextTurn() {
		player.setMissNextTurn(true);
		assertTrue(player.isMissNextTurn());
	}

	/**
	 * Test method for {@link Player#getId()}.
	 */
	@Test
	void testGetId() {
		assertEquals(1, player.getId());
	}

	/**
	 * Test method for {@link Player#getPosition()}.
	 */
	@Test
	void testGetPosition() {
		assertEquals(0, player.getPosition());
	}

	/**
	 * Test method for {@link Player#setPosition(int)}.
	 */
	@Test
	void testSetPosition() {
		player.setPosition(10);
		assertEquals(10, player.getPosition());
	}

	/**
	 * Test method for {@link Player#getScore()}.
	 */
	@Test
	void testGetScore() {
		assertEquals(0, player.getScore());
	}

	/**
	 * Test method for {@link Player#setScore(int)}.
	 */
	@Test
	void testSetScore() {
		player.setScore(10);
		assertEquals(10, player.getScore());
	}

}
