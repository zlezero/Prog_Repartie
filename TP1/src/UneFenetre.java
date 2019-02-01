import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

class UneFenetre extends JFrame implements ActionListener
{
    UnMobile sonMobile;
    private final int LARG=400, HAUT=250;
    
    JButton boutons[] = new JButton[1];
    GridLayout layout = new GridLayout();
    Thread thr;
    
    boolean isThreadStart = true;
    
    public UneFenetre()
    {
    	
    	super("Le mobile");
    	this.setVisible(true);
    	this.setSize(1000, 1000);
    	
    	JPanel panel = new JPanel();    	
    	panel.setLayout(layout);   

    	sonMobile = new UnMobile(LARG, HAUT);
    	thr = new Thread(sonMobile, "run");
    	thr.start();
    	
    	panel.add(sonMobile);
    	
    	for (int i = 0; i != boutons.length; i++) {
    		boutons[i] = new JButton("Suspendre / Reprendre");
    		boutons[i].addActionListener(this);
    		panel.add(boutons[i]);
    	}
    	    	
    	this.add(panel);
    	
    }

	public void actionPerformed(ActionEvent arg0) {
		if (isThreadStart) {
			thr.suspend();
			isThreadStart = false;
		}
		else {
			thr.resume();
			isThreadStart = true;
		}
	}
}
