
public class DeadState implements PacManState {

	Player player;
	
	public DeadState(Player newPacManState){
		player = newPacManState;
	}
	
	@Override
	public void eatNormalFood() {
		//System.out.println("You are dead, u can't eat");
		
	}

	@Override
	public void eatEnemy() {
		//System.out.println("You are dead, u can't eat... R u a Ghost ?:O");
	
		
	}

	@Override
	public void eatExoticFood() {
		// TODO Auto-generated method stub
		//System.out.println("You are a nut");
	}
	
	@Override
	public void move() {
		//System.out.println("You are dead you cannot move");
	}

}
