/**
 * Write a description of class PlayCommand here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class normalStrategyCommand implements Command
{
    Receiver playReceiver;
    
    public void setReceiver(Receiver newRec)
    {
        this.playReceiver = newRec;
    }
    
    public void executeCommand()
    {
        playReceiver.performAction();
    }
}
