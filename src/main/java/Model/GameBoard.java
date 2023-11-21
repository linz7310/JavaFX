package Model;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 * @author zyl
 */
public class GameBoard extends Application {
    private static final int ROWS = 5;
    private static final int COLS = 8;
    private static final int CELL_SIZE = 50;
    private int[][] board = new int[ROWS][COLS];

    @Override
    public void start(Stage primaryStage) {
        fillSpiralPath();
        GridPane gridPane = createGridPane();

        Scene scene = new Scene(gridPane);
        primaryStage.setTitle("Simon's Obstacle Course - Game Board");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void fillSpiralPath() {
        int number = 1, startCol = 0, endCol = COLS - 1, startRow = 0, endRow = ROWS - 1;
        while (startCol <= endCol && startRow <= endRow) {
            for (int i = startCol; i <= endCol; i++) {
                board[startRow][i] = number++;
            }
            for (int i = startRow + 1; i <= endRow; i++) {
                board[i][endCol] = number++;
            }
            if (startRow < endRow && startCol < endCol) {
                for (int i = endCol - 1; i >= startCol; i--) {
                    board[endRow][i] = number++;
                }
                for (int i = endRow - 1; i > startRow; i--) {
                    board[i][startCol] = number++;
                }
            }
            startCol++;
            endCol--;
            startRow++;
            endRow--;
        }
    }

    private GridPane createGridPane() {
        GridPane gridPane = new GridPane();
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                gridPane.add(createCell(board[row][col]), col, row);
            }
        }
        return gridPane;
    }

    private Rectangle createCell(int number) {
        Rectangle cell = new Rectangle(CELL_SIZE, CELL_SIZE);
        cell.setFill(Color.LIGHTGRAY);
        cell.setStroke(Color.BLACK);

        Text text = new Text(String.valueOf(number));
        GridPane gridPane = new GridPane();
        gridPane.add(cell, 0, 0);
        gridPane.add(text, 0, 0);
        GridPane.setHalignment(text, javafx.geometry.HPos.CENTER);

        return cell;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
