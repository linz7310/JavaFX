package Controller;

import Model.Dice;

/**
 * ClassName DiceController
 * Package Controller
 * Description:
 *
 * @Author: Lin
 * @Creat: 2023/11/20
 */
public class DiceController {
    private Dice dice;

    public DiceController(Dice dice) {
        this.dice = dice;
    }

    public int rollDice() {
        return dice.roll();
        // 返回骰子结果
    }
}
