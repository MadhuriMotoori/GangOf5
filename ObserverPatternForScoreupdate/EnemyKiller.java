import java.util.ArrayList;


public class EnemyKiller implements Subject {

	private ArrayList<Observer> observers;
	private int score;
	
	public EnemyKiller(){
		observers = new ArrayList<Observer>();
	}

	@Override
	public void register(Observer o) {
		// TODO Auto-generated method stub
		observers.add(o);
	}

	@Override
	public void unregister(Observer o) {

	     int observerIndex = observers.indexOf(o);
	     System.out.println("Observer " + (observerIndex+1) + " deleted");
	      
	     observers.remove(observerIndex);
	}

	@Override
	public void notifyObserver() {
		// TODO Auto-generated method stub
	     for(Observer observer : observers){
	         observer.update(score);
	     }
	}

	 public void setScore(int newscore){
	     this.score = newscore;
	     notifyObserver();
	 }
	  
}


