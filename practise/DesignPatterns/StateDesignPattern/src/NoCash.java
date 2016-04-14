
public class NoCash implements ATMState{

	ATMMachine atmMachine;
	public NoCash(ATMMachine newATMMachine){
		atmMachine = newATMMachine;
	}
	
	@Override
	public void insertCard() {
		
		System.out.println("Money is not present");
		
	}

	@Override
	public void ejectCard() {
		
		System.out.println("We don't have money.");
		
	}

	@Override
	public void insertPin(int pin) {
		
		System.out.println("We dont have money");
	}

	@Override
	public void requestCash(int cash) {
		
		System.out.println("We dont have money");
	}

}
