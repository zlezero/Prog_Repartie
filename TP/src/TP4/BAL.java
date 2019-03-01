package TP4;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BAL {
	
    private BlockingQueue<String> queue =  new ArrayBlockingQueue<String>(20) ;
    
    public void deposer(String mot) throws InterruptedException {
    	
    	queue.put(mot);
		System.out.println("[Producteur] Je dépose la lettre : " + mot);
	
    }
    
    public String retirer() throws InterruptedException {
    	
    	return queue.take();

    }
    
}
