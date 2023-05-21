package gameloop;

import java.util.ArrayList;

import Entitys.ghosts.*;
import Entitys.map.levelHandler;
import Entitys.pacman.PacMan;
import components.*;
import javafx.scene.paint.Color;

public class LoadGameData {
    private PacMan pacMan;
    private levelHandler level;
    private ArrayList<Ghost> ghosts;
    private int size;

    public LoadGameData(int size) {
        this.size = size;
        loadAll();
    }

    private levelHandler loadLevel() {
        levelHandler newLevel = new levelHandler(size);
        newLevel.fillLevel();
        return newLevel;
    }
    private PacMan loadPlayer() {
        PacMan player = new PacMan(size, size+App.offsetTop, size);
        player.getEntity().setSprite(new Sprite(player.getEntity(), size));
        return player;
    }
    private ArrayList<Ghost> loadGhosts() {
        ArrayList<Ghost> ghosts = new ArrayList<Ghost>();
        Ghost ghost1 = new Ghost(size, size*28+App.offsetTop,
                            new Sprite(), new PursueAI(), new AvoidAI(), size);
        ghosts.add(ghost1);
        Ghost ghost2 = new Ghost(size*25, size*29+App.offsetTop,
                            new Sprite(), new PursueAI(), new AvoidAI(), size);
        ghosts.add(ghost2);
        Ghost ghost3 = new Ghost(size*25, size+App.offsetTop,
                            new Sprite(), new PursueAI(), new AvoidAI(), size);
        ghosts.add(ghost3);
        Ghost ghost4 = new Ghost(size*15, size*28+App.offsetTop,
                            new Sprite(), new PursueAI(), new AvoidAI(), size);
        ghosts.add(ghost4);

        return ghosts;
    }

    public void render() {
        for(int i = 0; i < this.level.getLevel().length; i++) {
            for(int j = 0; j < this.level.getLevel()[j].length; j++) {
                App.root.getChildren().add(level.getLevel()[i][j].render());
            }
        }
        App.root.getChildren().add(pacMan.getEntity().render());
        for(int i = 0; i < ghosts.size(); i++) {
            App.root.getChildren().add(ghosts.get(i).getEntity().render());
        }
    }

    public void loadAll() {
        this.pacMan = loadPlayer();
        this.level = loadLevel();
        this.ghosts = loadGhosts();
    }

    public void reload() {
        this.pacMan.getEntity().setPos(size, size+App.offsetTop);
        this.pacMan.setDirection(' ');
        for (int i = 0; i < this.ghosts.size(); i++) {
            this.ghosts.get(i).getEntity().setPos(size+(size*8*i), size*29+App.offsetTop);
            if (this.ghosts.get(i).getEntity().tag() == "Eaten_Ghost") {
                this.ghosts.get(i).getEntity().setTag("Ghost");
                this.ghosts.get(i).getEntity().getSprite().setVisible(true);
            }
        }

        for(int i = 0; i < this.level.getLevel().length; i++) {
            for(int j = 0; j < this.level.getLevel()[j].length; j++) {
                if(this.level.getLevel()[i][j].tag() == "Used_Coin") {
                    this.level.getLevel()[i][j].setTag("Coin");
                    this.level.getLevel()[i][j].getSprite().setColor(Color.YELLOW);
                } else if (this.level.getLevel()[i][j].tag() == "Used_Power") {
                    this.level.getLevel()[i][j].setTag("Power");
                    this.level.getLevel()[i][j].getSprite().setColor(Color.PINK);
                }
            }
        }
        
        App.points = 0;
        App.lives = 3;
    }

    public levelHandler getLevel() {
        return level;
    }
    public PacMan getPacMan() {
        return pacMan;
    }
    public ArrayList<Ghost> getGhosts() {
        return ghosts;
    }
}
