import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.net.URL;

/**
 * Setting game properties.
 *
 * @author Teeranut Sawanyawat 6210545491.
 */
public class Setting {
    URL path;
    static boolean isHard = false;

    /**
     * Setting Images of GameApplication screen.
     *
     * @param jupI ImageView of jupiter.
     * @param logI ImageView of logo.
     * @param plaI ImageView of play button.
     * @param exiI ImageView of exit button.
     */
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

    /**
     * Adding MenuBar.
     *
     * @return MenuBar a menu bar of this application.
     */
    public MenuBar setMenu() {
        Menu menu = new Menu("Difficulty Levels");

        MenuItem normal = new MenuItem("Normal");
        normal.setOnAction(e -> isHard = false);


        MenuItem hard = new MenuItem("God");
        hard.setOnAction(e -> isHard = true);

        menu.getItems().addAll(normal, hard);

        MenuBar bar = new MenuBar();
        bar.getMenus().addAll(menu);

        return bar;
    }

    /**
     * Setting Lives.
     *
     * @param h1 ImageView of heart.
     * @param h2 ImageView of heart.
     * @param h3 ImageView of heart.
     */
    public void setLives(ImageView h1, ImageView h2, ImageView h3) {
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

    /**
     * Setting Sounds.
     *
     * @param commands the input command.
     */
    public void setSounds(String commands) {
        if (commands.equals("main")) path = getClass().getResource("Sounds/Main_theme.wav");

        AudioClip main = new AudioClip(path.toString());

        if (!main.isPlaying()) main.play();

        main.play();


    }

    /**
     * Setting Border.
     *
     * @param rocI ImageView of rocket.
     * @param rocketPosX the coordinate x position of rocket.
     */
    public void setBorder(ImageView rocI, double rocketPosX) {
        if (rocI.getTranslateX() >= -200) rocI.setTranslateX(rocketPosX);
        if (rocI.getTranslateX() <= -550) rocI.setTranslateX(rocI.getTranslateX() + 5);
        if (rocI.getTranslateY() <= -300) rocI.setTranslateY(rocI.getTranslateY() + 5);
        if (rocI.getTranslateY() >= 300) rocI.setTranslateY(rocI.getTranslateY() - 5);
    }

    /**
     * Setting GameOver screen.
     *
     * @param retry ImageView of retry button.
     * @param exit ImageView of exit button.
     */
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

    /**
     * Setting the score of player.
     *
     * @param text the javafx text.
     */
    public void setScore(Text text) {
        text.setFill(Color.YELLOW);
        text.setTranslateX(180);
        text.setTranslateY(-50);
        text.setFont(Font.font("Impact", 40));

    }

    /**
     * Get the isHard.
     *
     * @return isHard a boolean of difficulty levels.
     */
    public boolean getIsHard() {
        return isHard;
    }

    /**
     * Setting the screen.
     *
     * @param stage Stage of javafx.
     * @param root Pane of javafx.
     */
    public void setScreen(Stage stage, Pane root) {
        root.setPrefSize(800, 500);
        root.setStyle("-fx-background-color: BLACK;");


        BorderPane l = new BorderPane();
        l.setTop(this.setMenu());
        l.setCenter(root);

        Scene scene = new Scene(l);
        stage.setScene(scene);
        stage.sizeToScene();
        stage.show();
    }

}
