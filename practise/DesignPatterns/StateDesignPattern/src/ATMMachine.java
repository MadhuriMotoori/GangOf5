
public class ATMMachine {
	ATMState atmState;
	ATMState hasCard;
	ATMState noCard;
	ATMState hasPin;
	ATMState noCash;
	
	int cashInMachine = 2000;
	boolean correctPinEntered = false;
	
	public ATMMachine(){
		
		hasCard = new HasCard(this);
		noCard = new NoCard(this);
		hasPin = new HasPin(this);
		noCash = new NoCash(this);
		atmState = noCard;
		if(cashInMachine < 0)
			atmState = noCash;
	}
	
	void setATMState(ATMState newATMState){
		atmState = newATMState;
	}
	
	public void setCashInMachine(int newCashInMachine){
		cashInMachine = newCashInMachine;
	}
	
	public void insertCard(){
		atmState.insertCard();
	}
	
	public void ejectCard(){
		atmState.ejectCard();
	}
	public void requestCash(int cashToWithdraw){
		atmState.requestCash(cashToWithdraw);
	}
	public void insertPin(int pinEntered){
		atmState.insertPin(pinEntered);
	}
	
	public ATMState getYesCardState(){
		return hasCard;
	}
	public ATMState getNoCardState(){
		return noCard;
	}
	public ATMState getHasPin(){
		return hasPin;
	}
	public ATMState getNoCashState(){
		return noCash;
	}
}
