package components;

import java.util.ArrayList;

import javafx.scene.shape.Rectangle;

public class Entity {
    private Rec sprite;
    private String tag;
    private ArrayList<Component> components = new ArrayList<>();
    private int x, y;
    

    public Entity(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public Entity(int x, int y, Rec sprite, String tag) {
        this.x = x;
        this.y = y;
    }
    public void addComponent(Component com) {
        components.add(com);
    }

    public Rectangle render() {
        return this.sprite.render();
    }
    public Rec getSprite() {
        return this.sprite;
    }
    public String tag() {
        return this.tag;
    }
    public void setTag(String tag) {
        this.tag = tag;
    }
    public void setPos(int x, int y) {
        this.x = x;
        this.y = y;
        sprite.update();
    }
    public int[] getPos() {
        int[] pos = {x, y};
        return pos;
    }
    public int getX() {
        return x;
    }
    public void setX(int x) {
        this.x = x;
        sprite.update();
    }
    public int getY() {
        return y;
    }
    public void setY(int y) {
        this.y = y;
        sprite.update();
    }
    public void setSprite(Rec rec) {
        this.sprite = rec;
    }
    public ArrayList<Component> components() {
        return components;
    }
    public Component component(int index) {
        return components.get(index);
    }
}
