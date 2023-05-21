package components;

import java.util.ArrayList;

import javafx.scene.shape.Rectangle;

public class Entity {
    private Sprite sprite;
    private String tag;
    private ArrayList<Component> components = new ArrayList<>();
    private int x, y;
    
    /** 
     * @param x
     * @param y
     */
    public Entity(int x, int y) {
        this.sprite = new Sprite(this);
        this.x = x;
        this.y = y;
    }
    public Entity(int x, int y, Sprite sprite, String tag) {
        this.sprite = sprite;
        this.tag = tag;
        this.x = x;
        this.y = y;
    }
    public void addComponent(Component com) {
        components.add(com);
    }
    public Rectangle render() {
        return this.sprite.render();
    }
    public Sprite getSprite() {
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
        return this.x;
    }
    public void setX(int x) {
        this.x = x;
        sprite.update();
    }
    public int getY() {
        return this.y;
    }
    public void setY(int y) {
        this.y = y;
        sprite.update();
    }
    public void setSprite(Sprite sprite) {
        this.sprite = sprite;
    }
    public void update() {
        this.sprite.update();
    }
    public ArrayList<Component> components() {
        return components;
    }
    public Component component(int index) {
        return components.get(index);
    }
}
