import java.net.CookiePolicy;
import java.net.HttpCookie;
import java.net.URI;

public class NoGovernmentCookies implements CookiePolicy {

    @Override
    public boolean shouldAccept(URI uri, HttpCookie cookie) {
        // Block cookies from .gov domains
        if (uri.getHost().endsWith(".gov")) {
            return false;
        }
        // Allow cookies from other domains
        return true;
    }
}
