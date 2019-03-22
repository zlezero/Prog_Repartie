package MonteCarlo;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Serveur implements Runnable {
	
	 private int port = 5126;
	 private static int nbrIterations = 10000;
	 private String host = "127.0.0.1";
	 private ServerSocket server = null;
	 private boolean isRunning = true;
	 PrintWriter writer;
	 BufferedInputStream reader;
	 
   public static void main(String[] args) {
	   
	   int portDepart = 5126;
	   
	   for (int i = 0; i != 10; i++) {
		   new Thread(new Serveur(portDepart + i)).start();
	   }
         
   }
   
   public Serveur(int port) {
	   this.port = port;
   }
   
   public void run() {
	   
	   try {
           server = new ServerSocket(port);
           System.out.println("Démarrage du Worker sur le port " + port + " !");
        } catch (IOException e) {
           System.err.println("ERREUR : Le port " + port + " est déjà utilisé ! ");
        }
        
        while(isRunning == true) {
            
            try {
            	
               Socket client = server.accept();
               
               System.out.println("[Worker " + port + "] Connexion du master reçue.");
               
               writer = new PrintWriter(client.getOutputStream());
               reader = new BufferedInputStream(client.getInputStream());
               
               String response = read(reader);
               System.out.println("[Worker " + port + "] Nombre d'itérations à faire : " + response);
               
               int nbrIterations = Integer.valueOf(response);
               
       		   double x = 0, y = 0;
       		   int nSuccess = 0;
       		   
       		   for (int i = 1; i <= nbrIterations; i++) {
       			   x = Math.random();
       			   y = Math.random();
       			   if (x * x + y * y <= 1)
       				   nSuccess++;
       		   }
       		          		
               writer.write(String.valueOf(nSuccess));
               writer.flush();
               System.out.println("[Worker " + port + "] Résultat envoyé au master !");
               
            } catch (IOException e) {
               e.printStackTrace();
            }
            
         }
         
         try {
        	System.out.println("[Worker " + port + "] Extinction du worker sur le port : " + port);
            server.close();
         } catch (IOException e) {
            e.printStackTrace();
            server = null;
         }
         
   }
   
   private static String read(BufferedInputStream reader) throws IOException
   {      
	      String response = "";
	      int stream;
	      byte[] b = new byte[4096];
	      stream = reader.read(b);
	      response = new String(b, 0, stream);

	      return response;
	}

}