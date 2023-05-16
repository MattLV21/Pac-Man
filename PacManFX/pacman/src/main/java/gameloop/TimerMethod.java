package gameloop;


import java.util.Arrays;
import components.Entity;
import javafx.animation.AnimationTimer;

class TimerMethod extends AnimationTimer {
    private long lastTime = System.nanoTime();
    private int delay = 100;
    private int stateDelay = 0;
    @Override
    public void handle(long now) {

        long time = System.nanoTime();
        int deltaTime = (int) ((time - lastTime) / 1000000);

        App.pointLabel.setText(""+App.points+" Points");
        App.livesLabel.setText(""+App.lives+" Lives");
        App.stateLabel.setText(App.gameState);

        if(UI.paused) {
            stop();
        }

        if(App.gameState == "immortal" && stateDelay == 0) {
            stateDelay = deltaTime + 500;
        }
        if(App.gameState == "power" && stateDelay == 0) {
            stateDelay = deltaTime + 5000;
        }
        if(deltaTime > stateDelay) {
            App.gameState = "normal";
            stateDelay = 0;
        }


        if (deltaTime > delay) {
            Entity[] objs = App.level.nextTo(App.level.scaleValueX(App.player.getX()),
            App.level.scaleValueY(App.player.getY()));
            Entity pos = App.level.position(App.level.scaleValueX(App.player.getX()),
            App.level.scaleValueY(App.player.getY()));

            Collision.onCollisionEnter(App.player, pos);
            for(int i = 0; i < App.ghosts.size(); i++) {
                if(Arrays.compare(App.player.getPos(), App.ghosts.get(i).getPos()) == 0) {
                    Collision.onCollisionEnter(App.player, App.ghosts.get(i));
                }
            }

            if(App.dia == 'W' && objs[0].tag() != "Wall") {
                App.player.setY(App.player.getY()-App.size);
            } else if(App.dia == 'S' && objs[2].tag() != "Wall") {
                App.player.setY(App.player.getY()+App.size);
            } else if(App.dia == 'A' && objs[3].tag() != "Wall") {
                App.player.setX(App.player.getX()-App.size);
            } else if(App.dia == 'D' && objs[1].tag() != "Wall") {
                App.player.setX(App.player.getX()+App.size);
            }
            delay = deltaTime + 100;
        }
    }
}
