import java.util.Random;

/**
 * FightProcess have only one method called randomEnemy
 * which it will random the enemy movement.
 *
 * @author Teeranut Sawanyawat 6210545491
 */
public class FightProcess {
    final Random rand = new Random();

    /**
     * Random enemy movement by giving int upY and downY.
     *
     * @param up   starting number to random.
     * @param down ending number to random.
     * @return the number that is random between the start and end number.
     */
    public int randomEnemy(int up, int down) {
        return up + rand.nextInt(down + 1 - up);
    }


}
