import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class NormalWorld extends World
{
    public boolean muteS;
    public boolean musicS;
    GhostFactory ghostFactory;
    public int type;
    public String moveLeft="left";
    public String moveRight="right";
    public String moveUp="up";
    public String moveDown="down";

    private int[][] map = {
        {13,9,9,9,9,9,9,9,9,9,9,9,9,9,9,0,9,9,9,9,9,9,9,9,9,9,9,0,9,9,9,9,9,9,9,9,9,9,9,9,9,9,14},
        {8,0,0,0,0,0,0,0,0,0,0,0,0,0,0,5,0,0,0,0,0,0,0,0,0,0,0,5,0,0,0,0,0,0,0,0,0,0,0,0,0,0,10},
        {8,0,17,17,17,17,17,17,17,17,17,17,17,17,0,5,0,17,17,17,17,16,17,17,17,17,0,5,0,17,17,17,17,17,17,17,17,17,17,17,17,0,10},
        {8,0,17,0,0,0,0,17,0,0,0,0,0,17,0,5,0,17,0,0,0,0,0,0,0,17,0,5,0,17,0,0,0,0,0,17,0,0,0,0,17,0,10},
        {8,0,16,0,2,3,0,17,0,2,4,3,0,17,0,7,0,17,0,18,11,11,11,20,0,17,0,7,0,17,0,2,4,3,0,17,0,2,3,0,16,0,10},
        {8,0,17,0,0,0,0,17,0,0,0,0,0,17,0,0,0,17,0,10,0,0,0,8,0,17,0,0,0,17,0,0,0,0,0,17,0,0,0,0,17,0,10},
        {8,0,17,17,17,17,17,17,17,17,17,17,17,17,17,17,17,17,0,21,9,9,9,19,0,17,17,17,17,17,17,17,17,17,17,17,17,17,17,17,17,0,10},
        {8,0,17,0,0,0,0,17,0,0,0,17,0,0,0,0,0,17,0,0,0,0,0,0,0,17,0,0,0,0,0,17,0,0,0,17,0,0,0,0,17,0,10},
        {8,0,17,0,2,3,0,17,0,6,0,17,0,2,4,3,0,17,17,17,17,17,17,17,17,17,0,2,4,3,0,17,0,6,0,17,0,2,3,0,17,0,10},
        {8,0,17,0,0,0,0,17,0,5,0,17,0,0,0,0,0,0,0,0,0,17,0,0,0,0,0,0,0,0,0,17,0,5,0,17,0,0,0,0,17,0,10},
        {8,0,17,17,17,17,17,17,0,5,0,17,17,17,17,0,18,11,11,20,0,17,0,18,11,11,20,0,17,17,17,17,0,5,0,17,17,17,17,17,17,0,10},
        {8,0,0,0,0,0,0,17,0,5,0,0,0,0,17,0,10,0,0,8,0,17,0,10,0,0,8,0,17,0,0,0,0,5,0,17,0,0,0,0,0,0,10},
        {0,11,11,11,11,20,0,17,0,10,4,4,3,0,17,0,21,9,9,19,0,17,0,21,9,9,19,0,17,0,2,4,4,8,0,17,0,18,11,11,11,11,0},
        {0,0,0,0,0,8,0,17,0,5,0,0,0,0,17,0,0,0,0,0,0,17,0,0,0,0,0,0,17,0,0,0,0,5,0,17,0,10,0,0,0,0,0},
        {0,0,0,0,0,8,0,17,0,7,0,17,17,17,17,17,17,17,17,17,17,17,17,17,17,17,17,17,17,17,17,17,0,7,0,17,0,10,0,0,0,0,0},
        {0,0,0,0,0,8,0,17,0,0,0,17,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,17,0,0,0,17,0,10,0,0,0,0,0},
        {0,0,0,0,0,8,0,17,17,17,17,17,0,6,0,0,0,6,22,22,22,22,22,22,22,6,0,0,0,6,0,17,17,17,17,17,0,10,0,0,0,0,0},
        {0,0,0,0,0,8,0,17,0,0,0,0,0,5,0,0,0,5,0,0,0,0,0,0,0,5,0,0,0,5,0,0,0,0,0,17,0,10,0,0,0,0,0},
        {9,9,9,9,9,19,0,17,0,2,4,4,4,19,0,0,0,5,0,23,0,0,0,24,0,5,0,0,0,21,4,4,4,3,0,17,0,21,9,9,9,9,9},
        {0,0,0,0,0,0,0,17,0,0,0,0,0,0,0,0,0,5,0,0,0,0,0,0,0,5,0,0,0,0,0,0,0,0,0,17,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,17,0,0,0,0,0,0,0,0,0,5,0,0,0,27,0,0,0,5,0,0,0,0,0,0,0,0,0,17,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,17,0,0,0,0,0,0,0,0,0,5,0,0,0,0,0,0,0,5,0,0,0,0,0,0,0,0,0,17,0,0,0,0,0,0,0},
        {11,11,11,11,11,20,0,17,0,2,4,4,4,20,0,0,0,5,0,25,0,0,0,26,0,5,0,0,0,18,4,4,4,3,0,17,0,18,11,11,11,11,11},
        {0,0,0,0,0,8,0,17,0,0,0,0,0,5,0,0,0,5,0,0,0,0,0,0,0,5,0,0,0,5,0,0,0,0,0,17,0,10,0,0,0,0,0},
        {0,0,0,0,0,8,0,17,17,17,17,17,0,7,0,0,0,21,4,4,4,4,4,4,4,19,0,0,0,7,0,17,17,17,17,17,0,10,0,0,0,0,0},
        {0,0,0,0,0,8,0,17,0,0,0,17,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,17,0,0,0,17,0,10,0,0,0,0,0},
        {0,0,0,0,0,8,0,17,0,6,0,17,17,17,17,17,17,17,17,17,17,1,17,17,17,17,17,17,17,17,17,17,0,6,0,17,0,10,0,0,0,0,0},
        {0,0,0,0,0,8,0,17,0,5,0,0,0,0,17,0,0,0,0,0,0,17,0,0,0,0,0,0,17,0,0,0,0,5,0,17,0,10,0,0,0,0,0},
        {0,9,9,9,9,19,0,17,0,10,4,4,3,0,17,0,18,11,11,20,0,17,0,18,11,11,20,0,17,0,2,4,4,8,0,17,0,21,9,9,9,9,0},
        {8,0,0,0,0,0,0,17,0,5,0,0,0,0,17,0,10,0,0,8,0,17,0,10,0,0,8,0,17,0,0,0,0,5,0,17,0,0,0,0,0,0,10},
        {8,0,17,17,17,17,17,17,0,5,0,17,17,17,17,0,21,9,9,19,0,17,0,21,9,9,19,0,17,17,17,17,0,5,0,17,17,17,17,17,17,0,10},
        {8,0,17,0,0,0,0,17,0,5,0,17,0,0,0,0,0,0,0,0,0,17,0,0,0,0,0,0,0,0,0,17,0,5,0,17,0,0,0,0,17,0,10},
        {8,0,17,0,2,3,0,17,0,7,0,17,0,2,4,3,0,17,17,17,17,17,17,17,17,17,0,2,4,3,0,17,0,7,0,17,0,2,3,0,17,0,10},
        {8,0,17,0,0,0,0,17,0,0,0,17,0,0,0,0,0,17,0,0,0,0,0,0,0,17,0,0,0,0,0,17,0,0,0,17,0,0,0,0,17,0,10},
        {8,0,17,17,17,17,17,17,17,17,17,17,17,17,17,17,17,17,0,18,11,11,11,20,0,17,17,17,17,17,17,17,17,17,17,17,17,17,17,17,17,0,10},
        {8,0,17,0,0,0,0,17,0,0,0,0,0,17,0,0,0,17,0,10,0,0,0,8,0,17,0,0,0,17,0,0,0,0,0,17,0,0,0,0,17,0,10},
        {8,0,16,0,2,3,0,17,0,2,4,3,0,17,0,6,0,17,0,21,9,9,9,19,0,17,0,6,0,17,0,2,4,3,0,17,0,2,3,0,16,0,10},
        {8,0,17,0,0,0,0,17,0,0,0,0,0,17,0,5,0,17,0,0,0,0,0,0,0,17,0,5,0,17,0,0,0,0,0,17,0,0,0,0,17,0,10},
        {8,0,17,17,17,17,17,17,17,17,17,17,17,17,0,5,0,17,17,17,17,16,17,17,17,17,0,5,0,17,17,17,17,17,17,17,17,17,17,17,17,0,10},
        {8,0,0,0,0,0,0,0,0,0,0,0,0,0,0,5,0,0,0,0,0,0,0,0,0,0,0,5,0,0,0,0,0,0,0,0,0,0,0,0,0,0,10},
        {12,11,11,11,11,11,11,11,11,11,11,11,11,11,11,0,11,11,11,11,11,11,11,11,11,11,11,0,11,11,11,11,11,11,11,11,11,11,11,11,11,11,15},
        };
    
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public NormalWorld()
    {   super(731, 650, 1, false);
        ghostFactory = new GhostFactory();
        setPaintOrder(ButtonsOverlay.class, Menu.class, Buttons.class, Cover.class,Wall.class,Ghost.class,Player.class,Food.class);
        setActOrder(Player.class,Food.class,Ghost.class);
        singlePlayer();
        Greenfoot.setSpeed(50); Greenfoot.start();

    }
    
    public void singlePlayer(){
        Player p = new Player();
        for(int x = 0; x<map.length; x++) {
            for(int y = 0; y<map[x].length; y++) {
                mapReader(map[x][y],x,y); //Greg v code
                if(map[x][y]==1) addObject(p, y*15+50, x*15+50);
            }
        }
        addObject(new Ready(), 365, 530);
        
        addObject(new Life(), 25, 270);
        Buttons mute = new Buttons(6); if(muteS) mute.setImage("mute button 2.png"); else mute.setImage("mute button 1.png"); mute.getImage().scale(30,30);
        Buttons music = new Buttons(5); if(musicS) music.setImage("music button 2.png"); else music.setImage("music button 1.png"); music.getImage().scale(30,30);
        Actor score = new Score(p);
        score.setImage(new GreenfootImage("Score: " + 0, 30, java.awt.Color.YELLOW, java.awt.Color.BLACK));
        addObject(score, 65, 430);
        
        setPaintOrder(Buttons.class, Score.class, Menu.class, Wall.class, Ghost.class, Player.class, Food.class);
        setActOrder(Food.class,Ghost.class,Player.class);
        Greenfoot.setSpeed(56);type =1;
    }
    
    public void mapReader(int map,int x,int y)
    {
        if(map<1) {
            return;
        }
        if(map<2) {
            return;
        }
        if(map<23) {
            if(map == 16) {
                addObject(new Food1(), y*15+50, x*15+50);
                return;
            }
            if(map == 17) {
                addObject(new Food2(), y*15+50, x*15+50);
                return;
            }
            addObject(new Wall(map), y*15+50, x*15+50);
            return;
        }
        switch(map) {
             
            case 23:addObject(ghostFactory.makeGhost(1), y*15+50, x*15+50);
            break;
            case 24:addObject(ghostFactory.makeGhost(2), y*15+50, x*15+50);
            break;
            case 25:addObject(ghostFactory.makeGhost(3), y*15+50, x*15+50);
            break;
            case 26:addObject(ghostFactory.makeGhost(4), y*15+50, x*15+50);
            break;
            case 27:addObject(ghostFactory.makeGhost(5), y*15+50, x*15+50);
            break;
        }
    }
}
