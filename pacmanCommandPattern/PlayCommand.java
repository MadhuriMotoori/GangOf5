package pacmanCommandPattern;

/**
 * Created by rahilvora on 14/04/16.
 */
public class PlayCommand implements Command{
    Play play;

    PlayCommand(Play play){
        this.play = play;
    }

    public void execute(){
        play.playGame();
    }

}
