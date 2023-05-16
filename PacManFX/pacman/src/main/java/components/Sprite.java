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

    public Sprite(Entity parent) {
        this.parent = parent;
        this.sprite = new Rectangle(parent.getX(), parent.getY());
        this.offsetX = 0;
        this.offsetY = 0;
    }
    public Sprite(Entity parent, String path, int size) {
        this.parent = parent;
        this.sprite = new Rectangle(parent.getX(), parent.getY(), size, size);
        this.sprite.setFill(new ImagePattern(new Image("/"+path)));
        this.offsetX = 0;
        this.offsetY = 0;
    }
    /**
     * @param parent
     * @param size
     */
    public Sprite(Entity parent, int size) {
        this.parent = parent;
        this.sprite = new Rectangle(parent.getX(), parent.getY(), size, size);
        this.offsetX = 0;
        this.offsetY = 0;
    }
    public Sprite(Entity parent, String path, int size, double offsetX, double offsetY) {
        this.parent = parent;
        this.sprite = new Rectangle(parent.getX(), parent.getY(), size, size);
        this.sprite.setFill(new ImagePattern(new Image("/"+path)));
        this.offsetX = offsetX;
        this.offsetY = offsetY;
    }
    @Override
    public Entity parent() {
        return parent;
    }
    public Rectangle render() {
        return sprite;
    } 
    public void update() {
        sprite.setX(parent.getX());
        sprite.setY(parent.getY());
    }
    public void setColor(Color color) {
        this.sprite.setFill(color);
    }
    public void setImage(Image image) {
        this.sprite.setFill(new ImagePattern(image));
    }
    public void setImage(String path) {
        this.sprite.setFill(new ImagePattern(new Image("/"+path)));
    }

    public double getOffsetX() {
        return this.offsetX;
    }
    public void setOffsetX(double x) {
        this.offsetX = x;
    }
    public double getOffsetY() {
        return this.offsetY;
    }
    public void setOffsetY(double y) {
        this.offsetY = y;
    }
    public void setWidth(double width) {
        this.sprite.setWidth(width);
    }
    public void setHeight(double height) {
        this.sprite.setHeight(height);
    }
    public void setOpacity(double opacity) {
        this.sprite.setOpacity(opacity);
    }
    public void setVisible(boolean value) {
        this.sprite.setVisible(value);
    }
}
