package Entitys.ghosts;

import components.Entity;

public interface AI {
    public void setParent(Entity parent);
    public char getDirection();
    public void update(Entity[] nextTo, Entity target);
}
