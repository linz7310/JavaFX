package View;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.layout.VBox;

/**
 * ClassName PlayerView
 * Package View
 * Description:
 *
 * @Author: Lin
 * @Creat: 2023/11/20
 */
public class PlayerView extends VBox {
    private Text playerName;
    private Text playerScore;

    public PlayerView(String name) {
        playerName = new Text(name);
        playerScore = new Text("Score: 0");

        this.getChildren().addAll(playerName, playerScore);
    }

    public void updateScore(int score) {
        playerScore.setText("Score: " + score);
    }
}