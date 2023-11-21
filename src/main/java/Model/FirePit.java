package Model;

/**
 * ClassName FirePit
 * Package Model
 * Description:
 *
 * @Author: Lin
 * @Creat: 2023/11/20
 */
public class FirePit extends Obstacle{
    private static final int PENALTY_POINTS = 10;

    public FirePit(int position) {
        super(position);
    }

    @Override
    public void applyEffect(Player player) {
        player.setScore(player.getScore() - PENALTY_POINTS);
    }
}
