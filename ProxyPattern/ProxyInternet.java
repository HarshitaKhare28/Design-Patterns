import java.util.*;

public class ProxyInternet implements Internet {
    private RealInternet realInternet = new RealInternet();
    private static List<String> bannedSites;

    static {
        bannedSites = new ArrayList<>();
        bannedSites.add("abc.com");
        bannedSites.add("xyz.com");
    }

    public void connectTo(String site) throws Exception {
        if (bannedSites.contains(site.toLowerCase())) {
            throw new Exception("Access Denied to " + site);
        }
        realInternet.connectTo(site);
    }
}
