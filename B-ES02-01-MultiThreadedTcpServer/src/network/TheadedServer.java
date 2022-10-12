/**
 * javac network/TheadedServer.java; java network.TheadedServer 
 */
package network;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;


public class TheadedServer {

	public static void main(String[] args) throws Exception {
	   
		int severPort=8698;
		int count = 0;                  // conta il numero di client
			
		// Listen to port
		System.out.println("Server: in ascolto sula porta " + severPort );
		ServerSocket server = new ServerSocket(8698);

			
		while (true) {
			count++;
			// Start accepting requests and wait until client connects
			Socket serverClientSocket = server.accept();  // bloccante
			System.out.println("Serving Client " + count);
			// Handle the client communication
			ServerApp sa = new ServerApp(serverClientSocket, count);
			sa.start();
			sa.setName("Questo-e-il-mio-ServerThread-Numero-" +count);  
		}
			

	}
}
