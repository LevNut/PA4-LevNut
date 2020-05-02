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
    private double OriginY;
    final String ufo1 = "Images/ufo1.png";
    final String redLine = "Images/redline.jpg";
    final String rocket = "Images/space_rocket.png";
    final String laser = "Images/laser.png";
    double rocketPosX = -400;
    double rocketPosY = 100;
    boolean up = false, down = false, left = false, right = false, shoot = false;
    BorderPane l;

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Space Shooter");
        FightProcess fp = new FightProcess();
        Setting set = new Setting();
        Pane root = initComponents();

        //////////// Images //////////////
        Image u1 = new Image(ufo1);
        ImageView uI1 = new ImageView(u1);

        Image u2 = new Image(ufo1);
        ImageView uI2 = new ImageView(u2);

        Image red = new Image(redLine);
        ImageView rI = new ImageView(red);

        Image roc = new Image(rocket);
        ImageView rocI = new ImageView(roc);

        Image las = new Image(laser);
        ImageView lasI = new ImageView(las);
        //////////// Images //////////////

        OriginY = fp.randomEnemy(-215, 215);

        uI1.setFitWidth(130);
        uI1.setFitHeight(80);
        uI1.setTranslateX(400);
        uI1.setTranslateY(OriginY);

        rI.setFitWidth(10);
        rI.setFitHeight(650);
        rI.setTranslateX(-60);

//        uI2.setFitWidth(10);
//        uI2.setFitHeight(10);
//        uI2.setTranslateX(-600);

        rocI.setFitWidth(130);
        rocI.setFitHeight(80);
        rocI.setTranslateX(rocketPosX);
        rocI.setTranslateY(rocketPosY);

        lasI.setFitWidth(20);
        lasI.setFitHeight(10);

        root.setPrefSize(1000, 700);
        root.setStyle("-fx-background-color: BLACK;");

        l = new BorderPane();
        l.setTop(set.setMenu());
        l.setCenter(root);

        lasI.setTranslateX(rocI.getTranslateX());
        lasI.setTranslateY(rocI.getTranslateY());

        Scene scene = new Scene(l);
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                //lasI.setTranslateX(rocI.getTranslateX());

                if (keyEvent.getCode() == KeyCode.RIGHT) right = true;
                if (keyEvent.getCode() == KeyCode.LEFT) left = true;
                if (keyEvent.getCode() == KeyCode.UP) up = true;
                if (keyEvent.getCode() == KeyCode.DOWN) down = true;
                if (keyEvent.getCode() == KeyCode.SPACE) shoot = true;
            }
        });



        scene.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                //lasI.setTranslateX(rocI.getTranslateX());

                if (keyEvent.getCode() == KeyCode.RIGHT) right = false;
                if (keyEvent.getCode() == KeyCode.LEFT) left = false;
                if (keyEvent.getCode() == KeyCode.UP) up = false;
                if (keyEvent.getCode() == KeyCode.DOWN) down = false;
                if (keyEvent.getCode() == KeyCode.SPACE) shoot = false;
            }
        });



        stage.setScene(scene);
        stage.sizeToScene();
        stage.show();

        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long l) {
                if (rocI.getTranslateX() >= -200) rocI.setTranslateX(rocketPosX);
                if (rocI.getTranslateX() <= -550) rocI.setTranslateX(rocI.getTranslateX() + 5);
                if (rocI.getTranslateY() <= -300) rocI.setTranslateY(rocI.getTranslateY() + 5);
                if (rocI.getTranslateY() >= 300) rocI.setTranslateY(rocI.getTranslateY() - 5);

                if (right) rocI.setTranslateX(rocI.getTranslateX() + 5);
                if (left) rocI.setTranslateX(rocI.getTranslateX() - 5);
                if (up) rocI.setTranslateY(rocI.getTranslateY() - 5);
                if (down) rocI.setTranslateY(rocI.getTranslateY() + 5);
                if (shoot) {
                    lasI.setTranslateX(lasI.getTranslateX() + 5);
                }

                fp.randomEnemyMovement(uI1);
            }
        };

        timer.start();


        root.getChildren().addAll(uI1, rI, lasI, rocI);

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
}
