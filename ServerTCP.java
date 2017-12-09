package codigo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.StringTokenizer;


public class ServerTCP {
	private static int PORT = 9090;
	
    /**
    * Runs the server.
    */
   public static void main(String[] args) throws IOException {
       
   	ServerSocket serverSocket = new ServerSocket(PORT);
       System.out.println("Server listening on port "+PORT);
       int suma = 0;
       
       try {
           while (true) {
               Socket socket = serverSocket.accept();
        	   InputStreamReader in = new InputStreamReader(socket.getInputStream());            
               try {
            	BufferedReader input = new BufferedReader(in);
           		String mensaje = input.readLine();
           		StringTokenizer st = new StringTokenizer(mensaje, ",");
           		while (st.hasMoreTokens()) {
						suma+=Integer.parseInt(st.nextToken());
					}
                   PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                   out.println(suma);
               } finally {
                   socket.close();
               }
           }
       }
       finally {
       	serverSocket.close();
       }
   }
}
