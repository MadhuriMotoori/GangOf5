import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
import java.awt.Font;
import java.util.Calendar;

public class Menu extends Actor
{
    public Menu() 
    {
    }
    public Menu(int ID)
    {
        switch(ID) {
            case 7: makeImage("Game Over ", "   Your score is: ");
            break;
        }
    }
    private void makeImage(String title, String prefix)
    {
        GreenfootImage img = new GreenfootImage(730, 700);
        img.setColor(new Color(0,0,0, 128));
        img.fillRect(0, 0, 730, 700);
        Font ft = img.getFont();
        ft = ft.deriveFont(72.0f);
        img.setFont(ft);
        img.setColor(Color.WHITE);
        img.drawString(title, 200, 200);
        img.drawString(prefix, 100, 300);
        setImage(img);
    }
}