package Model;

/**
 * ClassName GameLogic
 * Package Model
 * Description:
 *
 * @Author: Lin
 * @Creat: 2023/11/20
 */
public class GameLogic {
    private static final int STEP_SCORE = 10; // 每步的基础得分
    private static final int BONUS_SCORE = 50; // 快速完成游戏的额外奖励分数

    public void updateScore(Player player, boolean reachedEnd, long timeTaken) {
        // 基础得分
        int score = player.getPosition() * STEP_SCORE;



        player.setScore(score);
    }
}
