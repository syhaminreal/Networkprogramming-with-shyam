import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeServer {
    public static void main(String[] args) {
        int port = 6789; // Port number to listen on

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Time Server is running on port " + port);

            while (true) {
                // Wait for a client to connect
                Socket clientSocket = serverSocket.accept();

                // Create a PrintWriter to send data to the client
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

                // Get the current time
                String currentTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());

                // Send the time to the client
                out.println("Current Server Time: " + currentTime);

                // Close the client socket
                clientSocket.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
