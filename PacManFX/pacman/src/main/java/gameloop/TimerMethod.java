package gameloop;


import java.util.Arrays;

import Entitys.ghosts.Ghost;
import components.Entity;
import javafx.animation.AnimationTimer;

class TimerMethod extends AnimationTimer {
    private long lastTime = System.nanoTime();
    private int delay = 100;
    private static int stateDelay = 0;
    private static int deltaTime;
    @Override
    public void handle(long now) {

        long time = System.nanoTime();
        deltaTime = (int) ((time - lastTime) / 1000000);

        App.pointLabel.setText(""+App.points+" Points");
        App.livesLabel.setText(""+App.lives+" Lives");
        App.stateLabel.setText(App.gameState);

        if(UI.paused) {
            stop();
        }
        if(App.lives <= 0) {
            App.gameState = "finished";
            UI.displayUI();
        }

        if(deltaTime > stateDelay) {
            App.gameState = "normal";
            stateDelay = 0;
        }

        if (deltaTime > delay) {
            Entity[] objs = App.data.getLevel().nextTo(App.data.getLevel().scaleValueX(App.data.getPacMan().getEntity().getX()),
                                            App.data.getLevel().scaleValueY(App.data.getPacMan().getEntity().getY()));
            Entity pos = App.data.getLevel().position(App.data.getLevel().scaleValueX(App.data.getPacMan().getEntity().getX()),
                                            App.data.getLevel().scaleValueY(App.data.getPacMan().getEntity().getY()));

            Collision.onCollisionEnter(App.data.getPacMan().getEntity(), pos);
            for(int i = 0; i < App.data.getGhosts().size(); i++) {
                Ghost ghost = App.data.getGhosts().get(i);
                Entity[] nextToGhost = App.data.getLevel().nextTo(App.data.getLevel().scaleValueX(ghost.getEntity().getX()), 
                                                        App.data.getLevel().scaleValueY(ghost.getEntity().getY()));
                ghost.update(nextToGhost);
                ghost.movement(nextToGhost);
                if(Arrays.compare(App.data.getPacMan().getEntity().getPos(), ghost.getEntity().getPos()) == 0) {
                    Collision.onCollisionEnter(App.data.getPacMan().getEntity(), ghost.getEntity());
                }
            }

            App.data.getPacMan().update(objs);

            delay = deltaTime + 100;
        }
    }

    public static void addStateDelay() {
        if(App.gameState == "immortal") {
            stateDelay = deltaTime + 500;
        }
        if(App.gameState == "power") {
            stateDelay = deltaTime + 5000;
        }
    } 
}
