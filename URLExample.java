import java.net.URL;
import java.net.URLConnection;

public class URLExample {
    public static void main(String[] args) {
        try {
            // Create a URL object with the specified URL
            URL url = new URL("http://www.tufhoss.edu.np");

            // Open a connection to the URL
            URLConnection urlConnection = url.openConnection();

            // Get and print the URL of the URLConnection
            System.out.println("URL: " + urlConnection.getURL());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
