package pacmanCommandPattern;

/**
 * Created by rahilvora on 14/04/16.
 */
public class Menu {
    Command button;

    public void setButton(Command command){
        button = command;
    }

    public void selectOption(){
        button.execute();
    }
}
