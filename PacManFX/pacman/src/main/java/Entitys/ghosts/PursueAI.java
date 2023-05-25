package Entitys.ghosts;

import components.Entity;

public class PursueAI implements AI {
    private char dir;
    private Entity parent;
    
    /** Creates a PursueAI with no parent
     * 
     */
    public PursueAI() {
    }
    /** Creates a PursueAI
     * @param parent
     */
    public PursueAI(Entity parent) {
        this.parent = parent;
    }
    /** Sets the parent of PursueAI
     * @param parent new parent
     */
    public void setParent(Entity parent) {
        this.parent = parent;
    }

    /** Finds the new direction to move in
     * @param nextTo Entitys next to parent
     * @param target Entity to pursue
     * @return char 
     */
    private char findDirection(Entity[] nextTo, Entity target) {
        if(this.parent.getY() > target.getY() && nextTo[0].tag() != "Wall") {
            return 'W';
        } else if(this.parent.getX() < target.getX() && nextTo[1].tag() != "Wall") {
            return 'D';
        } else if(this.parent.getY() < target.getY() && nextTo[2].tag() != "Wall") {
            return 'S';
        } else if (this.parent.getX() > target.getX() && nextTo[3].tag() != "Wall") {
            return 'A';
        } else {
            return ' ';
        }
    }
    /** Returns the current moving direction
     * @return char
     */
    public char getDirection() {
        return this.dir;
    }
    /** updates the Direction the parent wants to move in
     * @param nextTo Entitys next to parent
     * @param target Entity to pursue
     */
    public void update(Entity[] nextTo, Entity target) {
        this.dir = findDirection(nextTo, target);
    }
}
