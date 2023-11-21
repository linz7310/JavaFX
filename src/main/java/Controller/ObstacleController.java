package Controller;

import Model.Obstacle;
import Model.Player;

import java.util.List;

/**
 * ClassName ObstacleController
 * Package Controller
 * Description:
 *
 * @Author: Lin
 * @Creat: 2023/11/20
 */
public class ObstacleController {
    private List<Obstacle> obstacles;

    public ObstacleController(List<Obstacle> obstacles) {
        this.obstacles = obstacles;
    }

    public void applyObstacleEffect(Player player, int playerPosition) {
        for (Obstacle obstacle : obstacles) {
            if (obstacle.getPosition() == playerPosition) {
                obstacle.applyEffect(player);
                break;
            }
        }
        // 应用障碍物的效果
    }
}
