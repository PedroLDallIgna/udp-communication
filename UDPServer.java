// import de classes
import java.net.*;

public class UDPServer {

    public static void main(String[] args) {
        
        // define porta do servidor
        int serverPort = 9876;
        System.out.println("Listening on port " + serverPort);

        try {
            // socket UDP para o servidor
            DatagramSocket serverSocket = new DatagramSocket(serverPort);

            // buffer para armazenar os dados
            byte[] receivedData = new byte[1024];

            while (true) {
                // pacote udp a ser recebido
                DatagramPacket receivedPacket = new DatagramPacket(receivedData, receivedData.length);

                // recebe os dados do cliente
                serverSocket.receive(receivedPacket);

                // extrai os dados recebidos
                String receivedMessage = new String(receivedPacket.getData());

                System.out.println("Received message: " + receivedMessage);
                
            }

        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}
