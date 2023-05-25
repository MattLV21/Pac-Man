package gameloop;

import components.Entity;
import javafx.scene.paint.Color;

public class Collision {
    /** Called when two Entitys collid
     * Executes code depending on the two Entitys
     * @param e Entity
     * @param o Entity
     */
    public static void onCollisionEnter(Entity e, Entity o) {
        if(e.tag() == "Player") {
            if(o.tag() == "Coin") {
                o.setTag("Used_Coin");
                o.getSprite().setColor(Color.WHITE);
                App.points += 10;
                boolean found = false;
                for(int i = 0; i < App.data.getLevel().getLevel().length; i++) {
                    for(int j = 0; j < App.data.getLevel().getLevel()[j].length; j++) {
                        if (App.data.getLevel().getLevel()[i][j].tag() == "Coin") {
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
                o.setTag("Used_Power");
                o.getSprite().setColor(Color.WHITE);
                App.gameState = "power";
                Updater.addStateDelay();
                App.points += 100;
            }
            if(o.tag() == "Ghost") {
                if(App.gameState == "normal") {
                    App.lives--;
                    App.gameState = "immortal";
                    Updater.addStateDelay();
                }
                if(App.gameState == "power") {
                    o.setTag("Eaten_Ghost");
                    o.getSprite().setVisible(false);
                    App.points += 1000;
                }
            }
        }
    }
}
