public class Main {
    public static void main(String[] args) {
        Internet internet = new ProxyInternet();
        try {
            internet.connectTo("geeksforgeeks.org");
            internet.connectTo("abc.com");  // Should throw exception
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
