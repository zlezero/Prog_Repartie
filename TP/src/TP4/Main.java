package TP4;

public class Main {
	
	public static void main(String[] args) {
		
		BAL moniteur = new BAL();
		
		Consumer lecteur = new Consumer(moniteur);
		Producer ecrivain = new Producer(moniteur);
		
		lecteur.start();
		ecrivain.start();
		
	}
	
}
