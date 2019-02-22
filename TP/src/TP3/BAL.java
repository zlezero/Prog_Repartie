package TP3;

public class BAL {
	
	private String mot = "Ceci est un mot";
	private boolean estLibre = true;
	
	public synchronized void deposer(String mot) {
		
		while (estLibre) {
			try {
				wait();
			} catch (InterruptedException e) {}
		}
		
		this.mot = mot;
		
		estLibre = true;
		notifyAll();
		
	}
	
	public synchronized void retirer() {
		
		while (!estLibre) {
			try {
				wait();
			} catch (InterruptedException e) {}
		}
		
		System.out.println("Je retire le mot : " + this.mot);
		mot = null;
		

		estLibre = false;
		notifyAll();
		
	}
	
}
