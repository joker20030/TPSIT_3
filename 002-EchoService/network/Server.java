/**
 * from network/..
 * javac network/Server.java
 * java network.Server */
package network;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static void main(String[] args) throws Exception {
		int severPort=8698;
		String clientMessage = "";
		
		try {			 
			// Listen to port
			ServerSocket server = new ServerSocket(severPort);
			System.out.println("Server: in ascolto sula porta " + severPort);
			Socket serverClientSocket = server.accept();
			
			// Input/Output dei dati
			DataInputStream inStream = new DataInputStream(serverClientSocket.getInputStream());
			DataOutputStream outStream = new DataOutputStream(serverClientSocket.getOutputStream());	

			// Scambio di dati tra client e server
			while(!clientMessage.equals("end")) {
				clientMessage = inStream.readUTF();
				System.out.println("Server: ricevuto messaggio " + clientMessage );
				System.out.println("Server: invio messaggio "    + clientMessage );
				outStream.writeUTF("Echo from server : "         + clientMessage);
				outStream.flush();
			}

			// Chiusura del socket
			server.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
