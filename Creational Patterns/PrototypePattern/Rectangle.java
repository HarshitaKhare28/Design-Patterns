// Rectangle.java
public class Rectangle implements Shape {
    private int width, height;

    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public void draw() {
        System.out.println("Drawing Rectangle with width: " + width + " and height: " + height);
    }

    public Shape clone() {
        return new Rectangle(this.width, this.height);
    }
}
