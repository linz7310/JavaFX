package Controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import Model.*;
import javafx.scene.control.ChoiceDialog;

/**
 * 
 */
public class GameModel {
	/**
	 * 
	 */
	private static final String SCORES_FILE = "scores.txt";
	private Dice dice;
	private List<Player> players;
	private int currentPlayerIndex;
	private List<Obstruction> path;

	private int width;
	private int height;
	private Obstruction[][] map;
	private boolean gameover;
	private int difficulty;

	/**
	 * Creates a new game.
	 * 
	 * @param width
	 * @param height
	 */
	public GameModel(String[] playerNames, int width, int height, int difficulty) {
		this.width = width;
		this.height = height;
		this.difficulty = difficulty;

		map = new Obstruction[height][width];
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				map[i][j] = new EmptyObstruction(i, j);
			}
		}
		dice = new Dice();

		players = new ArrayList<Player>();
		for (int i = 1; i <= playerNames.length; i++) {
			players.add(new Player(i, playerNames[i - 1]));
		}

		// generate path
		generatePath();
	}


	public void generatePath() {
		path = new ArrayList<Obstruction>();
		int w = width;
		int h = height;
		while (w > 0 && h > 0) {
			int starti = (height - h) / 2;
			int endi = starti + h;
			int startj = (width - w) / 2;
			int endj = startj + w;

			if (w == 1) {
				for (int i = starti; i < endi; i++) {
					path.add(map[i][endj - 1]);
					path.get(path.size() - 1).setIndex(path.size() - 1);
				}
			} else if (h == 1) {
				for (int j = startj; j < endj; j++) {
					path.add(map[starti][j]);
					path.get(path.size() - 1).setIndex(path.size() - 1);
				}
			} else {
				for (int j = startj; j < endj; j++) {
					path.add(map[starti][j]);
					path.get(path.size() - 1).setIndex(path.size() - 1);
				}

				for (int i = starti + 1; i < endi - 1; i++) {
					path.add(map[i][endj - 1]);
					path.get(path.size() - 1).setIndex(path.size() - 1);
				}

				for (int j = endj - 1; j >= startj; j--) {
					path.add(map[endi - 1][j]);
					path.get(path.size() - 1).setIndex(path.size() - 1);
				}

				for (int i = endi - 2; i > starti; i--) {
					path.add(map[i][startj]);
					path.get(path.size() - 1).setIndex(path.size() - 1);
				}
			}

			w -= 2;
			h -= 2;
		}
	}

	public void randomObstacles() {
		// add fire
		for (int i = 0; i < difficulty; i++) {
			Obstruction obstruction = findEmptyObstruction();
			int row = obstruction.getRow();
			int col = obstruction.getColumn();

			FirePitObstruction newObstruction = new FirePitObstruction(row, col);
			newObstruction.setIndex(obstruction.getIndex());
			map[row][col] = newObstruction;
			path.set(path.indexOf(obstruction), newObstruction);
		}

		// add bottom less
		for (int i = 0; i < difficulty; i++) {
			Obstruction obstruction = findEmptyObstruction();
			int row = obstruction.getRow();
			int col = obstruction.getColumn();

			BottomlessPitObstruction newObstruction = new BottomlessPitObstruction(row, col);
			newObstruction.setIndex(obstruction.getIndex());
			map[row][col] = newObstruction;
			path.set(path.indexOf(obstruction), newObstruction);
		}

		// add tele
		for (int i = 0; i < difficulty; i++) {
			Obstruction obstruction = findEmptyObstruction();
			int row = obstruction.getRow();
			int col = obstruction.getColumn();

			TeleporterObstruction newObstruction = new TeleporterObstruction(row, col, path.size());
			newObstruction.setIndex(obstruction.getIndex());
			map[row][col] = newObstruction;
			path.set(path.indexOf(obstruction), newObstruction);
		}

		// add spite
		for (int i = 0; i < difficulty; i++) {
			Obstruction[] obstructions = findEmptyObstructions((int) (Math.random() * 2) + 3);
			for (Obstruction obstruction : obstructions) {
				int row = obstruction.getRow();
				int col = obstruction.getColumn();

				SpikePitObstruction newObstruction = new SpikePitObstruction(row, col);

				newObstruction.setIndex(obstruction.getIndex());
				map[row][col] = newObstruction;
				path.set(path.indexOf(obstruction), newObstruction);
			}
		}

		// generate path
		generatePath();
	}

	/**
	 * Get the dice.
	 *
	 * @return the dice
	 */
	public Dice getDice() {
		return dice;
	}

	public Obstruction findEmptyObstruction() {
		while (true) {
			int row = (int) (Math.random() * height);
			int col = (int) (Math.random() * width);

			Obstruction obstruction = getObstruction(row, col);
			if (obstruction instanceof EmptyObstruction && obstruction != getStartObstruction()
					&& obstruction != getEndObstruction()) {
				return obstruction;
			}
		}
	}

	public Obstruction[] findEmptyObstructions(int length) {
		Obstruction[] obstructions = new Obstruction[length];

		while (true) {
			Obstruction obstruction = findEmptyObstruction();
			obstructions[0] = obstruction;

			boolean valid = true;
			int row = obstruction.getRow();
			int col = obstruction.getColumn();
			for (int i = 1; i < length; i++) {
				Obstruction obs = getObstruction(row, col + i);
				if (obs != null && Math.abs(obs.getIndex() - obstruction.getIndex()) == i) {
					obstructions[i] = obs;
				} else {
					valid = false;
				}
			}

			if (valid) {
				break;
			}
		}

		return obstructions;
	}

	public Player getPlayerAt(int row, int col) {
		for (Player player : players) {
			int pos = player.getPosition();
			Obstruction obstruction = path.get(pos);
			if (obstruction.getRow() == row && obstruction.getColumn() == col) {
				return player;
			}
		}
		return null;
	}

	public int countPlayerAt(int row, int col) {
		int sum = 0;
		for (Player player : players) {
			int pos = player.getPosition();
			Obstruction obstruction = path.get(pos);
			if (obstruction.getRow() == row && obstruction.getColumn() == col) {
				sum++;
			}
		}
		return sum;
	}

	/**
	 * Get obstruction at a given position.
	 * 
	 * @param row row of position
	 * @param col column of position
	 * @return Model.Obstruction at (row, col).
	 */
	public Obstruction getObstruction(int row, int col) {
		if (!isValidPos(row, col)) {
			return null;
		}
		return map[row][col];
	}

	public boolean isValidPos(int row, int col) {
		return row >= 0 && row < height && col >= 0 && col < width;
	}

	public Obstruction getStartObstruction() {
		return path.get(0);
	}

	public Obstruction getEndObstruction() {
		return path.get(path.size() - 1);
	}

	/**
	 * Get the height.
	 *
	 * @return the height
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * Get the width.
	 *
	 * @return the width
	 */
	public int getWidth() {
		return width;
	}

	public Player getWinner() {
		for (Player player : players) {
			if (player.isWin()) {
				return player;
			}
		}
		return null;
	}

	/**
	 * Get the gameover.
	 *
	 * @return the gameover
	 */
	public boolean isGameover() {
		return gameover;
	}

	/**
	 * Get the path.
	 *
	 * @return the path
	 */
	public List<Obstruction> getPath() {
		return path;
	}

	public Player getCurrentPlayer() {
		return players.get(currentPlayerIndex);
	}

	public int rollDice() {
		int steps = dice.roll();
		return steps;
	}

	/**
	 * @param steps
	 */
	public String move(int steps) {
		if (gameover) {
			return "Controller.Game is over";
		}

		Player player = getCurrentPlayer();
		String msg = "";

		int direction = 1;
		for (int i = 0; i < steps; i++) {
			System.out.println(player.toString() + " at " + player.getPosition());
			if (player.getPosition() == path.size() - 1) {
				break;
			}
			
			int pos = player.getPosition();
			int nextPos = pos + direction;

			if (nextPos == path.size() - 1) {
				direction = -1;
			}

			Obstruction obstruction = path.get(nextPos);
			if (getPlayerAt(obstruction.getRow(), obstruction.getColumn()) != null) {
				continue;
			}

			if (obstruction instanceof TeleporterObstruction) {
				TeleporterObstruction tele = (TeleporterObstruction) obstruction;
				while (true) {
					ChoiceDialog<Player> choiceDialog = new ChoiceDialog<Player>(player, players);
					choiceDialog.setHeaderText(null);
					choiceDialog.setContentText("Select a player to move");
					choiceDialog.showAndWait();
					if (choiceDialog.getSelectedItem() != null) {
						tele.setThePlayerToMove(choiceDialog.getSelectedItem());
						break;
					}
				}
			}

			if (i < steps - 1) {
				String s = obstruction.pass(player);
				if (s.length() > 0) {
					msg += s + "\n";
				}
			} else {
				String s = obstruction.land(player);
				if (s.length() > 0) {
					msg += s + "\n";
				}
			}
		}
		System.out.println(player.toString() + " at " + player.getPosition());

		if (player.getPosition() == path.size() - 1) {
			msg += player.toString() + " win!";
			player.setWin(true);
			gameover = true;

			// write scores.
			Map<String, Integer> scoreMap = readScores();

			for (Player p : players) {
				p.setScore(p.getPosition());
				msg += p.toString() + "'s score: " + p.getScore() + "\n";

				if (scoreMap.containsKey(p.getName())) {
					scoreMap.put(p.getName(), scoreMap.get(p.getName()) + p.getScore());
				} else {
					scoreMap.put(p.getName(), p.getScore());
				}
			}

			try {
				PrintWriter writer = new PrintWriter(new File(SCORES_FILE));
				writer.println(toSortString(scoreMap));
				writer.close();
			} catch (FileNotFoundException e) {

			}
		}

		toNextPlayer();
		System.out.println(msg);
		return msg.trim();
	}

	public String toSortString(Map<String, Integer> scoreMap) {
		String str = "";
		int lines = 0;
		Map<String, Integer> temp = new HashMap<String, Integer>(scoreMap);
		while (temp.size() > 0 && lines < 10) {
			// get max
			String maxName = null;
			int maxScore = 0;

			for (String na : temp.keySet()) {
				if (maxName == null || temp.get(na) > maxScore) {
					maxName = na;
					maxScore = temp.get(na);
				}
			}

			temp.remove(maxName);
			str += (maxName + " - " + maxScore) + "\n";
			lines++;
		}
		return str.trim();
	}

	public Map<String, Integer> readScores() {
		Map<String, Integer> scoreMap = new HashMap<String, Integer>();
		try {
			Scanner scanner = new Scanner(new File(SCORES_FILE));
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine().trim();
				if (!line.isEmpty()) {
					String[] tokens = line.split(" - ");
					String name = tokens[0];
					int score = Integer.parseInt(tokens[1]);
					scoreMap.put(name, score);
				}
			}
		} catch (FileNotFoundException e) {

		}
		return scoreMap;
	}

	/**
	 * 
	 */
	public void toNextPlayer() {
		currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
	}
}
