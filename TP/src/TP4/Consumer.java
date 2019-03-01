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
				
				lettre = bal.retirer();
		    	
		    	if (lettre != null) {
					System.out.println("[Consommateur] Je prend la lettre : " + lettre);
				} else {
					System.out.println("[Consommateur] Il n'y a pas de lettres dans la BAL !");
				}
		    	
				Thread.sleep(1500);
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
				
	}
	
}
