import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class TimeClient {
    public static void main(String[] args) {
        String serverName = "time.nist.gov"; // The time server
        int port = 13; // Default port for the time service

        try {
            // Connect to the time server
            Socket clientSocket = new Socket(serverName, port);

            // Create input and output streams
            BufferedReader input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter output = new PrintWriter(clientSocket.getOutputStream(), true);

            // Read and print the time from the server
            String serverTime;
            while ((serverTime = input.readLine()) != null) {
                System.out.println("Server Time: " + serverTime);
            }

            // Close the connections
            input.close();
            output.close();
            clientSocket.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
