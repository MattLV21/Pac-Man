package Entitys.ghosts;

import components.Entity;

public class AvoidAI implements AI {
    private char dir;
    private Entity parent;
    
    public AvoidAI() {
    }
    public AvoidAI(Entity parent) {
        this.parent = parent;
    }

    public void setParent(Entity parent) {
        this.parent = parent;
    }

    private char findDirection(Entity[] nextTo, Entity target) {
        if(this.parent.getY() < target.getY() && nextTo[0].tag() != "Wall") {
            return 'W';
        } else if(this.parent.getX() > target.getX() && nextTo[1].tag() != "Wall") {
            return 'D';
        } else if(this.parent.getY() > target.getY() && nextTo[2].tag() != "Wall") {
            return 'S';
        } else if (this.parent.getX() < target.getX() && nextTo[3].tag() != "Wall") {
            return 'A';
        } else {
            return ' ';
        }
    }
    public char getDirection() {
        return this.dir;
    }
    public void update(Entity[] nextTo, Entity target) {
        this.dir = findDirection(nextTo, target);
    }
}
