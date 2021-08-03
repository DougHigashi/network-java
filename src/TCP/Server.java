package TCP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	
	public Server() throws Exception {
		ServerSocket serverSocket = new ServerSocket(2020);
		
		System.out.println("Port 2020 opened");
		
		Socket socket = serverSocket.accept();
		
		System.out.println("Client " + socket.getInetAddress() + " has connected");
		
		BufferedReader inputSocket = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		PrintWriter outputSocket = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
		
		outputSocket.println("Welcome!");				//envia "Welcome!" para o client
		String message = inputSocket.readLine();
		System.out.println("Client says: " + message); //Client envia a mensagem e recebemos no console
		
		socket.close();
		System.out.println("Server socket closed");
	}
	
	
	public static void main(String[] args) {
		try {
			new Server();
		} catch (Exception e) {
			e.getStackTrace();
		}
	}

}
