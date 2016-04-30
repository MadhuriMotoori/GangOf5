package pacmanCommandPattern;

/**
 * Created by rahilvora on 14/04/16.
 */
public class AboutCommand implements Command {
    About about;

    AboutCommand(About about){
        this.about = about;
    }

    public void execute(){
        about.openAbout();
    }
}
