package no.hvl.dat110.messagetransport;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MessagingServer {

	private ServerSocket welcomeSocket;
	
	public MessagingServer(int port) {
		
		try {
		
			this.welcomeSocket = new ServerSocket(port);
			
		} catch (IOException ex) {
			
			System.err.println("[MessagingServer] Failed to bind server socket on port " + port + ": " + ex.getMessage());
			ex.printStackTrace();
			this.welcomeSocket = null;
		}
	}

	// accept an incoming connection from a client
	public Connection accept () {
		
		Connection connection = null;
		
		if (welcomeSocket == null) {
			System.err.println("[MessagingServer] ERROR: Server socket is not initialized. Cannot accept connections.");
			throw new IllegalStateException("Server socket not initialized. Check for port conflicts or previous errors.");
		}
		
		try {
			
			Socket connectionSocket = welcomeSocket.accept();
			
			connection = new Connection(connectionSocket);
			
		} catch (IOException ex) {
			
			System.err.println("[MessagingServer] Error accepting connection: " + ex.getMessage());
			ex.printStackTrace();
			// TODO: closing welcomeSocket
		}
		
		return connection;

	}
	
	public void stop() {
		
		if (welcomeSocket != null) {
			
			try {
			welcomeSocket.close();
			} catch (IOException ex) {
				
			System.out.println("Messaging server: " + ex.getMessage());
			ex.printStackTrace();
		}
		}
	}

}
