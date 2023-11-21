package Model;

/**
 * ClassName Obstacle
 * Package Model
 * Description:
 *
 * @Author: Lin
 * @Creat: 2023/11/20
 */
public abstract class Obstacle {
    private int position;


    public Obstacle(int position) {
        this.position = position;
    }

    public int getPosition() {
        return position;
    }

    public abstract void applyEffect(Player player);

}
