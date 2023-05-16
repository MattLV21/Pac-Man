package gameloop;

import components.Entity;
import javafx.scene.paint.Color;

public class Collision {
    public static void onCollisionEnter(Entity e, Entity o) {
        if(e.tag() == "Player") {
            if(o.tag() == "Coin") {
                o.setTag("");
                o.getSprite().setColor(Color.WHITE);
                App.points += 10;
                boolean found = false;
                for(int i = 0; i < App.level.getLevel().length; i++) {
                    for(int j = 0; j < App.level.getLevel()[j].length; j++) {
                        if (App.level.getLevel()[i][j].tag() == "Coin") {
                            found = true;
                            break;
                        }
                    }
                }
                if(!found) {
                    App.gameState = "finished";
                    UI.displayUI();
                }
            }
            if(o.tag() == "Power") {
                App.gameState = "power";
                App.points += 100;
            }
            if(o.tag() == "Ghost") {
                if(App.gameState == "normal") {
                    App.lives--;
                    App.gameState = "immortal";
                }
                if(App.gameState == "power") {
                    App.ghosts.remove(o);
                    App.points += 1000;
                }
            }
        }
    }
}
