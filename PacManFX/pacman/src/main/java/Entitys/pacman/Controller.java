package Entitys.pacman;

import components.Entity;

public class Controller {
    private Entity parent;
    private char dir;

    public Controller(Entity parent) {
        this.parent = parent;
        this.dir = ' ';
    }

    public void update(Entity[] nextTo) {
        if(dir == 'W' && nextTo[0].tag() != "Wall") {
            parent.setY(parent.getY()-(int) parent.getSprite().getHeight());
        } else if(dir == 'S' && nextTo[2].tag() != "Wall") {
            parent.setY(parent.getY()+(int) parent.getSprite().getHeight());
        } else if(dir == 'A' && nextTo[3].tag() != "Wall") {
            parent.setX(parent.getX()-(int) parent.getSprite().getWidth());
        } else if(dir == 'D' && nextTo[1].tag() != "Wall") {
            parent.setX(parent.getX()+(int) parent.getSprite().getWidth());
        }
    }
    public char getDir() {
        return dir;
    }
    public void setDir(char dir) {
        this.dir = dir;
    }
}
