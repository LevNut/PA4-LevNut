import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * The process of fighting scene in Space Shooter.
 *
 * @author Teeranut Sawanyawat 6210545491.
 */
public class FightScene extends Application {
    // Origin point of X and Y
    final double originX = 400;
    static int score;

    ////////////////// Images //////////////////
    final String ufo1 = "Images/ufo.gif";
    final String redLine = "Images/redLine.jpg";
    final String rocket = "Images/spaceRocket.png";
    final String heart1 = "Images/h1.png";
    final String heart2 = "Images/h2.png";
    final String heart3 = "Images/h3.png";
    final String alien = "Images/alien.png";
    final String laser = "Images/laser.png";
    ////////////////// Images //////////////////

    final double rocketPosX = -400;
    final double rocketPosY = 100;

    boolean up = false, down = false, left = false, right = false;

    BorderPane l;
    int lives = 3;

    /**
     * Setup GUI.
     *
     * @param stage the javafx stage to setup.
     */
    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Space Shooter");
        score = 1_000_000;

        FightProcess fp = new FightProcess();
        Setting set = new Setting();
        Heart heart = new Heart();
        Rocket rock = new Rocket();
        RedLine redL = new RedLine();
        GameOverHandler gameOverHandler = new GameOverHandler();
        UFO ufo = new UFO();

        Pane root = initComponents();

        //////////// Set Images //////////////
        ImageView uI1 = getImageView(ufo1);

        ImageView rI = getImageView(redLine);

        ImageView rocI = getImageView(rocket);

        ImageView lasI = getImageView(laser);

        ImageView hI1 = getImageView(heart1);

        ImageView hI2 = getImageView(heart2);

        ImageView hI3 = getImageView(heart3);

        set.setLives(hI1, hI2, hI3);
        //////////// Set Images //////////////


        //////////////// Set Background ////////////////
        root.setPrefSize(1200, 700);
        root.setStyle("-fx-background-color: BLACK;");

        l = new BorderPane();
        l.setTop(set.setMenu());
        l.setCenter(root);
        //////////////// Set Background ////////////////

        double originY = fp.randomEnemy(-215, 215);

        /////////////////// Set Images ///////////////////
        ufo.setUfo(uI1, originX, originY);

        redL.setRedLine(rI);

        rock.setRocket(rocI, rocketPosX, rocketPosY);

        lasI.setFitWidth(20);
        lasI.setFitHeight(10);

        lasI.setTranslateX(rocI.getTranslateX() + 100);
        lasI.setTranslateY(rocI.getTranslateY());
        /////////////////// Set Images ///////////////////

        ImageView core = new ImageView(alien);
        core.setFitWidth(30);
        core.setFitHeight(30);


        ///////////////////// Scene Setting /////////////////////
        Scene scene = new Scene(l);
        scene.setOnKeyPressed(keyEvent -> {

            if (keyEvent.getCode() == KeyCode.RIGHT) right = true;
            if (keyEvent.getCode() == KeyCode.LEFT) left = true;
            if (keyEvent.getCode() == KeyCode.UP) up = true;
            if (keyEvent.getCode() == KeyCode.DOWN) down = true;

        });

        scene.setOnKeyReleased(keyEvent -> {

            if (keyEvent.getCode() == KeyCode.RIGHT) right = false;
            if (keyEvent.getCode() == KeyCode.LEFT) left = false;
            if (keyEvent.getCode() == KeyCode.UP) up = false;
            if (keyEvent.getCode() == KeyCode.DOWN) down = false;
        });

        stage.setScene(scene);
        stage.sizeToScene();
        stage.show();
        ///////////////////// Scene Setting /////////////////////

        ///////////////////// Animation Setting /////////////////////
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long l) {
                score = score - 100;

                if (lasI.getTranslateX() >= 600) {
                    lasI.setTranslateX(rocI.getTranslateX() + 50);
                    lasI.setTranslateY(rocI.getTranslateY());
                }

                //Lives
                if ((lasI.getTranslateX() >= originX) && (lasI.getTranslateY() == uI1.getTranslateY())) {
                    lives--;
                    heart.life(hI3, hI2, hI1, lives);
                }

                if (!heart.checkLive(lives)) {
                    Stage newStage = new Stage();
                    stage.setScene(new Scene(new Pane()));

                    try {
                        this.stop();
                        gameOverHandler.start(newStage);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }

                // Set Border
                set.setBorder(rocI, rocketPosX);

                // Rocket Controller
                if (right) rock.right(rocI);
                if (left) rock.left(rocI);
                if (up) rock.up(rocI);
                if (down) rock.down(rocI);


                rock.laser(lasI);


                ufo.randomEnemyMovement(uI1);
                core.setTranslateX(uI1.getTranslateX() - 460);
                core.setTranslateY(uI1.getTranslateY());


            }
        };

        timer.start();
        ///////////////////// Animation Setting /////////////////////


        root.getChildren().addAll(uI1, rI, lasI, rocI, hI1, hI2, hI3, core);

    }

    /**
     * Create ImageView.
     *
     * @param img source of picture.
     * @return ImageView of picture.
     */
    private ImageView getImageView(String img) {
        Image u1 = new Image(img);
        return new ImageView(u1);
    }

    /**
     * Adding and setting up the components of stages.
     *
     * @return pane the component and layout for scene.
     */
    private Pane initComponents() {
        FlowPane pane = new FlowPane();

        pane.setPadding(new Insets(10.0));

        pane.setHgap(10.0);
        pane.setAlignment(Pos.CENTER);

        return pane;
    }

    /**
     * Getting the score.
     *
     * @return score/10_000 for easy understanding amount.
     */
    public int getScore() {
        if (score / 10_000 <= 0) score = 0;
        return score / 10_000;
    }


}
