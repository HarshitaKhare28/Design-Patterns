// Main.java
public class Main {
    public static void main(String[] args) {
        Shape circle1 = new Circle(5);
        Shape circle2 = circle1.clone();

        circle1.draw();  // Original
        circle2.draw();  // Cloned

        Shape rect1 = new Rectangle(10, 20);
        Shape rect2 = rect1.clone();

        rect1.draw();  // Original
        rect2.draw();  // Cloned
    }
}
