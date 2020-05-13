import javafx.scene.image.ImageView;

/**
 * The enemy class that used to set and create the enemy movement.
 *
 * @author Teeranut Sawanyawat 6210545491.
 *
 */
public class UFO {
    final FightProcess fp = new FightProcess();
    final Setting set = new Setting();

    /**
     * Setting up the enemy(UFO).
     *
     * @param uI1 ImageView of UFO.
     * @param originX the x coordinates.
     * @param originY the y coordinates.
     */
    public void setUfo(ImageView uI1, double originX, double originY) {
        uI1.setFitWidth(130);
        uI1.setFitHeight(100);
        uI1.setTranslateX(originX);
        uI1.setTranslateY(originY);
    }

    /**
     * Random Enemy movement due to the random number in FightProcess.
     *
     * @param ufo ImageView of the enemy.
     */
    public void randomEnemyMovement(ImageView ufo) {
        double randNum = fp.randomEnemy(-10, 10);

        if (set.getIsHard()) {
            randNum = fp.randomEnemy(-100, 100);
        }

        if ((ufo.getTranslateY()) <= -200) ufo.setTranslateY(ufo.getTranslateY() + 1);
        if ((ufo.getTranslateY()) >= 200) ufo.setTranslateY(ufo.getTranslateY() - 1);
        else ufo.setTranslateY(ufo.getTranslateY() - randNum);

    }

}
