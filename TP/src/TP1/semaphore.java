package TP1;

public abstract class semaphore {

    protected int valeur=0;

    protected semaphore (int valeurInitiale){
    	valeur = valeurInitiale>0 ? valeurInitiale:0;
    }

    public synchronized void syncWait() {
		try {
			System.out.println("J'entre en section critique avec valeur = " + valeur);
		    while(valeur<=0){
		    	wait();
	        }
		    valeur--;
		} catch(InterruptedException e){}
    }

    public synchronized void syncSignal(){
		System.out.println("Je sors de section critique avec valeur = " + valeur);
    	if(++valeur > 0) notifyAll();
    }
}
