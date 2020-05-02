
import javafx.scene.image.ImageView;

import java.util.Random;


public class FightProcess {
    Random rand = new Random();
    FightScene fs = new FightScene();
    double oY = fs.getOriginY();
    double i = 1;

    public int randomEnemy(int upY, int downY) {
        return upY + rand.nextInt(downY + 1 - upY);
    }

    public void randomEnemyMovement(ImageView ufo) {
        double rand_num = randomEnemy(-10, 10);

        if ((ufo.getTranslateY()) <= -200) ufo.setTranslateY(ufo.getTranslateY() + 1);
        if ((ufo.getTranslateY()) >= 200) ufo.setTranslateY(ufo.getTranslateY() - 1);
        else ufo.setTranslateY(ufo.getTranslateY() - rand_num);

    }

}
