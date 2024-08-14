import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

public class ReadHeaderFields {
    public static void main(String[] args) {
        String urlString = "https://www.youtube.com";  // URL to connect to

        try {
            // Create a URL object from the given URL string
            URL url = new URL(urlString);
            
            // Open a connection to the URL
            URLConnection urlConnection = url.openConnection();
            
            // Connect to the URL
            urlConnection.connect();
            
            // Get all header fields
            Map<String, List<String>> headerFields = urlConnection.getHeaderFields();
            
            // Iterate through the header fields and print them
            for (Map.Entry<String, List<String>> entry : headerFields.entrySet()) {
                String headerName = entry.getKey();
                List<String> headerValues = entry.getValue();
                
                System.out.println(headerName + ": " + String.join(", ", headerValues));
            }
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
