package MonteCarlo;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client implements Runnable
{
	 
	static int nbrIterations = 25000;
	int placeResultat;
	static int resultats[] = new int[nbrIterations];
	int port;
	static Thread listeThreads[] = new Thread[nbrIterations];
			
	public Client(int port, int placeResultat) {
		this.port = port;
		this.placeResultat = placeResultat;
	}
	
	public void run() {
		
	      try {
	    	  
	          Socket sock = new Socket("localhost", port);
	                  
	          //nous cr�ons donc un flux en �criture
	          BufferedOutputStream bos = new BufferedOutputStream(sock.getOutputStream());
	          
	          //nous �crivons notre requ�te
	          bos.write(String.valueOf(nbrIterations).getBytes());
	          //Vu que nous utilisons un buffer, nous devons utiliser la m�thode flush
	          //afin que les donn�es soient bien �crite et envoy�es au serveur
	          bos.flush();
	          System.out.println("Nombre d'it�rations envoy�es au worker...");
	          
	          //On r�cup�re maintenant la r�ponse du serveur 
	          //dans un flux, comme pour les fichiers...
	          BufferedInputStream bis = new BufferedInputStream(sock.getInputStream());
	          
	          System.out.println("En attente de la r�ponse du worker...");
	          
	          //Il ne nous reste plus qu'� le lire
	          String content = "";
	          int stream;
	          byte[] b = new byte[4096];
	          stream = bis.read(b);
		      content = new String(b, 0, stream);
	         
	          //On affiche la page ! 
	          System.out.println("R�sultat du worker : " + content);
	          resultats[placeResultat] = Integer.valueOf(content);
	          
	       } catch (UnknownHostException e) {
	          e.printStackTrace();
	       } catch (IOException e) {
	          e.printStackTrace();
	       }
	}
	
   public static void main(String[] args){
	   
	   int portDepart = 5126;
	   
	   for (int i = 0; i != 10; i++) {
		   listeThreads[i] = new Thread(new Client((portDepart + i), i));
		   listeThreads[i].start();
	   }
	   
	   for (int i = 0; i != 10; i++) {
		   try {
			listeThreads[i].join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	   }
	   
	   int resultatFinal = 0;
	   
	   for (int i = 0; i != 10; i++) {
		   resultatFinal += resultats[i];
	   }
	   
	   double value = 4.0 * resultatFinal / (nbrIterations * 10);

	   System.out.println("R�sulat final : " + value);
	   
   }   
}