

public class ScoreController implements Observer{

	private static int observerIDTracker = 0;
	private int observerID;
	private Subject EnemyKiller;
	private int score;
	
	public ScoreController(Subject enemyKiller){
	     this.EnemyKiller = enemyKiller;
	     this.observerID = ++observerIDTracker;
	     System.out.println("New Observer " + this.observerID);	      
	     enemyKiller.register(this);
	}

	@Override
	public void update(int score) {
			this.score = score;	
			printTheScore();
	}

	  
	 public void printTheScore(){  
	     System.out.println(observerID + "\nScore: " + score);
	 }
}