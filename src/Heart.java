import javafx.scene.image.ImageView;

public class Heart {
    private boolean gameOver = true;

    public void life(ImageView h3, ImageView h2, ImageView h1, int lives) {
        if (lives == 2) h3.setVisible(false);
        if (lives == 1) h2.setVisible(false);
        if (lives == 0) h1.setVisible(false);

    }

    public boolean checkLive(int lives) {
        if (lives == 0) gameOver = false;
        return gameOver;
    }


}
