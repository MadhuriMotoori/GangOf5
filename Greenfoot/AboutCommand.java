/**
 * Write a description of class AboutCommand here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class AboutCommand  implements Command
{
    Receiver aboutReceiver;
    
    public void setReceiver(Receiver newRec)
    {
        this.aboutReceiver = newRec;
    }
    
    public void executeCommand()
    {
        aboutReceiver.performAction();
    }
}
