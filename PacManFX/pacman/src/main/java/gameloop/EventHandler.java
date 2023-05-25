package gameloop;

import components.Entity;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class EventHandler {
    /**
     * Adds an event handler to the mean scene
     */
    public static void addMyEvents() {
        App.scene.addEventHandler(KeyEvent.KEY_PRESSED, (key) -> {
            Entity[] objs = App.data.getLevel().nextTo(App.data.getLevel().scaleValueX(App.data.getPacMan().getEntity().getX()),
            App.data.getLevel().scaleValueY(App.data.getPacMan().getEntity().getY()));

            if(key.getCode() == KeyCode.W && objs[0].tag() != "Wall") {
                App.data.getPacMan().setDirection('W');
            } else if(key.getCode() == KeyCode.S && objs[2].tag() != "Wall") {
                App.data.getPacMan().setDirection('S');
            } else if(key.getCode() == KeyCode.A && objs[3].tag() != "Wall") {
                App.data.getPacMan().setDirection('A');
            } else if(key.getCode() == KeyCode.D && objs[1].tag() != "Wall") {
                App.data.getPacMan().setDirection('D');
            }

            if(key.getCode() == KeyCode.B) {
                UI.displayUI();
            }

        });
    }
}
