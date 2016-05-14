import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class HelperGhost here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BlackGhost extends Ghost
{
     private boolean left;
    private boolean right;
    private int setImage=1;
    private int moveCounter=0;
    public boolean playerDie;
    private boolean eatable;
    private int ID;
    private String image;
    
    private boolean out;
    public boolean dead;
    private int exitCounter=0;
    private int dangerCounter=0;
    private boolean up;
    private boolean down;

    private int direction = 0;
    /**
     * Act - do whatever the HelperGhost wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(getWorld().getObjects(Ready.class).isEmpty()) {
        
            moveSet();
            eatPlayer();
        }
    }  
        
   private void eatPlayer() {
    /*
       GhostFactory ghostFactory = new GhostFactory();
        //MyWorld paw=(MyWorld) getWorld();
        if((!getObjectsInRange(20,Ghost1.class).isEmpty())){
            getWorld().removeObjects(getWorld().getObjects(Ghost1.class));
            getWorld().addObject(ghostFactory.makeGhost(1), 18*15+50, 19*15+50);
        } else if((!getObjectsInRange(20,Ghost2.class).isEmpty())){
            getWorld().removeObjects(getWorld().getObjects(Ghost2.class));
                        getWorld().addObject(ghostFactory.makeGhost(2), 18*15+50, 23*15+50);
        }
        else if((!getObjectsInRange(20,Ghost3.class).isEmpty())){
            getWorld().removeObjects(getWorld().getObjects(Ghost3.class));
                        getWorld().addObject(ghostFactory.makeGhost(3), 22*15+50, 19*15+50);
        }
        else if((!getObjectsInRange(20,Ghost4.class).isEmpty())){
            getWorld().removeObjects(getWorld().getObjects(Ghost4.class));
                        getWorld().addObject(ghostFactory.makeGhost(4), 22*15+50, 23*15+50);
        }
        else if((!getObjectsInRange(20,Ghost5.class).isEmpty())){
            getWorld().removeObjects(getWorld().getObjects(Ghost5.class));
                        getWorld().addObject(ghostFactory.makeGhost(5), 20*15+50, 21*15+50);
        }
        */
    }

    
    
    
    
    private void moveSet(){
        setDirection();
        move();
    }
    
   
    private void setDirection(){

        if(direction == 0 && (metwall(90) || metwall(91))){
            direction = 1;
        }
        else if(direction == 1 && (metwall(80) || metwall(81))){
            direction = 2;
        }
        else if(direction == 2 && (metwall(110) || metwall(111))){
            direction = 3;
        }  
        else if(direction == 3 && (metwall(100) || metwall(101))){
            direction = 0;
        } 
    }
    private boolean metwall(int X){
        List<Wall> wall = getWorld().getObjectsAt(getX(),getY(), Wall.class);
        if(wall != null && wall.size() > 0){
            if(wall.get(0).mapValue == X)
                return true;
            }
            return false;
    }
    private void move(){
        if(direction == 0){
                setLocation(getX()-1,getY()-1);
                setImage(new GreenfootImage("blackghost.png")); setRotation(0);
            }
        else if(direction == 1){
               setLocation(getX()-1,getY()+1);
                setImage(new GreenfootImage("blackghost.png")); setRotation(0);
        }
        else if(direction == 2){
               setLocation(getX()+1,getY()+1);
                setImage(new GreenfootImage("blackghost.png")); setRotation(0);
        }
        else if(direction == 3){
               setLocation(getX()+1,getY()-1);
                setImage(new GreenfootImage("blackghost.png")); setRotation(0);
        }
        else{}
      
      // if canMove(getX(),getY());
      // if(canMove(getX()-23, getY()) && canMove(getX()-23, getY()-12) && canMove(getX()-23, getY()+12)) {
         
            
        //}
    }
    private void canMove(int X, int Y)
    {
        System.out.println(getWorld().getObjectsAt(X,Y, Wall.class).get(0));
       // return true;
    }
    
     
    
    public BlackGhost(){
        //setImageString("ghosthelper.png");
        setImage(new GreenfootImage("blackghost.png"));
    }
}
