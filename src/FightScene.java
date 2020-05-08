import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class FightScene extends Application {
    // Origin point of X and Y
    double OriginX = 400;
    private double OriginY;
    static int score;

    ////////////////// Images //////////////////
    final String ufo1 = "Images/ufo.gif";
    final String redLine = "Images/redline.jpg";
    final String rocket = "Images/space_rocket.png";
    final String heart1 = "Images/h1.png";
    final String heart2 = "Images/h2.png";
    final String heart3 = "Images/h3.png";
    final String laser = "Images/laser.png";
    ////////////////// Images //////////////////

    double rocketPosX = -400;
    double rocketPosY = 100;

    boolean up = false, down = false, left = false, right = false;

    BorderPane l;
    int lives = 3;

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Space Shooter");
        score = 1_000_000;

        FightProcess fp = new FightProcess();
        Setting set = new Setting();
        Heart heart = new Heart();
        Rocket rock = new Rocket();
        RedLine redL = new RedLine();
        GameOverHandler game_over = new GameOverHandler();
        UFO ufo = new UFO();

        Pane root = initComponents();

        //////////// Set Images //////////////
        Image u1 = new Image(ufo1);
        ImageView uI1 = new ImageView(u1);

        Image red = new Image(redLine);
        ImageView rI = new ImageView(red);

        Image roc = new Image(rocket);
        ImageView rocI = new ImageView(roc);

        Image las = new Image(laser);
        ImageView lasI = new ImageView(las);

        Image h1 = new Image(heart1);
        ImageView hI1 = new ImageView(h1);

        Image h2 = new Image(heart2);
        ImageView hI2 = new ImageView(h2);

        Image h3 = new Image(heart3);
        ImageView hI3 = new ImageView(h3);

        set.setLifes(hI1, hI2, hI3);
        //////////// Set Images //////////////


        //////////////// Set Background ////////////////
        root.setPrefSize(1200, 700);
        root.setStyle("-fx-background-color: BLACK;");

        l = new BorderPane();
        l.setTop(set.setMenu());
        l.setCenter(root);
        //////////////// Set Background ////////////////

        OriginY = fp.randomEnemy(-215, 215);

        /////////////////// Set Images ///////////////////
        ufo.setUfo(uI1, OriginX, OriginY);

        redL.setRedLine(rI);

        rock.setRocket(rocI, rocketPosX, rocketPosY);

        lasI.setFitWidth(20);
        lasI.setFitHeight(10);

        lasI.setTranslateX(rocI.getTranslateX() + 100);
        lasI.setTranslateY(rocI.getTranslateY());
        /////////////////// Set Images ///////////////////

        ImageView h = new ImageView(h3);
        h.setFitWidth(50);
        h.setFitHeight(50);


        ///////////////////// Scene Setting /////////////////////
        Scene scene = new Scene(l);
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {

                if (keyEvent.getCode() == KeyCode.RIGHT) right = true;
                if (keyEvent.getCode() == KeyCode.LEFT) left = true;
                if (keyEvent.getCode() == KeyCode.UP) up = true;
                if (keyEvent.getCode() == KeyCode.DOWN) down = true;

            }
        });

        scene.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {

                if (keyEvent.getCode() == KeyCode.RIGHT) right = false;
                if (keyEvent.getCode() == KeyCode.LEFT) left = false;
                if (keyEvent.getCode() == KeyCode.UP) up = false;
                if (keyEvent.getCode() == KeyCode.DOWN) down = false;
            }
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
                if ((lasI.getTranslateX() >= OriginX) && (lasI.getTranslateY() == uI1.getTranslateY())) {
                    lives--;
                    heart.life(lasI, uI1, hI3, hI2, hI1, lives);
                }

                if (!heart.checkLive(lives)) {
                    Stage newStage = new Stage();
                    stage.setScene(new Scene(new Pane()));

                    try {
                        this.stop();
                        game_over.start(newStage);
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
                h.setTranslateX(uI1.getTranslateX() - 500);
                h.setTranslateY(uI1.getTranslateY());


            }
        };

        timer.start();
        ///////////////////// Animation Setting /////////////////////


        root.getChildren().addAll(uI1, rI, lasI, rocI, hI1, hI2, hI3, h);

    }

    private Pane initComponents() {
        FlowPane pane = new FlowPane();

        pane.setPadding(new Insets(10.0));

        pane.setHgap(10.0);
        pane.setAlignment(Pos.CENTER);

        return pane;
    }

    public double getOriginY() {
        return OriginY;
    }

    public int getScore() {
        if (score / 10_000 <= 0) score = 0;
        return score / 10_000;
    }


}
