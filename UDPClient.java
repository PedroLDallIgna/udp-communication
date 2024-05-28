import java.net.*;
import javax.swing.JOptionPane;

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
            String message = JOptionPane.showInputDialog("Mensagem:");
            // mensagem convertida para bytes
            byte[] sendData = message.getBytes();

            // cria o datagrama para envio
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, serverIpAddress, serverPort);

            // envia o pacote
            clientSocket.send(sendPacket);

            // buffer para mensagem
            byte[] responseData = new byte[1024];

            // datagrama de pacote de resposta
            DatagramPacket responsePacket = new DatagramPacket(responseData, responseData.length);

            // recebe o pacote de resposta
            clientSocket.receive(responsePacket);

            // extrai os dados de resposta
            String responseMessage = new String(responsePacket.getData());

            // mostra a resposta recebida
            JOptionPane.showMessageDialog(null, responseMessage, "Server", JOptionPane.INFORMATION_MESSAGE);

            // fecha a conexao
            clientSocket.close();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}
