
public class SuperPowerState implements PacManState {

    Player player;
    
    public SuperPowerState(Player newPacManState){
        player = newPacManState;
    }
    
    @Override
    public void eatNormalFood() {
        player.eatingNormalFood();      
    }

    @Override
    public void eatEnemy() {
        int id = player.eatingEnemy();
        if(id !=0){
            player.setEnemyDead(id);
        }
    }

    @Override
    public void eatExoticFood() {
        if(player.eatingExoticFood()){
            //System.out.println("timer should started from 0");
        }
                
    }
    
    public void move(){
        //System.out.println("player is moving in super state");
        player.moveSet();
        player.port();
        //if(
    }

}
