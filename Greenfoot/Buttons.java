import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Buttons here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Buttons extends Actor
{
    protected int ID;
    
    public Buttons(){
    }
    
    public Buttons(int state){
        ID = state;
        
        switch(ID){
            case 1: setImage(new GreenfootImage("1 player.png"));
            break;
            case 2: setImage(new GreenfootImage("2 player.png"));
            break;
            case 3: setImage(new GreenfootImage("About.png"));
            break;
            case 4: setImage(new GreenfootImage("Help.png"));
            break;
            case 5: setImage(new GreenfootImage("music button 1.png")); getImage().scale(30,30);
            break;
            case 6: setImage(new GreenfootImage("mute button 1.png")); getImage().scale(30,30);
            break;
            case 7: setImage(new GreenfootImage("resume.png"));
            break;
            case 8: setImage(new GreenfootImage("retry.png"));
            break;
        }
        
    }
    /**
     * Act - do whatever the Buttons wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }    
}
