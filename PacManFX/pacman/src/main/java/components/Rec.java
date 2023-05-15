package components;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Rec extends Sprite {

    private Rectangle rec;
    private Entity parent;

    public Rec(Entity parent, int size) {
        super(parent, size);
        this.parent = parent;
        this.rec = new Rectangle(parent.getX(), parent.getY(), size, size);
    }

    public void setColor(Color color) {
        this.rec.setFill(color);
    }
    public Rectangle render() {
        return rec;
    }    
    public void update() {
        int[] pos = parent.getPos();
        rec.setX(pos[0]);
        rec.setY(pos[1]);
    }
}
