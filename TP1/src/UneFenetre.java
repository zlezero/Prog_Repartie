import java.awt.*;
import javax.swing.*;

class UneFenetre extends JFrame 
{
    UnMobile sonMobile;
    private final int LARG=400, HAUT=250;
    
    public UneFenetre()
    {
    	
    // TODO 
	// ajouter sonMobile a la fenetre
	// creer une thread laThread avec sonMobile
	// afficher la fenetre
	// lancer laThread
    	
    	super("Le mobile");
    	this.setVisible(true);
    	this.setSize(1000, 1000);
    	
    	sonMobile = new UnMobile(LARG, HAUT);
    	this.add(sonMobile);
   
    	Thread thr = new Thread(sonMobile, "run");
    	thr.start();
    	
    	
    }
}
