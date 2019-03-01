package TP4;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BAL {
	
    private BlockingQueue<String> queue =  new ArrayBlockingQueue<String>(20) ;
    
    public void deposer(String mot) throws InterruptedException {
    	
    	queue.put(mot);
		System.out.println("[Producteur] Je d�pose la lettre : " + mot);

    }
    
    public void retirer() throws InterruptedException {
    	String lettre = queue.take();
    	if (lettre != null) {
			System.out.println("[Consommateur] Je prend la lettre : " + lettre);
		} else {
			System.out.println("[Consommateur] Il n'y a pas de lettres dans la BAL !");
		}
    }
    
}
