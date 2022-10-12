/**
 * from network/..
 * javac network/Receiver.java; java network.Receiver 
 */
package network;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Receiver {

	public static void main(String[] args) throws IOException {
		int receiverPort=8698;
		System.out.println("Receiver: starting on port " + receiverPort);
		//Opens a datagram socket on the specified port
		DatagramSocket ds = new DatagramSocket(receiverPort);
		
		
		byte[] buf = new byte[1024];
		
		//Constructs a datagram packet for receiving the packets of specified length
		DatagramPacket dp = new DatagramPacket(buf, 1024);
		
		ds.receive(dp);
		System.out.println("Receiver: Ho ricevuto qualche cosa");
		String str = new String(dp.getData(), 0, dp.getLength());
		
		System.out.println("Receiver, ho ricevuto il seguente messaggio "+ str);
		
		//Closing the Datagram socket
		ds.close();

	}

}
