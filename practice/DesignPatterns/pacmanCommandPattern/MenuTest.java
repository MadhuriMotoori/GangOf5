package pacmanCommandPattern;

/**
 * Created by rahilvora on 14/04/16.
 */
public class MenuTest {
    public static void main(String[] args){
        Menu menu = new Menu();
        Play play = new Play();
        About about = new About();
        Exit exit =  new Exit();

        PlayCommand playCommand = new PlayCommand(play);
        AboutCommand aboutCommand = new AboutCommand(about);
        ExitCommand  exitCommand = new ExitCommand(exit);

        menu.setButton(playCommand);
        menu.selectOption();
        menu.setButton(aboutCommand);
        menu.selectOption();
        menu.setButton(exitCommand);
        menu.selectOption();
    }
}
