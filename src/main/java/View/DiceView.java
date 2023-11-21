package View;

import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

/**
 * ClassName DiceView
 * Package View
 * Description:
 *
 * @Author: Lin
 * @Creat: 2023/11/20
 */
public class DiceView extends VBox {
        private Text diceValue;
        private Button rollButton;

        public DiceView() {
            diceValue = new Text("Dice: 1");
            rollButton = new Button("Roll Dice");
            rollButton.setOnAction(event -> {
                // TODO: 实现骰子投掷逻辑
            });

            this.getChildren().addAll(diceValue, rollButton);
        }

        public void updateDiceValue(int value) {
            diceValue.setText("Dice: " + value);
        }
    }


