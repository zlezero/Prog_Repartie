package TP2;

import java.io.*;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.BufferedReader;
import java.lang.String;

public class Main {

	public static void main(String[] args) {
		
		semaphoreBinaire sem = new semaphoreBinaire(1);
		
		Affichage TA = new Affichage("AAA");
		Affichage TB = new Affichage("BB");

		TB.start();
		TA.start();
		
	}

}
