import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
import java.awt.Font;
/**
 * Write a description of class Score here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Score extends Actor implements Observer
{
    private int gamescore;
    private Subject player;
    private static int observerIDTracker = 0;
	private int observerID;
    /**
     * Act - do whatever the Score wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */

    public Score(Subject player) 
    {
        this.player = player; 
        this.observerID = observerIDTracker + 1;
        System.out.println("New Observer" + this.observerID);
        
        player.register(this);
    }
   public Score(int score)
    {
        makeImage(score);
    }
    private void makeImage(int score)
    {
            GreenfootImage image = new GreenfootImage(730, 700);
            image.setColor(new Color(255,255,255, 0));
            Font font = image.getFont();
            font = font.deriveFont(72.0f);
            image.setFont(font);
            image.setColor(Color.WHITE);
            image.drawString("" + score, 300, 440);
            setImage(image);
    }
 
	public void update(int score) {
			this.gamescore = score;	
			displayScore();
	}
	
    private void displayScore()
    {
        //System.out.println("score updated" +  gamescore);
        setImage(new GreenfootImage("Score: " + gamescore, 30, java.awt.Color.YELLOW, java.awt.Color.BLACK));
    }
	
	
}
