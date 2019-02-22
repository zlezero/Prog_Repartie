package TP3;

public class BAL {
	
	private String mot = "Ceci est un mot";
	private boolean estLibre = true;
	private boolean quit;
	
	public synchronized void deposer(String mot) {
		
		while (estLibre) {
			try {
				wait();
			} catch (InterruptedException e) {}
		}
		
		
		
		System.out.println("Je dépose le mot : " + mot);
		this.mot = mot;
		
		estLibre = true;
		notifyAll();
		
		if (mot.equals("Q")) {
			Thread.currentThread().interrupt();
		}
	}
	
	public synchronized void retirer() {
		
		while (!estLibre) {
			try {
				wait();
			} catch (InterruptedException e) {}
		}
				
		System.out.println("Je retire le mot : " + this.mot);
		
		estLibre = false;
		notifyAll();
		
		if (this.mot.equals("Q")) {
			Thread.currentThread().interrupt();
		}
	}
	
}
