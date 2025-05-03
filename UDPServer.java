import java.net.*;

public class UDPServer {
    public static void main(String[] args) {
        int port = 8080;
        byte[] buffer = new byte[1024];

        try (DatagramSocket socket = new DatagramSocket(port)) {
            System.out.println("UDP Server is listening on port " + port);

            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
            socket.receive(packet);

            String receivedMessage = new String(packet.getData(), 0, packet.getLength());
            System.out.println("Message from client: " + receivedMessage);

            // Send response
            String response = "Hello from server";
            DatagramPacket responsePacket = new DatagramPacket(response.getBytes(), response.length(),
                    packet.getAddress(), packet.getPort());
            socket.send(responsePacket);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
