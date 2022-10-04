/**
 * Lettura dati multi riga dal client
 * modificare il codice affinche quando riceve due righe vuote di codice esca
 * from network/..
 * javac network/TcpServer.java
 * java network.TcpServer */
package network;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServer {
	public static void main(String[] args) throws Exception {
		
		int severPort=8765;
		String clientMsg = "";
		
		try {			 
			// Creazione del socket sul server e ascolto sulla porta
			ServerSocket serverSocket = new ServerSocket(severPort);
			System.out.println("Server: in ascolto sulla porta " + severPort);

			// Attesa della connessione con il client
			System.out.println("Attesa ricezione dati dal client ....................... \n\n");
			Socket clientSocket = serverSocket.accept();
			
			// Create output stream to write data
            PrintWriter outStream = new PrintWriter(clientSocket.getOutputStream(), true);   
			// Create input stream to read data from socket
			BufferedReader inStream = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            // Ciclo di ricezione dal client e echo
            while (true) {   
				//Lettura dati dal client un righa alla volta    
                clientMsg = inStream.readLine();		
				System.out.println("Server: ricevuto messaggio " + clientMsg );	
				
				//Invio dati su stream di rete
				System.out.println("Server: invio messaggio "    + clientMsg );
                outStream.println(clientMsg);    

                if (clientMsg.equals("END")) break;  
			}  

			System.out.println("\n\n....................... Fine ricezione dati");

			// Close resources
			serverSocket.close();
			clientSocket.close();
			inStream.close();
			outStream.close();

		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
