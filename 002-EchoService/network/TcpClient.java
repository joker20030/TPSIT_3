/**
 * from network/..
 * javac network/TcpClient.java
 * java network.TcpClient */
package network;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;
//import java.util.Scanner;

public class TcpClient {
	public static void main(String[] args) throws Exception {
		
		String severAddress="127.0.0.1";  // localhost
		int severPort=8765;
		String clientMsg = "";
		String serverMsg = "";
		
		try {
			// Create connection to server socket
			System.out.print("Client: Connessione al server=" + severAddress + ":" + severPort + " ... ");
			Socket socket = new Socket(severAddress, severPort); 
			System.out.println("Connected");

			// Create input and output streams to read/write data
			// Input stream tramite la classe java Scanner per i dati inseriti dall'utente 
			BufferedReader inUserStream = new BufferedReader(new InputStreamReader(System.in));
			//Scanner scanner = new Scanner(System.in);
			// Input stream per i dati provenienti dal socket 
			DataInputStream inStream = new DataInputStream(socket.getInputStream());
			// Output stream 
			DataOutputStream outStream = new DataOutputStream(socket.getOutputStream());
			
			while (!clientMsg.equals("quit")) {
				// Prompt user to enter some text or 'quit'
				System.out.print("Client: inserisci il messaggio da inviare> ");
				//clientMsg = scanner.nextLine();
				clientMsg = inUserStream.readLine();

				// Send the entered number to server
				System.out.println("Client: invio il messaggio: " + clientMsg);
				outStream.writeUTF(clientMsg);
				outStream.flush();

				// Read data from socket input stream
				serverMsg = inStream.readUTF();
				System.out.println("Client: ricevuto il messaggio: " + serverMsg);
			}

			// Close resources
			outStream.close();
			inStream.close();
			socket.close();
			inUserStream.close();
			//scanner.close();			
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
