package TP2;

/**
 * 
 */
import java.io.*;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.BufferedReader;
import java.lang.String;

public class Affichage extends Thread {
	
	String texte; 

	public Affichage (String txt){texte=txt;}
	static semaphoreBinaire sem = new semaphoreBinaire(1);

	public void run() {
		
		sem.syncWait();
		System.out.println("J'entre en section critique");
		
		for (int i=0; i<texte.length(); i++) {
			System.out.print(texte.charAt(i));
			try {sleep(100);} catch(InterruptedException e){};
		}
		
		System.out.println("Je sors de section critique");
		sem.syncSignal();
		

	}
}
