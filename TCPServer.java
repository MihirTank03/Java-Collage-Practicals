import java.io.*;
import java.net.*;

public class TCPServer {
    public static void main(String[] args) {
        int port = 8080;
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("TCP Server is listening on port " + port);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("New client connected");

                // Read message from client
                BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String message = input.readLine();
                System.out.println("Message from client: " + message);

                // Send response to client
                PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
                output.println("Hello from server");

                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
