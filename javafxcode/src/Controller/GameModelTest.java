package Controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import Controller.GameModel;
import Model.Dice;
import Model.EmptyObstruction;
import Model.Obstruction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * 
 */
class GameModelTest {
	GameModel model;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		model = new GameModel(new String[] { "P1", "P2" }, 10, 8, 1);
	}

	/**
	 * Test method for {@link GameModel#generatePath()}.
	 */
	@Test
	void testGeneratePath() {
		model.generatePath();

		assertEquals(80, model.getPath().size());
	}

	/**
	 * Test method for {@link GameModel#randomObstacles()}.
	 */
	@Test
	void testRandomObstacles() {
		model.randomObstacles();

		int countEmpty = 0;
		for (Obstruction obstruction : model.getPath()) {
			if (obstruction instanceof EmptyObstruction) {
				countEmpty++;
			}
		}

		assertTrue(countEmpty < 80);
	}

	/**
	 * Test method for {@link GameModel#getDice()}.
	 */
	@Test
	void testGetDice() {
		Dice dice = model.getDice();

		assertNotNull(dice);
	}

	/**
	 * Test method for {@link GameModel#findEmptyObstruction()}.
	 */
	@Test
	void testFindEmptyObstruction() {
		Obstruction obstruction = model.findEmptyObstruction();
		assertNotNull(obstruction);
	}

	/**
	 * Test method for {@link GameModel#findEmptyObstructions(int)}.
	 */
	@Test
	void testFindEmptyObstructions() {
		Obstruction[] obstructions = model.findEmptyObstructions(3);
		assertNotNull(obstructions[0]);
		assertNotNull(obstructions[1]);
		assertNotNull(obstructions[2]);
	}

	/**
	 * Test method for {@link GameModel#getCurrrentPlayer()}.
	 */
	@Test
	void testGetCurrrentPlayer() {
		assertEquals(1, model.getCurrentPlayer().getId());
	}

	/**
	 * Test method for {@link GameModel#getPlayerAt(int, int)}.
	 */
	@Test
	void testGetPlayerAt() {
		assertNotNull(model.getPlayerAt(0, 0));
	}

	/**
	 * Test method for {@link GameModel#countPlayerAt(int, int)}.
	 */
	@Test
	void testCountPlayerAt() {
		assertEquals(2, model.countPlayerAt(0, 0));
	}

	/**
	 * Test method for {@link GameModel#getObstruction(int, int)}.
	 */
	@Test
	void testGetObstruction() {
		assertNotNull(model.getObstruction(0, 0));
	}

	/**
	 * Test method for {@link GameModel#isValidPos(int, int)}.
	 */
	@Test
	void testIsValidPos() {
		assertTrue(model.isValidPos(0, 0));
		assertFalse(model.isValidPos(-1, 0));
		assertFalse(model.isValidPos(0, 11));
	}

	/**
	 * Test method for {@link GameModel#getStartObstruction()}.
	 */
	@Test
	void testGetStartObstruction() {
		assertEquals(model.getObstruction(0, 0), model.getStartObstruction());
	}

	/**
	 * Test method for {@link GameModel#getEndObstruction()}.
	 */
	@Test
	void testGetEndObstruction() {
		assertEquals(model.getPath().get(model.getPath().size() - 1), model.getEndObstruction());
	}

	/**
	 * Test method for {@link GameModel#getHeight()}.
	 */
	@Test
	void testGetHeight() {
		assertEquals(8, model.getHeight());
	}

	/**
	 * Test method for {@link GameModel#getWidth()}.
	 */
	@Test
	void testGetWidth() {
		assertEquals(10, model.getWidth());
	}

	/**
	 * Test method for {@link GameModel#getWinner()}.
	 */
	@Test
	void testGetWinner() {
		assertNull(model.getWinner());
	}

	/**
	 * Test method for {@link GameModel#isGameover()}.
	 */
	@Test
	void testIsGameover() {
		assertFalse(model.isGameover());
	}

	/**
	 * Test method for {@link GameModel#getPath()}.
	 */
	@Test
	void testGetPath() {
		assertEquals(80, model.getPath().size());
	}

	/**
	 * Test method for {@link GameModel#getCurrentPlayer()}.
	 */
	@Test
	void testGetCurrentPlayer() {
		assertEquals(1, model.getCurrentPlayer().getId());

	}

	/**
	 * Test method for {@link GameModel#rollDice()}.
	 */
	@Test
	void testRollDice() {
		int value = model.rollDice();
		assertTrue(value >= 1 && value <= 9);
	}

	/**
	 * Test method for {@link GameModel#move(int)}.
	 */
	@Test
	void testMove() {
		model.move(3);
		model.move(1);
		assertEquals(3, model.getCurrentPlayer().getPosition());
	}
 
	/**
	 * Test method for {@link GameModel#toNextPlayer()}.
	 */
	@Test
	void testToNextPlayer() {
		assertEquals(1, model.getCurrentPlayer().getId());
		model.toNextPlayer();
		assertEquals(2, model.getCurrentPlayer().getId());
	}

}
