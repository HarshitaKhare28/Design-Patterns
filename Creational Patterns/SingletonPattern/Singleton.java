// File: Singleton.java
public class Singleton {
    private static Singleton instance;
    private Singleton() {
        System.out.println("Singleton Instance Created!");
    }
    public static synchronized Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton(); // create instance if not created yet
        }
        return instance;
    }

    // Optional method to demonstrate functionality
    public void showMessage() {
        System.out.println("Hello from Singleton!");
    }
}
