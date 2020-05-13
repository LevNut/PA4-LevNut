import javafx.scene.image.ImageView;

/**
 * A Rocket class that provides the movement of player and laser also setting the rocket position.
 *
 * @author Teeranut Sawanyawat 6210545491.
 */
public class Rocket {

    public void setRocket(ImageView rocI, double rocketPosX, double rocketPosY) {
        rocI.setFitWidth(130);
        rocI.setFitHeight(80);
        rocI.setTranslateX(rocketPosX);
        rocI.setTranslateY(rocketPosY);
    }

    /**
     * Moving the rocket to the right.
     *
     * @param rocI ImageView of Rocket.
     */
    public void right(ImageView rocI) {rocI.setTranslateX(rocI.getTranslateX() + 5);}

    /**
     * Moving the rocket to the left.
     *
     * @param rocI ImageView of Rocket.
     */
    public void left(ImageView rocI) {rocI.setTranslateX(rocI.getTranslateX() - 5);}

    /**
     * Moving up the rocket.
     *
     * @param rocI ImageView of Rocket.
     */
    public void up(ImageView rocI) {rocI.setTranslateY(rocI.getTranslateY() - 5);}

    /**
     * Moving down the rocket.
     *
     * @param rocI ImageView of Rocket.
     */
    public void down(ImageView rocI) {rocI.setTranslateY(rocI.getTranslateY() + 5);}

    /**
     * Moving the laser to the right.
     *
     * @param lasI ImageView of Laser.
     */
    public void laser(ImageView lasI) {
        lasI.setTranslateX(lasI.getTranslateX() + 20);

    }


}
