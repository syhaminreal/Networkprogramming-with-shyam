import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.net.InetSocketAddress;

public class EchoClient {
    public static void main(String[] args) {
        String host = "localhost"; // or the server's IP address
        int port = 7541; // same port as server
        try {
            SocketChannel client = SocketChannel.open();
            client.connect(new InetSocketAddress(host, port));
            
            ByteBuffer buffer = ByteBuffer.wrap("Hello, Server!".getBytes());
            client.write(buffer);
            buffer.clear();
            
            client.read(buffer);
            buffer.flip();
            System.out.println("Received from server: " + new String(buffer.array(), buffer.position(), buffer.remaining()));
            
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
