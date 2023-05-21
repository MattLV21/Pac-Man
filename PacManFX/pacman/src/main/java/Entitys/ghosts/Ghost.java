package Entitys.ghosts;

import components.Entity;
import components.Sprite;
import gameloop.App;
import javafx.scene.paint.Color;

public class Ghost {
    private Entity ghost;
    private AI pursueAI;
    private AI avoidAi;
    private char dir;

    public Ghost(int x, int y, Sprite sprite, AI pursue, AI avoid, double size) {
        this.ghost = new Entity(x, y);
        sprite.setColor(Color.GRAY);
        sprite.setWidth(size);
        sprite.setHeight(size);
        sprite.setParent(ghost);
        ghost.setSprite(sprite);
        ghost.setTag("Ghost");
        this.pursueAI = pursue;
        this.pursueAI.setParent(this.ghost);
        this.avoidAi = avoid;
        this.avoidAi.setParent(this.ghost);
    }
    public char getDirection() {
        return this.dir;
    }
    public Entity getEntity() {
        return this.ghost;
    }


    public void movement(Entity[] level) {
        if(dir == 'W' && level[0].tag() != "Wall") {
            ghost.setY(ghost.getY()-App.size);
        } else if(dir == 'S' && level[2].tag() != "Wall") {
            ghost.setY(ghost.getY()+App.size);
        } else if(dir == 'A' && level[3].tag() != "Wall") {
            ghost.setX(ghost.getX()-App.size);
        } else if(dir == 'D' && level[1].tag() != "Wall") {
            ghost.setX(ghost.getX()+App.size);
        }
    }
    public void update(Entity[] nextTo) {
        if(App.gameState != "power") {
            pursueAI.update(nextTo, App.data.getPacMan().getEntity());
            this.dir = pursueAI.getDirection();
        } else {
            avoidAi.update(nextTo, App.data.getPacMan().getEntity());
            this.dir = avoidAi.getDirection();
        }
        this.ghost.update();
    }
}
