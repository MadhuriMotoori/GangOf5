package pacmanCommandPattern;

/**
 * Created by rahilvora on 14/04/16.
 */
public class ExitCommand implements Command{
    Exit exit;

    ExitCommand(Exit exit){
        this.exit = exit;
    }

    public void execute(){
        exit.exitGame();
    }
}
