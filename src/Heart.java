import javafx.scene.image.ImageView;

/**
 * A class that can check if lives of the enemy and setting the life picture disappear.
 *
 * @author Teeranut Sawanyawat 6210545491.
 */
public class Heart {
    private boolean gameOver = true;

    /**
     * Decrease the lives by the amount of input integer "ives."
     *
     * @param h3 ImageView of heart.
     * @param h2 ImageView of heart.
     * @param h1 ImageView of heart.
     * @param lives a number of lives.
     */
    public void life(ImageView h3, ImageView h2, ImageView h1, int lives) {
        if (lives == 2) h3.setVisible(false);
        if (lives == 1) h2.setVisible(false);
        if (lives == 0) h1.setVisible(false);

    }

    /**
     * Checking live.
     *
     * @param lives a number of lives.
     * @return gameOver a boolean of life.
     */
    public boolean checkLive(int lives) {
        if (lives == 0) gameOver = false;
        return gameOver;
    }


}
