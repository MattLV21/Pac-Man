package Entitys.pacman;

import components.Entity;
import components.Sprite;

public class PacMan {
    private Entity pacman;
    private Controller controller;

    public PacMan(int x, int y, double size) {
        this.pacman = new Entity(x, y);
        pacman.setTag("Player");
        this.controller = new Controller(pacman);
    }
    public PacMan(int x, int y, Sprite sprite, double size) {
        this.pacman = new Entity(x, y);
        pacman.setSprite(sprite);
        pacman.setTag("Player");
        this.controller = new Controller(pacman);
    }
    public char getDirection() {
        return this.controller.getDir();
    }
    public void setDirection(char dir) {
        this.controller.setDir(dir);
    }
    public Entity getEntity() {
        return this.pacman;
    }

    public void movement(Entity[] level) {
        controller.update(level);
    }
    public void update(Entity[] nextTo) {
        movement(nextTo);
    }
}
