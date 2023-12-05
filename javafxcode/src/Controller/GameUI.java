package Controller;

import java.util.Optional;

import Model.*;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.Label;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * Represents the GUI of game.
 */
public class GameUI extends Application {
	int width = 10;
	int height = 7;
	int numberPlayer = 2;
	String[] playerNames = { "P1", "P2" };
	Integer difficulty = 1;

	private GameModel model;

	@Override
	public void start(Stage primaryStage) throws Exception {
		inputSettings();

		model = new GameModel(playerNames, width, height, difficulty);
		model.randomObstacles();

		primaryStage.setScene(new Scene(new GamePane()));
		primaryStage.show();
	}

	/**
	 * Prompt user to enter settings.
	 */
	public void inputSettings() {
		width = inputNumber("Enter the width of game board: ", 8);
		height = inputNumber("Enter the height of game board: ", 6);

		while (true) {
			ChoiceDialog<Integer> choiceDialog = new ChoiceDialog<Integer>(1, 1, 2, 3);
			choiceDialog.setHeaderText(null);
			choiceDialog.setContentText("Select difficulty: ");
			choiceDialog.showAndWait();
			difficulty = choiceDialog.getSelectedItem();
			if (difficulty != null) {
				break;
			}
		}

		numberPlayer = inputNumber("Enter the number of players: ", 2);

		playerNames = new String[numberPlayer];
		for (int i = 0; i < playerNames.length; i++) {
			playerNames[i] = inputString("Enter the name of player " + (i + 1) + ": ");
		}
	}

	class GamePane extends BorderPane {
		Label[][] labels;
		Label labelPlayer;
		Label labelStatus;

