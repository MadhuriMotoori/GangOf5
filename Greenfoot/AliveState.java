
public class AliveState implements PacManState {

    Player player;
    
    public AliveState(Player newPacManState){
        player = newPacManState;
    }
    
    @Override
    public void eatNormalFood() {
        player.eatingNormalFood();
    }

    @Override
    public void eatEnemy() {
        if(player.eatingEnemy() != 0){
            //System.out.println("Player is dead");
            player.setPacManState(player.getDeadState());
        }
        
        
    }

    @Override
    public void eatExoticFood() {
        
        if(player.eatingExoticFood()){
            player.setPacManState(player.getSuperPowerState());
            //System.out.println("initiate timer");
        }       
    }

    @Override
    public void move() {
        //System.out.println("Player is moving");
        player.moveSet();
        player.port();
    }
    
    
}
