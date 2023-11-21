package View;

import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

/**
 * ClassName ScoreboardView
 * Package View
 * Description:
 *
 * @Author: Lin
 * @Creat: 2023/11/20
 */
public class ScoreboardView extends VBox {
    private Text scoreboardTitle;
    private Text scores;

    public ScoreboardView() {
        scoreboardTitle = new Text("Scoreboard");
        scores = new Text("Player Scores...");

        this.getChildren().addAll(scoreboardTitle, scores);
    }

    public void updateScores(String scoreData) {
        scores.setText(scoreData);
    }
}
