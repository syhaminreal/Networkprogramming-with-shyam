import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class DownloadWebPage {
    public static void main(String[] args) {
        String urlString = "https://www.facebook.com";  // URL of the webpage to download

        try {
            // Create a URL object from the given URL string
            URL url = new URL(urlString);
            
            // Open a connection to the URL
            URLConnection urlConnection = url.openConnection();
            
            // Get the input stream from the connection
            InputStream inputStream = urlConnection.getInputStream();
            
            // Use a BufferedReader to read the input stream line by line
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            
            String inputLine;
            StringBuilder content = new StringBuilder();
            
            // Read each line from the BufferedReader and append it to the StringBuilder
            while ((inputLine = reader.readLine()) != null) {
                content.append(inputLine).append("\n");
            }
            
            // Close the BufferedReader
            reader.close();
            
            // Print the content of the webpage
            System.out.println(content.toString());
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
