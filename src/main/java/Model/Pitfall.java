package Model;

/**
 * ClassName Pitfall
 * Package Model
 * Description:
 *
 * @Author: Lin
 * @Creat: 2023/11/20
 */
public class Pitfall extends Obstacle {
    public Pitfall(int position) {
        super(position);
    }



    @Override
    public void applyEffect(Player player) {
        player.setPosition(0); // 返回起点
    }
}