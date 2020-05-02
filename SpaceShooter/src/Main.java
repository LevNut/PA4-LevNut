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
 * A length converter that convert from unit to unit.
 * Users can insert the value that you want to convert,
 * and it will gives the user the converted values.
 *
 * @author Teeranut Sawanyawat 6210545491
 */
public class Main extends Application {
    BorderPane l;

    //Scene Images
    String jupiter = "Images/Jupiter.png";
    String logo = "Images/Logo.png";
    String play = "Images/play.png";
    String exit = "Images/exit.png";

    /**
     * Setup GUI
     *
     * @param stage the javafx stage to setup
     */
    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Space Shooter");
        Setting set = new Setting();
        FightScene fs = new FightScene();
        Pane root = initComponents();


        //////////// set image ////////////
        Image jup = new Image(jupiter);
        ImageView jupI = new ImageView(jup);

        Image log = new Image(logo);
        ImageView logI = new ImageView(log);
        //////////// set image ////////////

        //////////// set images button ////////////
        Image pla = new Image(play);
        ImageView plaI = new ImageView(pla);
        plaI.setPickOnBounds(true);
        plaI.setOnMouseClicked((MouseEvent e) -> {
            System.out.println("Play!");
            Stage newStage = (Stage) ((Node) e.getSource()).getScene().getWindow();
            stage.setScene(new Scene(new Pane()));
            //set.setSounds("main");
            System.out.println("Test");

            try {
                fs.start(newStage);
            } catch (Exception ex) {
                ex.printStackTrace();
            }


        });

        Image exi = new Image(exit);
        ImageView exiI = new ImageView(exi);
        exiI.setPickOnBounds(true);
        exiI.setOnMouseClicked((MouseEvent e) -> {
            System.out.println("Exit!");
            System.exit(1);
        });


        set.setImages(jupI, logI, plaI, exiI);
        //////////// set images button ////////////


        root.setPrefSize(800, 500);
        root.setStyle("-fx-background-color: BLACK;");


        l = new BorderPane();
        l.setTop(set.setMenu());
        l.setCenter(root);

        Scene scene = new Scene(l);
        stage.setScene(scene);
        stage.sizeToScene();
        stage.show();

        root.getChildren().addAll(jupI, logI, plaI, exiI);
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
     * @param args for launching
     */
    public static void main(String[] args) {
        launch(args);
    }
}
