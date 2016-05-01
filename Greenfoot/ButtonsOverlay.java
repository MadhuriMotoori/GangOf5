import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
import java.awt.Color;
import java.awt.Font;
public class ButtonsOverlay extends Buttons
{
    protected int ID;
    private boolean selected;
    private int count=1;
    public ButtonsOverlay(int state)
    {
        ID = state; int pState;
        if(ID<12) setImage(new GreenfootImage(77,77));
       
    }
}