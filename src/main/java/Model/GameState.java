package Model;

import java.util.List;

/**
 * ClassName GameState
 * Package Model
 * Description:
 *
 * @Author: Lin
 * @Creat: 2023/11/20
 */
public class GameState {
    private List<Player> players;
    private int currentPlayerIndex = 0;
    private Dice dice;
    private List<Obstacle> obstacles;

    public GameState(List<Player> players, Dice dice, List<Obstacle> obstacles) {
        this.players = players;
        this.dice = dice;
        this.obstacles = obstacles;
    }

    public Player getCurrentPlayer() {
        return players.get(currentPlayerIndex);
    }

    public void nextTurn() {
        currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
    }

    public int rollDice() {
        return dice.roll();
    }

    public List<Obstacle> getObstacles() {
        return obstacles;
    }
    public void movePlayer(Player player, int diceValue) {
        int newPosition = player.getPosition() + diceValue;

        // 检查新位置是否已被其他玩家占据
        for (Player otherPlayer : players) {
            if (otherPlayer != player && otherPlayer.getPosition() == newPosition) {
                // 如果发现位置冲突，玩家停留在原地
                return;
            }
        }

        // 检查障碍物逻辑
        for (Obstacle obstacle : obstacles) {
            if (newPosition >= obstacle.getPosition() && player.getPosition() < obstacle.getPosition()) {
                obstacle.applyEffect(player);
                return;
            }
        }

        player.setPosition(newPosition); // 更新玩家位置
    }
}
