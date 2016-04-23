import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Ghost here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ghost extends Actor
{
    
    private boolean left;
    private boolean right;
    private int moveCounter = 0;
    private int setImage = 1;
    private int ID;
     public void act() 
    {
        
        if(getWorld().getClass().toString().equals("class MenuWorld")) {
            System.out.println("entered");
            motionSet();
        }
    }
    
    private void motionSet()
    {
        int x=getX(); int y=getY();
        if(y==345) {
            left=true; right=false;
        }
        if(y==475) {
            left=false; right=true;
        }
        if(x==0 && y==345) setLocation(3,475);
        if(x==331 && y==475) setLocation(644, 345);
        motionMove(); motionImage();
    }
    private void motionMove()
    {
        if(left) setLocation(getX()-2,getY());
        else if(right) setLocation(getX()+2,getY());
    }
    private void motionImage()
    {
        int y=getY();
        if(moveCounter==10) {
            if(y==345) {
                if(setImage==1) {
                    setImage(getGhostSubimage("L2")); setImage=2;
                }
                else {
                    setImage(getGhostSubimage("L")); setImage=1;
                }
            }
            if(y==475) {
                if(setImage==1) {
                    setImage(new GreenfootImage("GhostEatable.png")); setImage=2;
                }
                else {
                    setImage(new GreenfootImage("GhostEatable3.png")); setImage=1;
                }
            }
            moveCounter=0;
        }
        else moveCounter=moveCounter+1;
    }
    
    public GreenfootImage getGhostSubimage(String subimage)
    {
        return new GreenfootImage("Ghost"+ID+subimage+".png");
    }
}
