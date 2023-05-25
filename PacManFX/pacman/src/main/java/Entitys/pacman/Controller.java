package Entitys.pacman;

import components.Entity;

public class Controller {
    private Entity parent;
    private char dir;

    /** Creates an Contorller object
     * @param parent parent of Contorller
     */
    public Controller(Entity parent) {
        this.parent = parent;
        this.dir = ' ';
    }

    /** Moves the parent
     * @param nextTo Entitys next to parent
     */
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
    /** returns the current direction
     * @return char
     */
    public char getDir() {
        return dir;
    }
    /** sets the current direction
     * @param dir char
     */
    public void setDir(char dir) {
        this.dir = dir;
    }
}
