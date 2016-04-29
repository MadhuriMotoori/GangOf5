import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Wall here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Wall extends Actor
{
    /**
     * Act - do whatever the Wall wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }  
    public int mapValue;
    public Wall(){
    }
    
    public Wall(int mapValue)
    {
        this.mapValue = mapValue;
        if(mapValue==2) setImage("Wall1.png");
        if(mapValue==3) setImgRtn(180,"Wall1.png");
        if(mapValue==4) setImage("WallEdge.png");
        if(mapValue==5) setImgRtn(90,"WallEdge.png");
        if(mapValue==6) setImgRtn(90,"Wall1.png");
        if(mapValue==7) setImgRtn(270,"Wall1.png");
        if(mapValue==8) setImage("SWallEdge.png");
        if(mapValue==80 || mapValue == 81) setImage("SWallEdge.png");
        if(mapValue==9) setImgRtn(90,"SWallEdge.png");
        if(mapValue==90) setImgRtn(90,"SWallEdge.png");
        if(mapValue==10) setImgRtn(180,"SWallEdge.png");
        if(mapValue==100 || mapValue==101) setImgRtn(180,"SWallEdge.png");
        if(mapValue==11) setImgRtn(270,"SWallEdge.png");
        if(mapValue==110 ) setImgRtn(270,"SWallEdge.png");
        if(mapValue==12) setImage("Corner.png");
        if(mapValue==13) {
            setImage("Corner.png");
            setImgRtn(90,"Corner.png");
        }
        if(mapValue==14) setImgRtn(180,"Corner.png");
        if(mapValue==15) setImgRtn(270,"Corner.png");
        if(mapValue==18) setImage("RCorner.png");
        if(mapValue==19) setImgRtn(180,"RCorner.png");
        if(mapValue==20) setImgRtn(90,"RCorner.png");
        if(mapValue==21) setImgRtn(270,"RCorner.png");
        if(mapValue==22) setImgRtn(0,"Gate.png");
        if(mapValue == 91 || mapValue == 111) setImgRtn(0,"pacman6.png");
    }
    
    public void setImgRtn(int angle,String imageString)
    {
        GreenfootImage image = new GreenfootImage(imageString);
        image.rotate(angle);
        setImage(image);
    }
}
