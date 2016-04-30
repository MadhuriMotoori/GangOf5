package factoryDesignPattern;

import java.util.Scanner;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EnemyFactory enemy= new EnemyFactory();
		EnemyShip enemyship=null;
		Scanner in=new Scanner(System.in);
        String name;
        System.out.println("Please enter enemy ship name sfo/ufo ");
        name=in.nextLine();
        enemyship=enemy.setEnemyShip(name);
        dostuff(enemyship);
		

	}

	private static void dostuff(EnemyShip enemyship) {
		// TODO Auto-generated method stub
		System.out.println("below are details of enemy ship :"+enemyship.getShipname());
		System.out.println(" Damage done by me is "+enemyship.getDamage());
		System.out.println(" Speed of mine  is "+enemyship.getSpeed());
		
	}

}
