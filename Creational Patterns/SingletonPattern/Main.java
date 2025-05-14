// File: Main.java
public class Main {
    public static void main(String[] args) {
        Singleton obj1 = Singleton.getInstance();
        obj1.showMessage();
        Singleton obj2 = Singleton.getInstance();
        obj2.showMessage();
        System.out.println("Are both instances same? " + (obj1 == obj2));
    }
}
