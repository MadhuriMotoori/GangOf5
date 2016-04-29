import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class AboutWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class AboutWorld extends World
{

    /**
     * Constructor for objects of class AboutWorld.
     * 
     */
    public AboutWorld(){
        super(731, 701, 1); 
        
    }
    
    public AboutWorld(String a)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(731, 701, 1); 
        System.out.println("This is about ka output" + a);
        //Greenfoot.setWorld(new HelpWorld());
    }
    
    public World returnWorld(){
        return new HelpWorld();
    }
}
