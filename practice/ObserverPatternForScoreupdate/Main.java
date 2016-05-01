


public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	      EnemyKiller enemykiller = new EnemyKiller();
	      ScoreController observer1 = new ScoreController(enemykiller);
	      
	      enemykiller.setScore(100);
	}

}
