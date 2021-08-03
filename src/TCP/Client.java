package TCP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
	
	
	
	
	public Client() throws Exception {
		
		Socket socket = new Socket("localhost", 2020);
		
		System.out.println("Sucessful connection");
		
		// I/O streams 
		BufferedReader inputSocket = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		PrintWriter outputSocket = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
		
		String message = inputSocket.readLine();
		System.out.println("Server says: " + message);
		
		outputSocket.println("Thanks!");
		
		socket.close();
		
		System.out.println("Client socket closed");
		
		
	}

	
	
	
	public static void main(String[] args) {
		try {
			new Client();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
