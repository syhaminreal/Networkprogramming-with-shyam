import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpRequestMethods {

    private static void sendRequest(String method, String urlString, String payload) throws IOException {
        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod(method);

        if (method.equals("POST") || method.equals("PUT")) {
            connection.setDoOutput(true); // Indicates that we want to send a request body
            try (OutputStream os = connection.getOutputStream()) {
                byte[] input = payload.getBytes("utf-8");
                os.write(input, 0, input.length);
            }
        }

        // Print response status
        System.out.println("Response Code: " + connection.getResponseCode());

        // Read the response
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
            String line;
            StringBuilder response = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                response.append(line).append("\n");
            }
            System.out.println("Response Body:\n" + response.toString());
        }
    }

    public static void main(String[] args) {
        // Replace with a YouTube API URL if you have access
        String urlString = "https://www.tufuhss.com"; // Example URL for demonstration
        String payload = ""; // Empty payload since GET, DELETE don't require a body

        try {
            // GET Request (YouTube may not allow GET requests like this, used for demonstration)
            System.out.println("GET Request:");
            sendRequest("GET", urlString, payload);

            // POST Request (YouTube's API requires authentication, example payload may not be valid)
            System.out.println("\nPOST Request:");
            sendRequest("POST", urlString, payload);

            // PUT Request (YouTube's API requires authentication, example payload may not be valid)
            String putUrl = urlString; // Example URL, PUT usually requires a specific endpoint
            System.out.println("\nPUT Request:");
            sendRequest("PUT", putUrl, payload);

            // DELETE Request (YouTube's API requires authentication, example URL may not be valid)
            System.out.println("\nDELETE Request:");
            sendRequest("DELETE", urlString, payload);
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
