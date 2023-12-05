package Model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Test Model.EmptyObstruction.
 */
class EmptyObstructionTest {
	EmptyObstruction emptyObstruction;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		emptyObstruction = new EmptyObstruction(1, 2);
		emptyObstruction.setIndex(10);
	}

	/**
	 * Test method for {@link EmptyObstruction#pass(Player)}.
	 */
	@Test
	void testPass() {
		Player player = new Player(1, "P1");
		emptyObstruction.pass(player);

		Assertions.assertEquals(emptyObstruction.getIndex(), player.getPosition());
		Assertions.assertEquals(emptyObstruction.getIndex(), player.getLatestValidPosition());
	}

	/**
	 * Test method for {@link EmptyObstruction#land(Player)}.
	 */
	@Test
	void testLand() {
		Player player = new Player(1, "P1");
		emptyObstruction.land(player);

		Assertions.assertEquals(emptyObstruction.getIndex(), player.getPosition());
		Assertions.assertEquals(emptyObstruction.getIndex(), player.getLatestValidPosition());
	}
 
	/**
	 * Test method for {@link Obstruction#getIndex()}.
	 */
	@Test
	void testGetIndex() {
		Assertions.assertEquals(10, emptyObstruction.getIndex());
	}

	/**
	 * Test method for {@link Obstruction#getRow()}.
	 */
	@Test
	void testGetRow() {
		Assertions.assertEquals(1, emptyObstruction.getRow());
	}

	/**
	 * Test method for {@link Obstruction#getColumn()}.
	 */
	@Test
	void testGetColumn() {
		Assertions.assertEquals(2, emptyObstruction.getColumn());
	}

}
