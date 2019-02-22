package TP3;

public class Consumer extends Thread {
	
	private BAL bal;
	
	public Consumer(BAL bal) {
		this.bal = bal;
	}
	
	public void run() {
		while (true) {
			bal.retirer();
		}
	}
	
}
