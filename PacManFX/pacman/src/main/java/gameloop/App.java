package gameloop;

import java.util.ArrayList;

import components.Entity;
import components.Rec;
import javafx.animation.AnimationTimer;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import map.levelHandler;
 
public class App extends Application {

    public static int size = 16;
    public static int offsetTop = 50;
    public static int offsetBottom = 50;
    public static levelHandler level;

    public static char dia = ' ';
    public static Entity player = new Entity(size, size+offsetTop);
    public static Entity ghost1 = new Entity(0, 150+offsetTop);

    public static ArrayList<Entity> ghosts = new ArrayList<>();

    public static Scene scene;
    public static AnimationTimer update;

    public static String gameState = "normal";
    public static int points = 0;
    public static int lives = 3;

    public static Label pointLabel = new Label(""+points+" Points");
    public static Label livesLabel = new Label(""+lives+" Lives");
    public static Label stateLabel = new Label(gameState);

    @Override
    public void start(Stage primaryStage) {
        player.setSprite(new Rec(player, size));
        player.setTag("Player");

        ghost1.setSprite(new Rec(ghost1, size));
        ghost1.setTag("Player");

        ghosts.add(ghost1);

        level = new levelHandler(size);
        level.fillLevel();
        
        Group root = new Group();

        for(int i = 0; i < level.getLevel().length; i++) {
            for(int j = 0; j < level.getLevel()[j].length; j++) {
                root.getChildren().add(level.getLevel()[i][j].render());
            }
        }
        root.getChildren().add(player.render());
        // ghosts.add(ghost);
        // root.getChildren().add(ghost);
        
        root.getChildren().add(pointLabel);
        root.getChildren().add(livesLabel);
        root.getChildren().add(stateLabel);


        update = new TimerMethod();
        
        scene = new Scene(root, size*level.getLevel()[0].length,
        size*level.getLevel().length+offsetTop+offsetBottom, Color.BLACK);

        EventHandler.addMyEvents();
        pointLabel.setTranslateX((scene.getWidth()/2)-(pointLabel.getWidth()));
        pointLabel.setTranslateY(0);
        pointLabel.setTextFill(Color.WHITE);
        pointLabel.setFont(new Font("Arial", 30));
        
        livesLabel.setTranslateX(0);
        livesLabel.setTranslateY(offsetTop/2);
        livesLabel.setTextFill(Color.WHITE);
        livesLabel.setFont(new Font("Arial", 20));

        stateLabel.setTranslateX((scene.getWidth()/2)-(stateLabel.getLayoutX()));
        stateLabel.setTranslateY(scene.getHeight()-offsetBottom);
        stateLabel.setTextFill(Color.WHITE);
        stateLabel.setFont(new Font("Arial", 30));

        update.start();
        primaryStage.setTitle("Pac-Man");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}