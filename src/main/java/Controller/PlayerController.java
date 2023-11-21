package Controller;

import Model.Player;

/**
 * ClassName PlayerController
 * Package Controller
 * Description:
 *
 * @Author: Lin
 * @Creat: 2023/11/20
 */
public class PlayerController {
    private Player player;

    public PlayerController(Player player) {
        this.player = player;
    }

    public void move(int steps) {
        player.move(steps);
        // 处理玩家移动逻辑
    }

    public void updateScore(int points) {
        player.updateScore(points);
        // 更新玩家得分
    }
}
