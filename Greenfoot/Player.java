import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Actor implements Subject
{
    private boolean left;
    private boolean right;
    private boolean down;
    private boolean up;

    private int tScore;
    
    private int setImage=1;
    private int imageCounter=0;
    
    

    PacManState isDead;
    PacManState isAlive;
    PacManState hasSuperPower;
    PacManState currentState;
    
    //forObserver pattern
    private ArrayList<Observer> observers;
    public String moveLeft="left";
    public String moveRight="right";
    public String moveUp="up";
    public String moveDown="down";
    
    //
    public boolean playerIsDead;
    protected int getPositionValues(String axs)
    {
        if(axs=="x") return getX();
        else return getY();
    }
    
    public Player(){
        observers = new ArrayList<Observer>();
        isDead = new DeadState(this);
        isAlive = new AliveState(this);
        hasSuperPower = new SuperPowerState(this);
        
        currentState = isAlive;
        tScore = 0;
    }
    
    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(getWorld().getClass().toString().equals("class MenuWorld"))
        {
            movementSet();
        } else {
            if(!getWorld().getObjects(Ready.class).isEmpty()){
                setImage(new GreenfootImage("pacman2.png"));
                setLocation(365, 440);
                left=true; right=false; down=false; up=false;       
            } else {
                
                if(!playerIsDead) {
                   //System.out.println("current state:" +  currentState.getClass().toString());
                if(!getObjectsInRange(25, Ghost.class).isEmpty()&& currentState.getClass().toString().equals("class AliveState")){
                    
                    playerIsDead = false;
                    setPacManState(getDeadState());
                }
                if(currentState.getClass().toString().equals("class DeadState")){
                    playerIsDead = true;
                       getWorld().addObject(new Menu(7), 365, 350); getWorld().addObject(new ButtonsOverlay(2), 180, 550); getWorld().addObject(new Buttons(8), 500, 555);
                        getWorld().removeObjects(getWorld().getObjects(Score.class));
                        if(getWorld().getObjects(Score.class).isEmpty()) {
                           if(tScore<100) getWorld().addObject(new Score(tScore), 390, 355);
                                    else if(tScore<1000) getWorld().addObject(new Score(tScore), 370, 355);
                                    else if(tScore<10000) getWorld().addObject(new Score(tScore), 350, 355);
                                    else if(tScore<100000) getWorld().addObject(new Score(tScore), 320, 355);
                                    else getWorld().addObject(new Score(tScore), 300, 355);
                        }
                   
                } else {
                 
                    currentState.move();
                    currentState.eatNormalFood();
                    currentState.eatExoticFood();
                    currentState.eatEnemy();
                }
                }

                
                }
            } 
            }
        

     public void setPacManState(PacManState newPacManState){
        currentState = newPacManState;
    }
    
    public void eatNormalFood(){
        currentState.eatNormalFood();
    }
    
    public void eatEnemy(){
        currentState.eatEnemy();
    }
    
    public void eatExoticFood(){
        currentState.eatExoticFood();
    }
    
    public void move(){
        currentState.move();
    }
    
    public PacManState getDeadState() {
        return isDead;
    }
    
    public PacManState getAliveState() {
        return isAlive;
    }
    
    public PacManState getSuperPowerState() {
        return hasSuperPower;
    }
 
    
    
    public void moveSet()
    {
       
      
         if(Greenfoot.isKeyDown(moveLeft) && canMoveValues(getX()-23, getY()) && canMoveValues(getX()-23, getY()-22) && canMoveValues(getX()-23, getY()+22) && canMoveValues(getX()-23, getY()-6) && canMoveValues(getX()-23, getY()+6) && canMoveValues(getX()-23, getY()-12) && canMoveValues(getX()-23, getY()+12)) {
            left = true; right = false; up = false; down = false;
        }
        else if(Greenfoot.isKeyDown(moveRight) && canMoveValues(getX()+23, getY()) && canMoveValues(getX()+23, getY()-22) && canMoveValues(getX()+23, getY()+22) && canMoveValues(getX()+23, getY()-6) && canMoveValues(getX()+23, getY()+6) && canMoveValues(getX()+23, getY()-12) && canMoveValues(getX()+23, getY()+12)) {
            left = false; right = true; up = false; down = false;
        }
        else if(Greenfoot.isKeyDown(moveUp) && canMoveValues(getX(), getY()-23) && canMoveValues(getX()-22, getY()-23) && canMoveValues(getX()+22, getY()-23) && canMoveValues(getX()-6, getY()-23) && canMoveValues(getX()+6, getY()-23) && canMoveValues(getX()-12, getY()-23) && canMoveValues(getX()+12, getY()-23)) {
            left = false; right = false; up = true; down = false;
        }
        else if(Greenfoot.isKeyDown(moveDown) && canMoveValues(getX(), getY()+23) && canMoveValues(getX()-22, getY()+23) && canMoveValues(getX()+22, getY()+23) && canMoveValues(getX()-6, getY()+23) && canMoveValues(getX()+6, getY()+23) && canMoveValues(getX()-12, getY()+23) && canMoveValues(getX()+12, getY()+23)) {
            left = false; right = false; up = false; down = true;
        }
        
         

        movement();
    }

    private void movement()
    {
        if(left && canMoveValues(getX()-23, getY()) && canMoveValues(getX()-23, getY()-12) && canMoveValues(getX()-23, getY()+12)) {
            setLocation(getX()-1,getY()); setRotation(0);
        }
        else if(right && canMoveValues(getX()+23, getY()) && canMoveValues(getX()+23, getY()-12) && canMoveValues(getX()+23, getY()+12)) {
            setLocation(getX()+1,getY()); setRotation(180);
        }
        else if(up && canMoveValues(getX(), getY()-23) && canMoveValues(getX()-12, getY()-23) && canMoveValues(getX()+12, getY()-23)) {
            setLocation(getX(),getY()-1); setRotation(90);
        }
        else if(down && canMoveValues(getX(), getY()+23) && canMoveValues(getX()-12, getY()+23) && canMoveValues(getX()+12, getY()+23))
        {
            setLocation(getX(),getY()+1); setRotation(270);
        }
    }
    
    private boolean canMoveValues(int x, int y)
    {
        List<Wall> wall = getWorld().getObjectsAt(getX(),getY(), Wall.class);
        
        if(getWorld().getObjectsAt(x, y, Wall.class).isEmpty()) return true;
        

        else if(wall != null && wall.size() > 0){
            System.out.println(wall.get(0).mapValue);
            if((wall.get(0).mapValue == 81 || wall.get(0).mapValue == 101 ))
                return true;
            return false;
            }
        return false;
    }
    

    public void port()
    {
        int x=getX(); int y=getY();
        if(x==680 && y==350) {
            setLocation(51,350); left=false; right=true;
        }
        if(x==50 && y==350) {
            setLocation(679,350); left=true; right=false;
        }
    }
    

    
    public void eatingNormalFood(){
        Actor normalFood = getOneObjectAtOffset(0,0, Food2.class);
        
       
   /*     if(getWorld().getClass().toString().equals("class MyWorld")){
            MyWorld paw=(MyWorld) getWorld();
        } else {
            NormalStrategy paw=(MyWorld) getWorld();
        }*/
        if(normalFood!=null) {
            getWorld().removeObject(normalFood); 
            tScore = tScore + 2;
            setScore(tScore);
        }
        
        
    }
    
    public boolean eatingExoticFood(){
        Actor exoticFood = getOneObjectAtOffset(0,0, Food1.class);
        //MyWorld paw=(MyWorld) getWorld();
        
        if(exoticFood!=null) {
            getWorld().removeObject(exoticFood);
           tScore = tScore + 5;
           setScore(tScore);
            return true;
        } else {
            return false;
        }
        
    }
    
    public int eatingEnemy(){
        //MyWorld paw=(MyWorld) getWorld();
         if((!getObjectsInRange(25,Ghost1.class).isEmpty())){
            return 1;
        } else if((!getObjectsInRange(25,Ghost2.class).isEmpty())){
            return 2;
        }
        else if((!getObjectsInRange(25,Ghost3.class).isEmpty())){
            return 3;
        }
        else if((!getObjectsInRange(25,Ghost4.class).isEmpty())){
            return 4;
        }
        else if((!getObjectsInRange(25,Ghost5.class).isEmpty())){
            return 5;
        }
        else
            return 0;

    }
    
 
    
    public void register(Observer o) {
        // TODO Auto-generated method stub
        observers.add(o);
    }
    
    public void unregister(Observer o) {

         int observerIndex = observers.indexOf(o);
         //System.out.println("Observer " + (observerIndex+1) + " deleted");
         observers.remove(observerIndex);
    }
    
    public void notifyObserver() {
        // TODO Auto-generated method stub
         for(Observer observer : observers){
             observer.update(tScore);
         }
    }
    
    public void setScore(int newscore){
         //this.tScore = newscore;
         notifyObserver();
     }
    
    
    
    private void movementSet()
    {
        int x=getX(); int y=getY();
        if(y==345) {
            left=true; right=false;
        }
        if(y==475) {
            left=false; right=true;
        }
        if(x==0 && y==345) setLocation(464,475);
        if(x==730 && y==475) setLocation(0,475);
        if(x==330 && y==475) setLocation(375, 345);
        motionMovement(); motionImageChange();
    }
    
    private void motionMovement()
    {
        if(left) {
            setLocation(getX()-2,getY()); setRotation(0);
        }
        else if(right) {
            setLocation(getX()+2,getY()); setRotation(180);
        }
    }
    
    private void motionImageChange()
    {
        if(imageCounter==10) {
            if(setImage==1) {
                setImage(new GreenfootImage("pacman2.png")); setImage=2;
            }
            else if(setImage==2) {
                setImage(new GreenfootImage("pacman3.png")); setImage=1;
            }
            imageCounter=0;
        }
        else imageCounter=imageCounter+1;
    }
     public void setEnemyDead(int id){
         for (Object obj : getWorld().getObjects(Ghost.class)) {
                 Ghost g = (Ghost) obj;
                 if(g.getID() == id){
                    g.dead = true;
                    break;
                }
        }
    }

}
