import java.util.Random;


public class FightProcess {
    final Random rand = new Random();

    public int randomEnemy(int upY, int downY) {
        return upY + rand.nextInt(downY + 1 - upY);
    }



}
