import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;

public class LastModifiedTime {
    public static void main(String[] args) {
        String urlString = "https://hianime.to";  // URL to check

        try {
            // Create a URL object from the given URL string
            URL url = new URL(urlString);
            
            // Open a connection to the URL
            URLConnection urlConnection = url.openConnection();
            
            // Connect to the URL
            urlConnection.connect();
            
            // Get the last modified time (in milliseconds since epoch)
            long lastModified = urlConnection.getLastModified();
            
            if (lastModified == 0) {
                System.out.println("The last modified time could not be determined.");
            } else {
                // Convert the last modified time to a Date object
                Date lastModifiedDate = new Date(lastModified);
                
                // Print the last modified time
                System.out.println("Last Modified Time: " + lastModifiedDate.toString());
            }
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
