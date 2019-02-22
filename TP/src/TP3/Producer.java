package TP3;

import java.util.Scanner;

public class Producer extends Thread {
	
	private BAL bal;
	
	public Producer(BAL bal) {
		this.bal = bal;
	}
	
	public void run() {
		while (true) {
			bal.deposer("Mon mot");
		}
	}
	
	public String saisie() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Entrez un mot :");
		String str = sc.nextLine();
		sc.close();
		return str;
	}
	
}
