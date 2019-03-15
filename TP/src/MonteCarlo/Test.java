package MonteCarlo;

import java.util.Arrays;
import java.util.concurrent.ExecutionException;

public class Test {
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		long startTimeCode1 = 0;
		long startTimeCode2 = 0;

		long stopTimeCode1 = 0;
		long stopTimeCode2 = 0;

		double piValue;
		
		
		PiMonteCarlo PiVal = new PiMonteCarlo(100000);

		System.out.println("=== EXPERIENCE 1 ===");
		
		startTimeCode1 = System.currentTimeMillis();

		for (int i = 0; i != 10; i++) {
			
			//piValue = PiVal.getPi();
			
		}
		
		stopTimeCode1 = System.currentTimeMillis();
		
		double pi = 0.0;
		
		startTimeCode2 = System.currentTimeMillis();

		for (int i = 0; i != 10; i++) {
			pi = new Master().doRun(1048576, 128);
		}
		
		stopTimeCode2 = System.currentTimeMillis();

		//System.out.println("Temps code 1 : " + (stopTimeCode1 - startTimeCode1) + " ms");
		System.out.println("Erreur " + (pi - Math.PI));

		System.out.println("Temps code 2 : " + (stopTimeCode2 - startTimeCode2) + " ms");
/*
		System.out.println("=== EXPERIENCE 2 ===");
		
		for (int i = 0; i != 10; i++) {
			
			startTimeCode1[i] = System.currentTimeMillis();
			piValue = PiVal.getPi();
			stopTimeCode2[i] = System.currentTimeMillis();
			
			startTimeCode2[i] = System.currentTimeMillis();
			new Master().doRun(250000, 4);
			stopTimeCode2[i] = System.currentTimeMillis();

		}
		
		System.out.println("Temps médian code 1 : " + (median(stopTimeCode1) - median(startTimeCode1)) + " ms");
		System.out.println("Temps médian code 2 : " + (median(stopTimeCode2) - median(startTimeCode2)) + " ms");

		System.out.println("=== EXPERIENCE 3 ===");
		
		for (int i = 0; i != 10; i++) {
			
			startTimeCode1[i] = System.currentTimeMillis();
			piValue = PiVal.getPi();
			stopTimeCode2[i] = System.currentTimeMillis();
			
			startTimeCode2[i] = System.currentTimeMillis();
			new Master().doRun(200000, 5);
			stopTimeCode2[i] = System.currentTimeMillis();

		}
		
		System.out.println("Temps médian code 1 : " + (median(stopTimeCode1) - median(startTimeCode1)) + " ms");
		System.out.println("Temps médian code 2 : " + (median(stopTimeCode2) - median(startTimeCode2)) + " ms");

		
		System.out.println("=== EXPERIENCE 4 ===");

		for (int i = 0; i != 10; i++) {
			
			startTimeCode1[i] = System.currentTimeMillis();
			piValue = PiVal.getPi();
			stopTimeCode2[i] = System.currentTimeMillis();
			
			startTimeCode2[i] = System.currentTimeMillis();
			new Master().doRun(100000, 10);
			stopTimeCode2[i] = System.currentTimeMillis();

		}
		
		System.out.println("Temps médian code 1 : " + (median(stopTimeCode1) - median(startTimeCode1)) + " ms");
		System.out.println("Temps médian code 2 : " + (median(stopTimeCode2) - median(startTimeCode2)) + " ms");
*/
	}

}
