import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

public class TimeClienta {
    public static void main(String[] args) {
        String serverName = "localhost"; // The server's address (use "localhost" if running on the same machine)
        int port = 6789; // The port on which the server is listening

        try {
            // Connect to the server
            Socket clientSocket = new Socket(serverName, port);

            // Read the time sent by the server
            BufferedReader input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            String serverTime = input.readLine();

            // Print the time received from the server
            System.out.println("Server Time: " + serverTime);

            // Close the connection
            input.close();
            clientSocket.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
