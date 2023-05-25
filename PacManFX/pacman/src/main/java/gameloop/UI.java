package gameloop;

import components.Entity;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class UI {
    private static Button startButton = new Button();
    private static Label startLabel = new Label();
    private static Entity background = new Entity(0, 0);
    
    protected static boolean paused = false;

    /**
     * Creates and loads pause/finshed UI
     */
    public static void load() {
        startButton.setText("Press Start to play!");
        startButton.setOnAction(e -> {
            if(App.lives <= 0) {
                App.data.reload();
            } else {
                App.update.start();
                hideUI();
            }
        });
        startButton.setTranslateX(App.scene.getWidth()/2);
        startButton.setTranslateY(App.scene.getHeight()/1.5);
        startButton.setFont(new Font("Arial", 20));

        startLabel.setFont(new Font("Arial", 50));
        startLabel.setTranslateX(App.scene.getWidth()/2);
        startLabel.setTranslateY(App.scene.getHeight()/2);

        background.getSprite().setWidth(App.scene.getWidth());
        background.getSprite().setHeight(App.scene.getHeight());
        background.getSprite().setColor(Color.WHITE);
        background.getSprite().setOpacity(0.5);

        App.root.getChildren().add(background.render());
        App.root.getChildren().add(startButton);
        App.root.getChildren().add(startLabel);

        hideUI();
    }

    /** Get the UI Button
     * @return Button
     */
    public static Button getStartButton() {
        return startButton;
    }
    /** Get the UI Label
     * @return Label
     */
    public static Label getstartLabel() {
        return startLabel;
    }


    /**
     * Sets all UI objects to visable
     * Updates startLabel text
     */
    public static void displayUI() {
        paused = true;
        startLabel.setText(App.pointLabel.getText());

        startButton.setVisible(true);
        startLabel.setVisible(true);
        background.getSprite().setVisible(true);
    }

    /**
     * Sets all UI objects to not visable
     */
    public static void hideUI() {
        paused = false;
        startButton.setVisible(false);
        startLabel.setVisible(false);
        background.getSprite().setVisible(false);
    }
}
