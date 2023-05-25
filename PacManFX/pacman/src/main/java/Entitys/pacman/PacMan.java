package Entitys.pacman;

import components.Entity;
import components.Sprite;

public class PacMan {
    private Entity pacman;
    private Controller controller;

    /** Creates an PacMan objext
     * @param x position
     * @param y position
     * @param size
     */
    public PacMan(int x, int y, double size) {
        this.pacman = new Entity(x, y);
        pacman.setTag("Player");
        this.controller = new Controller(pacman);
    }
    /** Creates an PacMan object
     * @param x position
     * @param y position
     * @param sprite 
     * @param size
     */
    public PacMan(int x, int y, Sprite sprite, double size) {
        this.pacman = new Entity(x, y);
        pacman.setSprite(sprite);
        pacman.setTag("Player");
        this.controller = new Controller(pacman);
    }
    /** Returns the current direction
     * @return char
     */
    public char getDirection() {
        return this.controller.getDir();
    }
    /** sets the current direction
     * @param dir 
     */
    public void setDirection(char dir) {
        this.controller.setDir(dir);
    }
    /** Returns the Entity
     * @return Entity
     */
    public Entity getEntity() {
        return this.pacman;
    }

    /** Moves the Entity
     * @param level Entitys next to parent
     */
    public void movement(Entity[] level) {
        controller.update(level);
    }
    /** Updates the object
     * @param nextTo Entitys next to parent
     */
    public void update(Entity[] nextTo) {
        movement(nextTo);
    }
}
