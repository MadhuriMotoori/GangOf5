
public class HasCard implements ATMState{

	ATMMachine atmMachine;
	
	public HasCard(ATMMachine newATMMachine){
		atmMachine = newATMMachine;
	}
	@Override
	public void insertCard() {
		System.out.println("Card was already inserted");
		
	}

	@Override
	public void ejectCard() {
		System.out.println("Card Ejected");
		atmMachine.setATMState(atmMachine.getNoCardState());
	}

	@Override
	public void insertPin(int pinEntered) {
		if(pinEntered == 1234){
			System.out.println("Correct pin");
			atmMachine.correctPinEntered = true;
			atmMachine.setATMState(atmMachine.getHasPin());
		}
		else {
			System.out.println("Wrong Pin");
			atmMachine.correctPinEntered = false;
			System.out.println("Card Eject");
			atmMachine.setATMState(atmMachine.getNoCardState());
		}
		
	}

	@Override
	public void requestCash(int cashToWithdraw) {
		System.out.println("Enter PIN first");
		
	}

}
