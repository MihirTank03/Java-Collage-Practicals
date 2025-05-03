import java.io.*;
import java.net.*;

public class TCPClient {
    public static void main(String[] args) {
        String serverAddress = "127.0.0.1";
        int port = 8080;

        try (Socket socket = new Socket(serverAddress, port)) {
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
            output.println("Hello from client");

            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String message = input.readLine();
            System.out.println("Message from server: " + message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
