/**
 * from network/..
 * javac network/TcpClient.java
 * java network.TcpClient */

package network;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class TcpClient {
	public static void main(String[] args) throws Exception {
		
		String severAddress="127.0.0.1";  // localhost
		int severPort=8765;
		String clientMessage = "";
		String serverMessage = "";
		
		try {
			// Create connection to server socket
			System.out.print("Client: Connessione al server=" + severAddress + ":" + severPort + " ... ");
			Socket socket = new Socket(severAddress, severPort); 
			System.out.println("Connected");

			// Create input and output streams to read/write data
			// Input stream tramite la classe java Scanner per i dati inseriti dall'utente 
			//BufferedReader inUserStream = new BufferedReader(new InputStreamReader(System.in));
			Scanner scanner = new Scanner(System.in);
			// Input stream per i dati provenienti dal socket 
			DataInputStream inStream = new DataInputStream(socket.getInputStream());
			// Output stream 
			DataOutputStream outStream = new DataOutputStream(socket.getOutputStream());
			
			while (!clientMessage.equals("end")) {
				// Prompt user to enter some number or 'end'
				System.out.print("Client: inserisci il messaggio da inviare> ");
				clientMessage = scanner.nextLine();
				//clientMessage = inUserStream.readLine();

				// Send the entered number to server
				System.out.println("Client: invio il messaggio: " + clientMessage);
				outStream.writeUTF(clientMessage);
				outStream.flush();

				// Read data from socket input stream
				serverMessage = inStream.readUTF();
				System.out.println("Client: ricevuto il messaggio: " + serverMessage);
			}

			// Close resources
			outStream.close();
			outStream.close();
			socket.close();
			scanner.close();			
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
