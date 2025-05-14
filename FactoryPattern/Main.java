public class Main {
    public static void main(String[] args) {
        Shape shape1 = ShapeFactory.getShape("CIRCLE");
        shape1.draw(); // Output: Drawing a Circle

        Shape shape2 = ShapeFactory.getShape("RECTANGLE");
        shape2.draw(); // Output: Drawing a Rectangle
    }
}