		/**
		 * Creates a new game pane.
		 */
		public GamePane() {
			Player player = model.getCurrentPlayer();
			labelPlayer = new Label(player.toString() + "'s turn");
			Button rollButton = new Button("Roll");
			rollButton.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent arg0) {
					if (model.isGameover()) {
						return;
					}

					Player player1 = model.getCurrentPlayer();
					if (player1.isMissNextTurn()) {
						player1.setMissNextTurn(false);
						labelPlayer.setText(player1.toString() + " missed this turn");
						model.toNextPlayer();
						return;
					}

					int steps = model.rollDice();
					String msg = model.move(steps);
					labelStatus.setText(msg);
					Player player2 = model.getCurrentPlayer();
					labelPlayer.setText(
							player1.toString() + " moves " + steps + " steps, " + player2.toString() + "'s turn");

					update();
				}
			});
			Button scoreButton = new Button("Score board");
			scoreButton.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent arg0) {
					String str = model.toSortString(model.readScores());
					if (str.isEmpty()) {
						str = "No scores yet!";
					}

					showMessage(str);
				}
			});
			labelStatus = new Label();
			setTop(new HBox(5, rollButton, labelPlayer, scoreButton));
			setBottom(new VBox(labelStatus));

			int width = model.getWidth();
			int height = model.getHeight();
			labels = new Label[height][width];

			GridPane gridPane = new GridPane();
			for (int i = 0; i < height; i++) {
				for (int j = 0; j < width; j++) {
					Obstruction obstruction = model.getObstruction(i, j);
					Label label = new Label();
					labels[i][j] = label;
					label.setAlignment(Pos.CENTER);
					label.setFont(Font.font(20));
					label.setPrefSize(80, 80);
					gridPane.add(label, j, i);

					boolean top = true;
					boolean bottom = true;
					boolean left = true;
					boolean right = true;

					if (obstruction == model.getStartObstruction()) {
						label.setStyle("-fx-background-color: lightgreen");
						label.setText("Start\n");
						left = false;
					} else if (obstruction == model.getEndObstruction()) {
						label.setStyle("-fx-background-color: lightgreen");
						label.setText("Finish");
					} else if (obstruction instanceof FirePitObstruction) {
						label.setStyle("-fx-background-image: url('images/fire.png')");
					} else if (obstruction instanceof BottomlessPitObstruction) {
						label.setStyle("-fx-background-image: url('images/bottomless.png')");
					} else if (obstruction instanceof SpikePitObstruction) {
						label.setStyle("-fx-background-image: url('images/spite.png')");
					} else if (obstruction instanceof TeleporterObstruction) {
						label.setStyle("-fx-background-image: url('images/tele.png')");
					} else {
						int index = i * width + j + i % 2;
						if (index % 2 == 0) {
							label.setStyle("-fx-background-color: steelblue");
						} else {
							label.setStyle("-fx-background-color: lightsteelblue");
						}
					}

					Obstruction topObstruction = model.getObstruction(i - 1, j);
					Obstruction bottomObstruction = model.getObstruction(i + 1, j);
					Obstruction leftObstruction = model.getObstruction(i, j - 1);
					Obstruction rightObstruction = model.getObstruction(i, j + 1);

					if (topObstruction != null && Math.abs(topObstruction.getIndex() - obstruction.getIndex()) == 1) {
						top = false;
					}
					if (bottomObstruction != null
							&& Math.abs(bottomObstruction.getIndex() - obstruction.getIndex()) == 1) {
						bottom = false;
					}
					if (leftObstruction != null && Math.abs(leftObstruction.getIndex() - obstruction.getIndex()) == 1) {
						left = false;
					}
					if (rightObstruction != null
							&& Math.abs(rightObstruction.getIndex() - obstruction.getIndex()) == 1) {
						right = false;
					}
					label.setBorder(createBorder(top, right, bottom, left));
				}
			}
			setCenter(gridPane);

			update();
		}

		private Border createBorder(boolean top, boolean right, boolean bottom, boolean left) {
			Color roadColor = Color.BROWN;
			Color noneRoadColor = Color.WHITE;
			Color topColor = top ? roadColor : noneRoadColor;
			Color rightColor = right ? roadColor : noneRoadColor;
			Color bottomColor = bottom ? roadColor : noneRoadColor;
			Color leftColor = left ? roadColor : noneRoadColor;

			return new Border(new BorderStroke(topColor, rightColor, bottomColor, leftColor, BorderStrokeStyle.SOLID,
					BorderStrokeStyle.SOLID, BorderStrokeStyle.SOLID, BorderStrokeStyle.SOLID, new CornerRadii(1),
					new BorderWidths(3), new Insets(0)));
		}

		public void update() {
			for (int i = 0; i < height; i++) {
				for (int j = 0; j < width; j++) {
					Obstruction obstruction = model.getObstruction(i, j);

					Label label = labels[i][j];
					if (obstruction == model.getStartObstruction()) {
						int count = model.countPlayerAt(0, 0);
						label.setText("Start\n" + "(" + count + ")");
					} else if (obstruction == model.getEndObstruction()) {
						Player player = model.getPlayerAt(i, j);
						if (player != null) {
							label.setText("Finish\n" + player.getName());
						} else {
							label.setText("Finish");
						}
					} else {
						label.setTextFill(Color.BLUE);
						label.setText("");
						Player player = model.getPlayerAt(i, j);
						if (player != null) {
							label.setText(player.getName());
						}
					}
				}
			}

			if (model.isGameover()) {
				labelPlayer.setText("The winner is " + model.getWinner().toString());
			}
		}
	}

	/**
	 * 
	 * @param prompt
	 * @return
	 */
	public String inputString(String prompt) {
		while (true) {
			TextInputDialog dialog = new TextInputDialog();
			dialog.setHeaderText(null);
			dialog.setContentText(prompt);

			Optional<String> result = dialog.showAndWait();
			if (result.isPresent()) {
				String name = result.get();
				if (!name.isEmpty()) {
					return name;
				} else {
					showMessage("Input cannot be empty.");
				}
			}
		}
	}

	public int inputNumber(String prompt, int min) {
		while (true) {
			TextInputDialog dialog = new TextInputDialog();
			dialog.setHeaderText(null);
			dialog.setContentText(prompt);

			Optional<String> result = dialog.showAndWait();
			if (result.isPresent()) {
				try {
					int n = Integer.parseInt(result.get());
					if (n >= min) {
						return n;
					} else {
						showMessage("Please input an integer which is at least " + min + ".");
					}
				} catch (NumberFormatException e) {
					showMessage("Please input an integer.");
				}
			}
		}
	}

	public void showMessage(String msg) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setHeaderText(null);
		alert.setContentText(msg);
		alert.showAndWait();
	}
}
