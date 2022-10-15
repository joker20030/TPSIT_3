package network;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

class TcpServer extends Thread {
	Socket serverClientSocket;
	int clientNo;
	
	TcpServer(Socket inSocket, int ClientNo) {
		serverClientSocket = inSocket;
		clientNo = ClientNo;
	}

	public void run() {
		try {
			// Streams to read and write the data to socket streams
			DataInputStream inStream = new DataInputStream(serverClientSocket.getInputStream());
			DataOutputStream outStream = new DataOutputStream(serverClientSocket.getOutputStream());

			String clientMessage = "";
			String serverMessage = "";

			while (!clientMessage.equals("end")) {

				clientMessage = inStream.readUTF();
				System.out.println("Server.Thread " + clientNo + " Ricevuto messaggio " + clientMessage );
				serverMessage=clientMessage;
				System.out.println("Server.Thread " + clientNo + " Invio messaggio " + serverMessage );
				outStream.writeUTF(serverMessage);
				outStream.flush();
			}
			
			serverMessage="Bye";
			System.out.println("Server.Thread " + clientNo + " Invio messaggio " + clientMessage );
			outStream.writeUTF(serverMessage);
			outStream.flush();
			inStream.close();
			outStream.close();
			serverClientSocket.close();

		} catch (Exception ex) {
			System.out.println(ex);
		} finally {
			System.out.println("Client -" + clientNo + " exit!! ");
		}
	}

	

}
