package components;

import java.util.ArrayList;

import javafx.scene.shape.Rectangle;

public class Entity {
    private Sprite sprite;
    private String tag;
    private ArrayList<Component> components = new ArrayList<>();
    private int x, y;
    
    /** Creates a empty {@code Entity}
     * @param x Position on x axis
     * @param y Possition on y axis
     */
    public Entity(int x, int y) {
        this.sprite = new Sprite(this);
        this.x = x;
        this.y = y;
    }
    /** Creates a Enitity with a Sprite and tag
     * @param x Position on x axis
     * @param y Position on y axis
     * @param sprite used Sprite
     * @param tag
     */
    public Entity(int x, int y, Sprite sprite, String tag) {
        this.sprite = sprite;
        this.tag = tag;
        this.x = x;
        this.y = y;
    }
    /** Adds a new component to the Entity
     * @param com
     */
    public void addComponent(Component com) {
        components.add(com);
    }
    /** Used when rendering with javaFX
     * @return the Rectangle object
     */
    public Rectangle render() {
        return this.sprite.render();
    }
    /**
     * @return The first Sprite of the Entity
     * if no Sprite return null
     */
    public Sprite getSprite() {
        // for (int i = 0; i < this.components.size(); i++) {
        //     if (tihs.components.get(i) isinstensof Sprite) {
        //          return this.components.get(i).cast(Sprite);
        //     }
        // }
        // return null;
        return this.sprite;
    }
    /**
     * @return the tag of the Entity
     */
    public String tag() {
        return this.tag;
    }
    /** Set the tag of the Entity
     * @param tag
     */
    public void setTag(String tag) {
        this.tag = tag;
    }
    /** Sets the x and y position of the Entity
     * @param x
     * @param y
     */
    public void setPos(int x, int y) {
        this.x = x;
        this.y = y;
        sprite.update();
    }
    /** Gets the position of the Entity
     * @return x and y
     */
    public int[] getPos() {
        int[] pos = {x, y};
        return pos;
    }
    /**
     * @return The x position
     */
    public int getX() {
        return this.x;
    }
    /** Sets the x position
     * @param x
     */
    public void setX(int x) {
        this.x = x;
        sprite.update();
    }
    /**
     * @return The y position
     */
    public int getY() {
        return this.y;
    }
    /** Sets the y position
     * @param y
     */
    public void setY(int y) {
        this.y = y;
        sprite.update();
    }
    /** Sets the Sprite Component
     * @param sprite
     */
    public void setSprite(Sprite sprite) {
        this.sprite = sprite;
    }
    /**
     * Updates the position to match in Sprite Component
     */
    public void update() {
        // for (int i = 0; i < this.components.size(); i++) {
        //     this.components.get(i).update();
        // }
        this.sprite.update();
    }
    /** Returns a list of all components
     * @return ArrayList of Comonent
     */
    public ArrayList<Component> components() {
        return components;
    }
    /** Returns the component of given index
     * @param index
     * @return Component
     */
    public Component component(int index) {
        return components.get(index);
    }
}
