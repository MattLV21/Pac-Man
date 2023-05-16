package map;

import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner; // Import the Scanner class to read text files
import javafx.scene.paint.Color;

import components.Entity;
import components.Sprite;
import gameloop.App;

public class levelHandler {

    private Entity[][] level;
    private static char[] _egdeCase = {'#', '#', '#', '#'};
    private static List<String> data = new ArrayList<>();

    private int size;

    public levelHandler(int size) {
        try {
            File myObj = new File("src/main/java/map/level.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                data.add(myReader.nextLine());
            }
            this.size = size;

            this.level = new Entity[data.size()][data.get(0).length()*2];
            myReader.close();

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        } 
    }

    public void fillLevel() {
        for (int y = 0; y < data.size(); y++) {
            for (int x = 0; x < data.get(y).length()*2; x++) {
                this.level[y][x] = getEntityType(x, y);
            }
        }
    }

    private Entity getEntityType(int x, int y) {
        char current = data.get(y).charAt(loopingX(x));
        
        Entity entity = new Entity(x*this.size, y*this.size+App.offsetTop);
        Sprite rec = new Sprite(entity, size);
        String tag = "";
        rec.setColor(Color.WHITE);
        if (current == '-') {
            rec.setColor(Color.WHITE);
        }
        else if (current == 'c') {
            tag = "Coin";
            rec.setColor(Color.YELLOW);
        } else if (current == 'p') {
            tag = "Power";
            rec.setColor(Color.PINK);
        } else {
            char[] borders = bordering(loopingX(x), y);
            tag = "Wall";
            if (Arrays.compare(borders, _egdeCase) == 0) {
                // char[] egdes = egdes(x, y, data);
                rec.setColor(Color.GREEN);
            } else {
                rec.setColor(Color.BLUE);
            }
        }
        entity.setTag(tag);
        entity.setSprite(rec);
        return entity;
    }

    private char[] bordering(int x, int y) {
        char[] bordering = new char[4];
        if(x > 0) {
            bordering[3] = data.get(y).charAt(x-1);
        } else {
            bordering[3] = '#';
        }
        if (x < data.get(y).length()-1) {
            bordering[1] = data.get(y).charAt(x+1);
        } else {
            bordering[1] = '#';
        }
        if (y > 0) {
            bordering[2] = data.get(y-1).charAt(x);
        }
        if (y < data.size()-1) {
            bordering[0] = data.get(y+1).charAt(x);
        } 

        return bordering;
    }
    private char[] egdes(int x, int y, List<String> data) {
        char[] egdes = new char[4];
        egdes[4] = data.get(y+1).charAt(x+1);
        egdes[5] = data.get(y-1).charAt(x+1);
        egdes[6] = data.get(y-1).charAt(x-1);
        egdes[7] = data.get(y+1).charAt(x-1);

        return egdes;
    }

    private static int loopingX(int x) {
        if (x > data.get(0).length()-1) {
            return data.get(0).length()-1 - (x%data.get(0).length());
        } else {
            return x;
        }
    }

    public int scaleValueX(double x) {
        return (int) x/(size);
    }
    public int scaleValueY(double y) {
        return (int) (y-App.offsetTop)/size;
    }

    public Entity position(int x, int y) {
        return this.level[y][x];
    }

    public Entity[] nextTo(int x, int y) {
        Entity[] objs = new Entity[4];

        if (y > 0) {
            objs[0] = this.level[y-1][x];
        }
        if (y < this.level.length) {
            objs[2] = this.level[y+1][x];
        }
        if (x < this.level[y].length) {
            objs[1] = this.level[y][x+1];
        }
        if (x > 0) {
            objs[3] = this.level[y][x-1];
        }

        return objs;
    }

    public Entity[][] getLevel() {
        return this.level;
    }
}