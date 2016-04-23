/**
 * Write a description of class HelpCommand here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HelpCommand implements Command
{
    Receiver helpReceiver;
    
    public void setReceiver(Receiver newRec)
    {
        this.helpReceiver = newRec;
    }
    
    public void executeCommand()
    {
        helpReceiver.performAction();
    }
}



