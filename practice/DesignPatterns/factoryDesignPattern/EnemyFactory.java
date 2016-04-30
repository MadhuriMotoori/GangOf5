package factoryDesignPattern;

public class EnemyFactory {

	public EnemyShip setEnemyShip(String ship)
	{
		if(ship.equals("sfo"))
			return new BigSfoEnemyShip(); 
		if(ship.equals("ufo"))
			return new BigUfoEnemyship();
		else
			return null;
		
	}
	
}
