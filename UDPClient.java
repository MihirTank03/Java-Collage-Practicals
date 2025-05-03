import java.net.*;

public class UDPClient {
    public static void main(String[] args) {
        String serverAddress = "127.0.0.1";
        int port = 8080;

        try (DatagramSocket socket = new DatagramSocket()) {
            String message = "Hello from client";
            DatagramPacket packet = new DatagramPacket(message.getBytes(), message.length(),
                    InetAddress.getByName(serverAddress), port);
            socket.send(packet);

            // Receive response
            byte[] buffer = new byte[1024];
            DatagramPacket responsePacket = new DatagramPacket(buffer, buffer.length);
            socket.receive(responsePacket);

            String receivedMessage = new String(responsePacket.getData(), 0, responsePacket.getLength());
            System.out.println("Message from server: " + receivedMessage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
