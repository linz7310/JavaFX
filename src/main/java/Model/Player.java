package Model;

import javafx.scene.effect.Light;

/**
 * ClassName Player
 * Package Model
 * Description:
 *
 * @Author: Lin
 * @Creat: 2023/11/20
 */
public class Player {
    private String name;
    private int position = 0; // 玩家在游戏板上的位置
    private int score = 0; // 玩家的得分
    private boolean paused = false; // 是否暂停行动

    public Player(String name) {
        this.name = name;
    }

    // 获取玩家名称
    public String getName() {
        return name;
    }

    // 获取玩家位置
    public int getPosition() {
        return position;
    }

    // 设置玩家位置
    public void setPosition(int position) {
        this.position = position;
    }

    // 获取玩家得分
    public int getScore() {
        return score;
    }

    // 设置玩家得分
    public void setScore(int score) {
        this.score = score;
    }

    // 玩家是否暂停
    public boolean isPaused() {
        return paused;
    }

    // 设置玩家的暂停状态
    public void setPaused(boolean paused) {
        this.paused = paused;
    }

    // 玩家移动方法
    public void move(int steps) {
        this.position += steps;
    }

    // 更新玩家分数
    public void updateScore(int points) {
        this.score += points;
    }

}
