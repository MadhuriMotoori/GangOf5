import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Buttons here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Buttons extends Actor implements Invoker
{
    protected int ID;
    public boolean muteS = false;
    public boolean musicS = false;
    private boolean selected;
    
    Command newButtonCommand;
    /**
     * Act - do whatever the Buttons wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
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
    
    public void act() 
    {
        checkMouse();
    }    
    
    private void checkMouse()
    {
        if (Greenfoot.mouseMoved(null)) {
            if (Greenfoot.mouseMoved(this) && !selected) {
                switch(ID) {
                    case 1: setImage(new GreenfootImage("1 player selected.png"));
                    break;
                    case 2: setImage(new GreenfootImage("2 player selected.png"));
                    break;
                    case 3: setImage(new GreenfootImage("About selected.png"));
                    break;
                    case 4: setImage(new GreenfootImage("Help selected.png"));
                    break;
                    case 7: setImage(new GreenfootImage("resume selected.png"));
                    break;
                    case 8: setImage(new GreenfootImage("retry selected.png"));
                    break;
                }
                selected =true;
            }
            if (!Greenfoot.mouseMoved(this) && selected) {
                switch(ID) {
                    case 1: setImage(new GreenfootImage("1 player.png"));
                    break;
                    case 2: setImage(new GreenfootImage("2 player.png"));
                    break;
                    case 3: setImage(new GreenfootImage("About.png"));
                    break;
                    case 4: setImage(new GreenfootImage("Help.png"));
                    break;
                    case 7: setImage(new GreenfootImage("resume.png"));
                    break;
                    case 8: setImage(new GreenfootImage("retry.png"));
                    break;
                }
                selected = false;
            }
        }
        checkClicked();
    }
    
    public void checkClicked()
    {
        MouseInfo info = Greenfoot.getMouseInfo();
        if(info!=null) {
            int clicked = info.getButton();
            if(Greenfoot.mouseClicked(this) && clicked==1) {
                click();
            }
        }
    }
    
        /**
     * click on this button to start the game
     */
    public void click()
    {
        newButtonCommand.executeCommand();
    }
    
    /**
     * Method to set command
     */
    public void setCommand(Command newCmd)
    {
        this.newButtonCommand = newCmd;
    }
}


