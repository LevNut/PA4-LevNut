import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;

/**
 * A scene that prepared for the player who already finished the game
 * which the scene will tells the score to the user.
 *
 * @author Teeranut Sawanyawat 6210545491
 */
public class GameOverHandler extends Application {
    BorderPane l;

    //Scene Images
    final String retry = "Images/retry.png";
    final String exit = "Images/exit.png";
    Text text;

    /**
     * Setup GUI.
     *
     * @param stage the javafx stage to setup.
     */
    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Space Shooter");
        Setting set = new Setting();
        FightScene fs = new FightScene();
        Pane root = initComponents();

        // Set Score
        String res = String.valueOf(fs.getScore());
        text = new Text("Score: " + res);
        set.setScore(text);
        //////////// set image /////////

        Image ret = new Image(retry);
        ImageView retI = new ImageView(ret);

        Image exi = new Image(exit);
        ImageView exiI = new ImageView(exi);

        set.setGameOverScene(retI, exiI);
        //////////// set image ////////////

        //////////// set images button ////////////

        retI.setPickOnBounds(true);
        retI.setOnMouseClicked((MouseEvent e) -> {

            Stage newStage = (Stage) ((Node) e.getSource()).getScene().getWindow();
            stage.setScene(new Scene(new Pane()));

            try {
                fs.start(newStage);
            } catch (Exception ex) {
                ex.printStackTrace();
            }


        });

        exiI.setPickOnBounds(true);
        exiI.setOnMouseClicked((MouseEvent e) -> System.exit(1));


        //////////// set images button ////////////


        set.setScreen(stage, root);

        root.getChildren().addAll(text, retI, exiI);
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
     * Start and launch the application.
     *
     * @param args for launching.
     */
    public static void main(String[] args) {
        launch(args);
    }
}