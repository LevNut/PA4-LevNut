import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.ImageView;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.net.URL;

public class Setting {
    URL path;
    static boolean isHard = false;

    public void setImages(ImageView jupI, ImageView logI, ImageView plaI, ImageView exiI) {
        jupI.setFitHeight(400);
        jupI.setFitWidth(400);
        jupI.setTranslateX(300);
        jupI.setTranslateY(300);

        logI.setFitHeight(0);
        logI.setFitWidth(600);
        logI.setTranslateX(0);
        logI.setTranslateY(-350);

        plaI.setFitHeight(100);
        plaI.setFitWidth(200);
        plaI.setTranslateX(80);
        plaI.setTranslateY(-300);

        exiI.setFitHeight(62);
        exiI.setFitWidth(160);
        exiI.setTranslateX(-110);
        exiI.setTranslateY(-200);
    }

    public MenuBar setMenu() {
        Menu menu = new Menu("Difficulty Levels");

        MenuItem normal = new MenuItem("Normal");
        normal.setOnAction(e -> {
            isHard = false;
        });


        MenuItem hard = new MenuItem("God");
        hard.setOnAction(e -> {
            isHard = true;
        });

        menu.getItems().addAll(normal, hard);

        MenuBar bar = new MenuBar();
        bar.getMenus().addAll(menu);

        return bar;
    }

    public void setLifes(ImageView h1, ImageView h2, ImageView h3) {
        h1.setFitHeight(50);
        h1.setFitWidth(50);
        h1.setTranslateX(300);
        h1.setTranslateY(-300);

        h2.setFitHeight(50);
        h2.setFitWidth(50);
        h2.setTranslateX(200);
        h2.setTranslateY(-300);

        h3.setFitHeight(50);
        h3.setFitWidth(50);
        h3.setTranslateX(100);
        h3.setTranslateY(-300);
    }

    public void setSounds(String commands) {
        if (commands.equals("main")) path = getClass().getResource("Sounds/Main_theme.wav");

        AudioClip main = new AudioClip(path.toString());

        if (!main.isPlaying()) main.play();

        main.play();



    }


    public void setBorder(ImageView rocI, double rocketPosX) {
        if (rocI.getTranslateX() >= -200) rocI.setTranslateX(rocketPosX);
        if (rocI.getTranslateX() <= -550) rocI.setTranslateX(rocI.getTranslateX() + 5);
        if (rocI.getTranslateY() <= -300) rocI.setTranslateY(rocI.getTranslateY() + 5);
        if (rocI.getTranslateY() >= 300) rocI.setTranslateY(rocI.getTranslateY() - 5);
    }

    public void setGameOverScene(ImageView retry, ImageView exit) {

        retry.setFitHeight(62);
        retry.setFitWidth(160);
        retry.setTranslateX(-130);
        retry.setTranslateY(52);

        exit.setFitHeight(62);
        exit.setFitWidth(160);
        exit.setTranslateX(-40);
        exit.setTranslateY(50);

    }

    public void setScore(Text text) {
        text.setFill(Color.YELLOW);
        text.setTranslateX(180);
        text.setTranslateY(-50);
        text.setFont(Font.font ("Impact", 40));

    }

    public boolean getIsHard() {
        return isHard;
    }
}
