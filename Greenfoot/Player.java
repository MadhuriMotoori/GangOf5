import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Actor
{
    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }  
    
    private void foodRefiller()
    {
        setLocation(365, 440); 
        setRotation(0); 
        int[][] map = {
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
        for(int x=0; x<map.length; x++) {
            for(int y=0; y<map[x].length; y++) {
                if(map[x][y]==16) {
                    getWorld().addObject(new Food1(), y*15+50, x*15+50);
                }
                if(map[x][y]==17) {
                    getWorld().addObject(new Food2(), y*15+50, x*15+50);
                }
            }
        }
        
    }
}
