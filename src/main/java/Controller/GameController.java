package Controller;

import Model.GameState;

/**
 * ClassName GameController
 * Package Controller
 * Description:
 *
 * @Author: Lin
 * @Creat: 2023/11/20
 */
public class GameController {
    private GameState gameState;

    public GameController(GameState gameState) {
        this.gameState = gameState;
    }

    public void startGame() {
        // 初始化游戏，设置玩家和障碍物等
    }

    public void nextTurn() {
        gameState.nextTurn();
        // 可以在这里处理轮次切换逻辑
    }

    public void rollDice() {
        int diceValue = gameState.rollDice();
        // 处理骰子结果
        gameState.movePlayer(gameState.getCurrentPlayer(), diceValue);
    }
}
