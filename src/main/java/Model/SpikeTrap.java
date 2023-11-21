package Model;

/**
 * ClassName SpikeTrap
 * Package Model
 * Description:
 *
 * @Author: Lin
 * @Creat: 2023/11/20
 */
public class SpikeTrap extends Obstacle{
    private static final int SIZE = 3;
    public SpikeTrap(int position) {
        super(position);
    }

    @Override
    public void applyEffect(Player player) {
        Dice dice = new Dice();
        int diceValue = dice.getDiceValve();
//        int diceValue = dice.roll();

        // 玩家在尖刺坑前且骰子点数不足以跳过
        if (player.getPosition() == this.getPosition() && diceValue <= SIZE) {
            // 可以设置玩家回到起点或应用其他惩罚
            player.setPosition(0);
        }
    }


}
