/**
 * javac network/TheadedServer.java; java network.TheadedServer 
 */
package network;

import java.net.ServerSocket;
import java.net.Socket;


public class MultithreadedTcpServer {

	static final int MAX_CONN = 99;
	public static void main(String[] args) throws Exception {
	   
		int severPort=8698;
		int count = 0;                  // conta il numero di client
			
		// Listen to port
		System.out.println("Server: in ascolto sula porta " + severPort );
		ServerSocket server = new ServerSocket(8698);
	
		while(count<MAX_CONN) {
			count++;
			// Start accepting requests and wait until client connects
			Socket serverClientSocket = server.accept();  // bloccante
			System.out.println("Serving Client " + count);
			// Handle the client communication
			TcpServer sa = new TcpServer(serverClientSocket, count);
			sa.start();
			sa.setName("Questo-e-il-mio-ServerThread-Numero-" +count);  
		}
		
		server.close();
	}
}
