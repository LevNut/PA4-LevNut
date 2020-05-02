import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.image.ImageView;
import javafx.scene.media.AudioClip;

import java.net.URL;

public class Setting {
    URL path;

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
        Menu menu = new Menu("Menu");

        MenuItem high_score = new MenuItem("High Score");
        high_score.setOnAction(e -> {
            System.out.println("YEAH");
        });



        MenuItem exitmenu= new MenuItem("Exit");
        exitmenu.setOnAction(e -> {
            System.exit(1);
        });

        menu.getItems().addAll(high_score, new SeparatorMenuItem(), exitmenu);

        MenuBar bar = new MenuBar();
        bar.getMenus().addAll(menu);

        return bar;
    }

    public void setSounds(String commands){
        if (commands.equals("main")) path = getClass().getResource("Main_theme.wav");
        if (commands.equals("intro")) path = getClass().getResource("Main_theme.wav");

        AudioClip main = new AudioClip(path.toString());
        main.play();

    }
}
