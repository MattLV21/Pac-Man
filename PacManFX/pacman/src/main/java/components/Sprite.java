package components;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

public class Sprite implements Component {

    private Entity parent;
    private Rectangle sprite;
    private double offsetX;
    private double offsetY;

    public Sprite() {
        this.parent = null;
        this.sprite = new Rectangle();
        this.offsetX = 0;
        this.offsetY = 0;
    }

    /** Creates a new instance of a Sprite with given parent and size
     * @param parent parent Entity of Component
     */
    public Sprite(Entity parent) {
        this.parent = parent;
        this.sprite = new Rectangle(parent.getX(), parent.getY());
        this.offsetX = 0;
        this.offsetY = 0;
    }
    /** Creates a new instance of a Sprite with given parent and size
     * @param parent parent Entity of Component
     * @param path path to Image
     * @param size size of Sprite
     */
    public Sprite(Entity parent, String path, int size) {
        this.parent = parent;
        this.sprite = new Rectangle(parent.getX(), parent.getY(), size, size);
        this.sprite.setFill(new ImagePattern(new Image("/"+path)));
        this.offsetX = 0;
        this.offsetY = 0;
    }
    /** Creates a new instance of a Sprite with given parent and size
     * @param parent parent Entity of Component
     * @param size size of Sprite
     * @default Rectangle with parents current position
     */
    public Sprite(Entity parent, int size) {
        this.parent = parent;
        this.sprite = new Rectangle(parent.getX(), parent.getY(), size, size);
        this.offsetX = 0;
        this.offsetY = 0;
    }
    @Override
    public Entity parent() {
        return parent;
    }
    public void setParent(Entity parent) {
        this.parent = parent;
    }
    public Rectangle render() {
        update();
        return sprite;
    } 
    /** Updates the position of the {@code Sprite} to the current location of the parent {@code Entity}
     * 
     */
    public void update() {
        sprite.setX(parent.getX() + this.offsetX);
        sprite.setY(parent.getY() + this.offsetY);
    }
    /** Sets the color of {@code Sprite}
     * @param color new Color
     * @default {@code Color.BLACK}
     */
    public void setColor(Color color) {
        this.sprite.setFill(color);
    }
    /** Fills the {@code Rectangle} with an {@code Image} useing an {@code Image} object
     * @param image Image object
     */ 
    public void setImage(Image image) {
        this.sprite.setFill(new ImagePattern(image));
    }
    /** Fills the {@code Rectangle} with an {@code Image} using a path to an {@code Image}
     * @param path path to an {@code Image}
     */
    public void setImage(String path) {
        this.sprite.setFill(new ImagePattern(new Image("/"+path)));
    }

    /** the offset on the x axis based on {@code Entity} position
     * @return double
     */ 
    public double getOffsetX() {
        return this.offsetX;
    }
    /** sets the offset on the x axis based on {@code Entity} position
     * @param x new offset on x axis
     */ 
    public void setOffsetX(double x) {
        this.offsetX = x;
    }
    /** the offset on the y axis based on {@code Entity} position
     * @return double
     */
    public double getOffsetY() {
        return this.offsetY;
    }
    /** sets the offset on the y axis based on {@code Entity} position
     * @param y new offset on y axis
     */
    public void setOffsetY(double y) {
        this.offsetY = y;
    }
    /** Sets the {@code Width} of the {@code Sprite}
     * @param width new width of Sprite
     */
    public void setWidth(double width) {
        this.sprite.setWidth(width);
    }
    public double getWidth() {
        return this.sprite.getWidth();
    }
    /** Sets the {@code Height} of the {@code Sprite}
     * @param height new height of Sprite
     */
    public void setHeight(double height) {
        this.sprite.setHeight(height);
    }
    public double getHeight() {
        return this.sprite.getHeight();
    }
    /** Sets the {@code Opacity} of the {@code Sprite} in %,
     * 0 is 0% and 1 is 100%
     * @param opacity new opacity
     */
    public void setOpacity(double opacity) {
        this.sprite.setOpacity(opacity);
    }
    /** Sets the {@code Visible} of the {@code Sprite}
     * @param value true = visible, false not visible
     */
    public void setVisible(boolean value) {
        this.sprite.setVisible(value);
    }
}
