package TP1;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

class UnMobile extends JPanel implements Runnable
{
    int saLargeur, saHauteur, sonDebDessin;
    final int sonPas = 10, sonTemps=50, sonCote=40;    
    static semaphoreGeneral sem = new semaphoreGeneral(2);
    Color couleurRect;
    
    UnMobile(int telleLargeur, int telleHauteur)
    {
    	super();
    	saLargeur = telleLargeur;
    	saHauteur = telleHauteur;
    	setSize(telleLargeur, telleHauteur);
    }

    public void run()
    {	
    	while (true) {
    		
    		for (sonDebDessin=0; sonDebDessin < (0.33 * saLargeur) - sonPas; sonDebDessin+= sonPas)
    		{
    				repaint();
    				
    				try {
    					Thread.sleep(sonTemps);
    				}
    				catch (InterruptedException telleExcp)
    			    {
    					telleExcp.printStackTrace();
    			    }
    		}
    		    		
    		sem.syncWait();
    		
    		couleurRect = Color.red;
    		
    		for (; sonDebDessin < (0.67 * saLargeur) - sonPas; sonDebDessin+= sonPas)
    		{
    				repaint();
    				
    				try {
    					Thread.sleep(sonTemps);
    				}
    				catch (InterruptedException telleExcp)
    			    {
    					telleExcp.printStackTrace();
    			    }
    		}
    		
    		couleurRect = Color.black;

    		sem.syncSignal();
    		
    		for (; sonDebDessin < saLargeur - sonPas; sonDebDessin+= sonPas)
    		{
    				repaint();
    				
    				try {
    					Thread.sleep(sonTemps);
    				}
    				catch (InterruptedException telleExcp)
    			    {
    					telleExcp.printStackTrace();
    			    }
    		}
    		
    		//Retour
    		
    		for (sonDebDessin = saLargeur; sonDebDessin > (0.67 * saLargeur) + sonPas; sonDebDessin-= sonPas)
    		{
    				repaint();
    				
    				try {
    					Thread.sleep(sonTemps);
    				}
    				catch (InterruptedException telleExcp)
    			    {
    					telleExcp.printStackTrace();
    			    }
    		}
    		
    		sem.syncWait();
    		
    		couleurRect = Color.red;
    		
    		for (; sonDebDessin > (0.33 * saLargeur) + sonPas; sonDebDessin-= sonPas)
    		{
    				repaint();
    				
    				try {
    					Thread.sleep(sonTemps);
    				}
    				catch (InterruptedException telleExcp)
    			    {
    					telleExcp.printStackTrace();
    			    }
    		}
    		
    		couleurRect = Color.black;

    		sem.syncSignal();
    		
    		for (; sonDebDessin > 0; sonDebDessin-= sonPas)
    		{
    				repaint();
    				
    				try {
    					Thread.sleep(sonTemps);
    				}
    				catch (InterruptedException telleExcp)
    			    {
    					telleExcp.printStackTrace();
    			    }
    		}
    	}

		
    }

    public void paintComponent(Graphics telCG)
    {
    	super.paintComponent(telCG);
    	telCG.setColor(couleurRect);
    	telCG.fillRect(sonDebDessin, saHauteur/2, sonCote, sonCote);
    	telCG.setColor(Color.black);
    	telCG.drawLine((int)(0.33 * saLargeur) + sonPas, 0, (int)(0.33 * saLargeur) + sonPas, saHauteur);
    	telCG.drawLine((int)(0.67 * saLargeur) - sonPas, 0, (int)(0.67 * saLargeur) - sonPas, saHauteur);
    }

}