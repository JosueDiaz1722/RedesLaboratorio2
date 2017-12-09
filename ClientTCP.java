package codigo;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.file.attribute.UserPrincipalLookupService;

import javax.swing.JOptionPane;
public class ClientTCP {
	private static int SERVER_PORT = 9090;
	
	/**
     * Runs the client as an application.  First it displays a dialog
     * box asking for the IP address or hostname of a host running
     * the server, then connects to it and displays the message that
     * it serves.
     */
	
	public static void main(String[] args) throws IOException {
        
		String serverAddress = JOptionPane.showInputDialog("Enter IP Address of a machine that is\n" +
            							   "running the date service on port "+SERVER_PORT+":");
		 String mensaje = JOptionPane.showInputDialog("Ingrese los dos numeros que desea sumar seguidos por un coma");

		//Establece la conexión con el servidor mediante un socket
		
		Socket clientSocket = new Socket(serverAddress, SERVER_PORT);
		PrintWriter out = new PrintWriter(clientSocket.getOutputStream(),true);
         	out.println(mensaje);


		//Obtiene el mensaje enviado por el servidor a través del socket
		InputStreamReader inputStream = new InputStreamReader(clientSocket.getInputStream());

		//Lee los datos del mensaje
		BufferedReader input = new BufferedReader(inputStream);
		String suma = input.readLine();

		//Imprime los datos del mensaje
		JOptionPane.showMessageDialog(null, "La suma es igual a "+suma);
		System.exit(0);
    }
}
