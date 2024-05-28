import java.net.*;

public class UDPClient {
    
    public static void main(String[] args) {
        String serverAddress = "localhost";
        int serverPort = 9876;

        try {
            // socket UDP para o cliente
            DatagramSocket clientSocket = new DatagramSocket();

            // obtem o endereco IP do servidor 
            InetAddress serverIpAddress = InetAddress.getByName(serverAddress);

            // mensagem a ser enviada
            String message = "Hello World!";
            // mensagem convertida para bytes
            byte[] sendData = message.getBytes();

            // cria o datagrama para envio
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, serverIpAddress, serverPort);

            // envia o pacote
            clientSocket.send(sendPacket);

            // fecha a conexao
            clientSocket.close();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}
