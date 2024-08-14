import java.io.*;
import java.net.URL;

public class ObjectDownload {
    public static void main(String[] args) {
        download("https://www.google.com");
    }

    private static void download(String url) {
        try {
            URL u = new URL(url);
            InputStream in = u.openStream();
            BufferedInputStream bis = new BufferedInputStream(in);
            FileOutputStream fos = new FileOutputStream("downloaded_object.html"); // Change the file name and extension as needed

            byte[] data = new byte[1024];
            int count;
            while ((count = bis.read(data, 0, 1024)) != -1) {
                fos.write(data, 0, count);
            }

            fos.close();
            bis.close();
            System.out.println("Download complete!");

        } catch (IOException ex) {
            System.err.println("Error: " + ex.getMessage());
        }
    }
}
