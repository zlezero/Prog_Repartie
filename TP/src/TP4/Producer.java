package TP4;

import java.util.Random;
import java.util.Scanner;

public class Producer extends Thread {
	
	private BAL bal;
	int numLettre = 0;
	
	public Producer(BAL bal) {
		this.bal = bal;
	}
	
	public void run() {
		String saisie;
		
		while (true) {
			
			saisie = genererLettreOrdre();
			
			try {
				bal.deposer(saisie);
			
			/*if (bal.deposer(saisie)) {
				System.out.println("[Producteur] Je dépose la lettre : " + saisie);
			} else {
				System.out.println("[Producteur] La BAL est pleine !");
			}*/
			
				//Thread.sleep(300);
			}
			catch (InterruptedException e) {
				System.out.println("[Producteur] La BAL est pleine !");
			}
		}
		
	}
	
	public String saisie() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Entrez un mot :");
		String str = sc.nextLine();
		return str;
	}
	
	public String genererLettreAleatoire() {
		Random rand = new Random();
		char c = (char)(rand.nextInt(26) + 97);
		return String.valueOf(c);
	}
	
	public String genererLettreOrdre() {
		char c = (char)(numLettre + 97);
		numLettre = (numLettre + 1) % 26;
		return String.valueOf(c);
	}
	
}
