import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class NormalStrategy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class NormalStrategy extends World implements Strategy 
{

    /**
     * Constructor for objects of class NormalStrategy.
     * 
     */
    public NormalStrategy()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
    }
    
    public World getWorld(){
        return new GodWorld();
    }
    
    
}
