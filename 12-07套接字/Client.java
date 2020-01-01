package udp.echo;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Client {
    public static void main(String[] args) throws IOException {
        DatagramSocket udpClientSocket = new DatagramSocket();
        String message = "收到我的消息没？";
        byte[] sendBuffer = message.getBytes("UTF-8");
        // 127.0.0.1
        byte[] serverIP = new byte[4];
        serverIP[0] = 127;
        serverIP[1] = 0;
        serverIP[2] = 0;
        serverIP[3] = 1;
        InetAddress serverAddress = InetAddress.getByAddress(serverIP);
        DatagramPacket sendPacket = new DatagramPacket(
                sendBuffer,
                sendBuffer.length,
                serverAddress,
                9898
        );
        udpClientSocket.send(sendPacket);
        udpClientSocket.close();
    }
}
