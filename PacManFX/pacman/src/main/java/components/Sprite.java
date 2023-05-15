package components;

import javafx.scene.image.Image;

public class Sprite implements Component {
    private Entity parent;
    private Image sprite;
    private double offsetX;
    private double offsetY;
    private int size;

    public Sprite(Entity parent, String path, int size) {
        this.sprite = new Image("/"+path);
        this.offsetX = 0;
        this.offsetY = 0;
        this.size = size;
    }
    public Sprite(Entity parent, int size) {
        this.offsetX = 0;
        this.offsetY = 0;
        this.size = size;
    }
    public Sprite(Entity parent, String path, int size, double offsetX, double offsetY) {
        this.sprite = new Image("/"+path);
        this.offsetX = offsetX;
        this.offsetY = offsetY;
        this.size = size;
    }

    public double[] getOffset() {
        double[] offsets = {this.offsetX, this.offsetY};
        return offsets;
    }
    @Override
    public Entity parent() {
        return parent;
    }

}
