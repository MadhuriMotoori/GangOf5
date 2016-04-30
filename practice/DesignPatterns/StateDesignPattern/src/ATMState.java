
public interface ATMState {

	void insertCard();
	void ejectCard();
	void insertPin(int pin);
	void requestCash(int cash);
}
