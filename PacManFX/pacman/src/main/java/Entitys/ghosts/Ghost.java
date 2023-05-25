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
    private Entity target;
    private int size;

    /** Creates an Ghost Entity
     * @param x x position
     * @param y y position
     * @param sprite Sprite
     * @param pursue AI used to pursue target
     * @param avoid AI used to avoid target
     * @param size size of Entity
     */
    public Ghost(int x, int y, Sprite sprite, AI pursue, AI avoid, int size) {
        this.ghost = new Entity(x, y);
        sprite.setColor(Color.GRAY);
        sprite.setWidth(size);
        sprite.setHeight(size);
        sprite.setParent(ghost);
        ghost.setSprite(sprite);
        ghost.setTag("Ghost");
        this.size = size;
        this.pursueAI = pursue;
        this.pursueAI.setParent(this.ghost);
        this.avoidAi = avoid;
        this.avoidAi.setParent(this.ghost);
    }
    /** The current moving direction
     * @return char
     */
    public char getDirection() {
        return this.dir;
    }
    /**
     * @return this Entity
     */
    public Entity getEntity() {
        return this.ghost;
    }
    /** Sets the target Entity
     * @param target
     */
    public void setTarget(Entity target) {
        this.target = target;
    }


    /** Moves the Entity ingiven direction if no wall is found
     * @param level Entitys next to this Entity
     */
    private void movement(Entity[] level) {
        if(dir == 'W' && level[0].tag() != "Wall") {
            ghost.setY(ghost.getY()-size);
        } else if(dir == 'S' && level[2].tag() != "Wall") {
            ghost.setY(ghost.getY()+size);
        } else if(dir == 'A' && level[3].tag() != "Wall") {
            ghost.setX(ghost.getX()-size);
        } else if(dir == 'D' && level[1].tag() != "Wall") {
            ghost.setX(ghost.getX()+size);
        }
    }
    /** Updates the Ghost with new direction and moving towards the target
     * acording to the game state
     * @param nextTo Entitys next to this Entity
     */
    public void update(Entity[] nextTo) {
        if(App.gameState != "power") {
            pursueAI.update(nextTo, target);
            this.dir = pursueAI.getDirection();
        } else {
            avoidAi.update(nextTo, target);
            this.dir = avoidAi.getDirection();
        }
        movement(nextTo);
        this.ghost.update();
    }
}
