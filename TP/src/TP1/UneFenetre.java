package TP1;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

class UneFenetre extends JFrame implements ActionListener
{
    private final int LARG=400, HAUT=250, NBRLIG = 6, NBRCOL = 2;
    
    JButton boutons[] = new JButton[NBRLIG];
    UnMobile mobiles[] = new UnMobile[NBRLIG];
    Thread threads[] = new Thread[NBRLIG];
    boolean statusThreads[] = new boolean[NBRLIG];
        
    public UneFenetre()
    {
    	
    	super("Le mobile");
    	this.setVisible(true);
    	this.setSize(1000, 1000);
    	
    	Container leConteneur = getContentPane();
    	leConteneur.setLayout(new GridLayout(NBRLIG, NBRCOL));
    	    	
    	for (int i = 0; i!= mobiles.length; i++) {
    		
    		mobiles[i] = new UnMobile(LARG, HAUT);
    		leConteneur.add(mobiles[i]);
    		
    		boutons[i] = new JButton("Suspendre / Reprendre");
    		boutons[i].addActionListener(this);
    		leConteneur.add(boutons[i]);
    		
    		threads[i] = new Thread(mobiles[i], "run");
    		threads[i].start();
    		
    		statusThreads[i] = true;
    	}
    	
    }

	public void actionPerformed(ActionEvent arg0) {
				
		for (int i = 0; i != NBRLIG; i++) {
			
			if (arg0.getSource().equals(boutons[i])) {
								
				if (statusThreads[i]) {
					threads[i].suspend();
					statusThreads[i] = false;
				}
				else {
					threads[i].resume();
					statusThreads[i] = true;
				}
				
			}
			
		}
		
	}
}
