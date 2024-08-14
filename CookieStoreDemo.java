
import java.net.CookieManager;
import java.net.CookieHandler;
import java.net.CookieStore;
import java.net.HttpCookie;
import java.net.URI;
import java.net.CookiePolicy;
import java.util.List;

public class CookieStoreDemo {

    public static void main(String[] args) throws Exception {
        // Create a new CookieManager with a default policy
        CookieManager cookieManager = new CookieManager();
        CookieHandler.setDefault(cookieManager);

        // Get the CookieStore from the CookieManager
        CookieStore cookieStore = cookieManager.getCookieStore();

        // Create some test cookies for google.com
        URI uriGoogle = new URI("http://google.com");
        HttpCookie cookie1 = new HttpCookie("testCookie1", "value1");
        cookie1.setDomain("google.com");
        HttpCookie cookie2 = new HttpCookie("testCookie2", "value2");
        cookie2.setDomain("google.com");

        // Create test cookies for example.com
        URI uriExample = new URI("http://example.com");
        HttpCookie cookie3 = new HttpCookie("testCookie3", "value3");
        cookie3.setDomain("example.com");

        // Add cookies to the store
        System.out.println("Adding cookies...");
        cookieStore.add(uriGoogle, cookie1);
        cookieStore.add(uriGoogle, cookie2);
        cookieStore.add(uriExample, cookie3);

        // Print cookies in the store
        printCookies(cookieStore, "After adding cookies:");

        // Read cookies for a specific URI
        System.out.println("Cookies for http://google.com:");
        List<HttpCookie> cookiesForGoogle = cookieStore.get(uriGoogle);
        for (HttpCookie cookie : cookiesForGoogle) {
            System.out.println(cookie);
        }

        // Remove a specific cookie
        System.out.println("Removing cookie 'testCookie1' from http://google.com...");
        boolean removed = cookieStore.remove(uriGoogle, cookie1);
        System.out.println("Cookie removed: " + removed);

        // Print cookies in the store after removal
        printCookies(cookieStore, "After removing 'testCookie1':");

        // Remove all cookies
        System.out.println("Removing all cookies...");
        cookieStore.removeAll();

        // Print cookies in the store after removing all
        printCookies(cookieStore, "After removing all cookies:");
    }

    private static void printCookies(CookieStore cookieStore, String message) {
        System.out.println(message);
        for (HttpCookie cookie : cookieStore.getCookies()) {
            System.out.println(cookie);
        }
    }
}
