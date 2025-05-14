public class Leaf implements Component {
    private String name;

    public Leaf(String name) {
        this.name = name;
    }

    public void showDetails() {
        System.out.println("Leaf: " + name);
    }
}
