
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.Random;


public class FightProcess {
    Random rand = new Random();

    public int randomEnemy(int upY, int downY) {
        return upY + rand.nextInt(downY + 1 - upY);
    }



}
