import javafx.scene.image.ImageView;

public class UFO {
    FightProcess fp = new FightProcess();
    Setting set = new Setting();

    public void setUfo(ImageView uI1, double OriginX, double OriginY) {
        uI1.setFitWidth(130);
        uI1.setFitHeight(100);
        uI1.setTranslateX(OriginX);
        uI1.setTranslateY(OriginY);
    }


    public void randomEnemyMovement(ImageView ufo) {
        double rand_num = fp.randomEnemy(-10, 10);

        if (set.getIsHard()) {
            rand_num = fp.randomEnemy(-100, 100);
        }

        if ((ufo.getTranslateY()) <= -200) ufo.setTranslateY(ufo.getTranslateY() + 1);
        if ((ufo.getTranslateY()) >= 200) ufo.setTranslateY(ufo.getTranslateY() - 1);
        else ufo.setTranslateY(ufo.getTranslateY() - rand_num);

    }

}
