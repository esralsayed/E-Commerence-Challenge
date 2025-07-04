package exceptions;

public class LowBalance extends Exception {
	public LowBalance() {
		super();
	}

	public LowBalance(String msg) {
		super(msg);
	}
}
