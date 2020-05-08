import javafx.scene.image.ImageView;

public class UFO {
    final FightProcess fp = new FightProcess();
    final Setting set = new Setting();

    public void setUfo(ImageView uI1, double originX, double originY) {
        uI1.setFitWidth(130);
        uI1.setFitHeight(100);
        uI1.setTranslateX(originX);
        uI1.setTranslateY(originY);
    }


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
