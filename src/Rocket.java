import javafx.scene.image.ImageView;

public class Rocket {

    public void setRocket(ImageView rocI, double rocketPosX, double rocketPosY) {
        rocI.setFitWidth(130);
        rocI.setFitHeight(80);
        rocI.setTranslateX(rocketPosX);
        rocI.setTranslateY(rocketPosY);
    }

    public void right(ImageView rocI) {rocI.setTranslateX(rocI.getTranslateX() + 5);}

    public void left(ImageView rocI) {rocI.setTranslateX(rocI.getTranslateX() - 5);}

    public void up(ImageView rocI) {rocI.setTranslateY(rocI.getTranslateY() - 5);}

    public void down(ImageView rocI) {rocI.setTranslateY(rocI.getTranslateY() + 5);}

    public void laser(ImageView lasI) {
        lasI.setTranslateX(lasI.getTranslateX() + 20);

    }


}
