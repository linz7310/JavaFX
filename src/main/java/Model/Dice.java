package Model;

import java.util.Random;

/**
 * ClassName Dice
 * Package Model
 * Description:
 *
 * @Author: Lin
 * @Creat: 2023/11/20
 */
public class Dice {
    private int diceValue;

        private Random random = new Random();

        public int roll() {

            diceValue=1 + random.nextInt(9); // 生成1到9之间的随机数
            return diceValue;
        }

    public int getDiceValve() {
        return diceValue;
    }

    public void setDiceValve(int diceValve) {
        this.diceValue = diceValve;
    }
}
