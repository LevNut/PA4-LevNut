import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;

/**
 * An application that run all files to play Space Shooter.
 *
 * @author Teeranut Sawanyawat 6210545491.
 */
public class GameApplication extends Application {
    BorderPane l;

    //Scene Images
    final String jupiter = "Images/Jupiter.png";
    final String logo = "Images/Logo.png";
    final String play = "Images/play.png";
    final String exit = "Images/exit.png";

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


        //////////// set image ////////////
        ImageView jupI = getImageView(jupiter);

        ImageView logI = getImageView(logo);

        ImageView plaI = getImageView(play);

        //////////// set image ////////////

        //////////// set images button ////////////
        plaI.setPickOnBounds(true);
        plaI.setOnMouseClicked((MouseEvent e) -> {
            Stage newStage = (Stage) ((Node) e.getSource()).getScene().getWindow();
            stage.setScene(new Scene(new Pane()));

            // BG soundtrack
            set.setSounds("main");

            try {
                fs.start(newStage);
            } catch (Exception ex) {
                ex.printStackTrace();
            }


        });

        ImageView exiI = getImageView(exit);
        exiI.setPickOnBounds(true);
        exiI.setOnMouseClicked((MouseEvent e) -> System.exit(1));


        set.setImages(jupI, logI, plaI, exiI);
        //////////// set images button ////////////

        set.setScreen(stage, root);

        root.getChildren().addAll(jupI, logI, plaI, exiI);
    }

    private ImageView getImageView(String img) {
        Image imgReal = new Image(img);
        return new ImageView(imgReal);
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
