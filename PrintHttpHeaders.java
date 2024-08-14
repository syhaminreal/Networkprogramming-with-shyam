import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

public class PrintHttpHeaders {

    public static void main(String[] args) {
        // Define the URL for Google
        String urlString = "http://www.google.com";

        try {
            // Create URL object from the provided URL string
            URL url = new URL(urlString);

            // Open a connection to the URL
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            // Get the response code
            int responseCode = connection.getResponseCode();
            System.out.println("Response Code: " + responseCode);

            // Print the entire HTTP header
            System.out.println("HTTP Headers:");
            for (Map.Entry<String, java.util.List<String>> header : connection.getHeaderFields().entrySet()) {
                String headerName = header.getKey();
                if (headerName != null) {
                    System.out.println(headerName + ": " + String.join(", ", header.getValue()));
                } else {
                    // Print headers with no name (e.g., status line)
                    System.out.println(String.join(", ", header.getValue()));
                }
            }

            // Read the response body (optional)
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
