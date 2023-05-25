package gameloop;

import javafx.animation.AnimationTimer;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
 
public class App extends Application {

    public static int size = 16;
    public static int offsetTop = 50;
    public static int offsetBottom = 50;

    public static LoadGameData data;

    public static Scene scene;
    public static Group root;
    public static AnimationTimer update;

    public static String gameState = "normal";
    public static int points = 0;
    public static int lives = 3;

    public static Label pointLabel = new Label(""+points+" Points");
    public static Label livesLabel = new Label(""+lives+" Lives");
    public static Label stateLabel = new Label(gameState);

    @Override
    public void start(Stage primaryStage) {
        root = new Group();
        data = new LoadGameData(size);
        data.render();
        
        root.getChildren().add(pointLabel);
        root.getChildren().add(livesLabel);
        root.getChildren().add(stateLabel);

        scene = new Scene(App.root, size*data.getLevel().getLevel()[0].length,
        size*data.getLevel().getLevel().length+App.offsetTop+App.offsetBottom, Color.BLACK);

        UI.load();
        update = new Updater();

        EventHandler.addMyEvents();
        transfromUI();

        update.start();
        primaryStage.setTitle("Pac-Man");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /** Sets the Font, Position and Color of the labels used
     * 
     */
    public static void transfromUI () {
        pointLabel.setFont(new Font("Arial", 30));
        pointLabel.setTranslateX((scene.getWidth()/2));
        pointLabel.setTranslateY(0);
        pointLabel.setTextFill(Color.WHITE);

        livesLabel.setTranslateX(0);
        livesLabel.setTranslateY(offsetTop/2);
        livesLabel.setTextFill(Color.WHITE);
        livesLabel.setFont(new Font("Arial", 20));

        stateLabel.setTranslateX((scene.getWidth()/2)-(stateLabel.getLayoutX()));
        stateLabel.setTranslateY(scene.getHeight()-offsetBottom);
        stateLabel.setTextFill(Color.WHITE);
        stateLabel.setFont(new Font("Arial", 30));
    }

    public static void main(String[] args) {
        launch(args);
    }
}