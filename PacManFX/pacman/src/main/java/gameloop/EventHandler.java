package gameloop;

import components.Entity;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class EventHandler {
    public static void addMyEvents() {
        App.scene.addEventHandler(KeyEvent.KEY_PRESSED, (key) -> {
            Entity[] objs = App.level.nextTo(App.level.scaleValueX(App.player.getX()),
            App.level.scaleValueY(App.player.getY()));

            if(key.getCode() == KeyCode.W && objs[0].tag() != "Wall") {
                App.dia = 'W';
            } else if(key.getCode() == KeyCode.S && objs[2].tag() != "Wall") {
                App.dia = 'S';
            } else if(key.getCode() == KeyCode.A && objs[3].tag() != "Wall") {
                App.dia = 'A';
            } else if(key.getCode() == KeyCode.D && objs[1].tag() != "Wall") {
                App.dia = 'D';
            }

            if(key.getCode() == KeyCode.B) {
                UI.displayUI();
            }

        });
    }
}
