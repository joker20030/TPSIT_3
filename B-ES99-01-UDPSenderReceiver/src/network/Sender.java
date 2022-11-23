/**
 * from network/..
 * javac network/Sender.java; java network.Sender 
 */
package network;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Sender {

	public static void main(String[] args) throws IOException {
		int receiverPort=8698;
		System.out.println("Sender: starting on port " + receiverPort);
		// Datagram socket that binds to any available port in localhost
		DatagramSocket ds = new DatagramSocket();
		
		String message = "Hello Message using UDP";
		InetAddress ip = InetAddress.getByName("localhost");

		//Create Datagram packet and send
		DatagramPacket dp = new DatagramPacket(message.getBytes(), message.length(), ip, receiverPort);
		ds.send(dp);
		System.out.println("Sender: ho inviato il messaggio " + message);
		
		//Close the socket
		ds.close();

	}

}
