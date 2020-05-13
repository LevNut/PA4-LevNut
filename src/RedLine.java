import javafx.scene.image.ImageView;

/**
 * Setting RedLine which is the line that the player can't move toward it.
 *
 * @author Teeranut Sawanyawat 6210545491.
 */
public class RedLine {

    /**
     * Setting red line.
     *
     * @param rI ImageView of red line.
     */
    public void setRedLine(ImageView rI) {
        rI.setFitWidth(10);
        rI.setFitHeight(650);
        rI.setTranslateX(-60);
    }
}
