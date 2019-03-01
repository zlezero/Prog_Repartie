package TP4;

public class Consumer extends Thread {
	
	private BAL bal;
	
	public Consumer(BAL bal) {
		this.bal = bal;
	}
	
	public void run() {
		
		String lettre;
		
		while (true) {		
			
			try {
				bal.retirer();
				Thread.sleep(1500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
				
	}
	
}
