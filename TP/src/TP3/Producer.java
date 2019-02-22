package TP3;

import java.util.Scanner;

public class Producer extends Thread {
	
	private BAL bal;
	
	public Producer(BAL bal) {
		this.bal = bal;
	}
	
	public void run() {
		
		String str = "";
		
		while (true) {			
			bal.deposer(saisie());
		}
				
	}
	
	public String saisie() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Entrez un mot :");
		String str = sc.nextLine();
		return str;
	}
	
}
