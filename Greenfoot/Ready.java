import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Ready here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ready extends Actor
{
    private GreenfootSound begin = new GreenfootSound("ready-sound.mp3");
    private int counter =0;
    /**
     * Act - do whatever the Ready wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
       count();
    }    
    
    private void count(){
        if(counter == 100){
            counter =0; getWorld().removeObject(this);
        } else {
            counter = counter +1;
        }
        
    }
}
