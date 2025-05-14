import java.util.ArrayList;
import java.util.List;

public class Composite implements Component {
    private String name;
    private List<Component> components = new ArrayList<>();

    public Composite(String name) {
        this.name = name;
    }

    public void add(Component c) {
        components.add(c);
    }

    public void remove(Component c) {
        components.remove(c);
    }

    public void showDetails() {
        System.out.println("Composite: " + name);
        for (Component c : components) {
            c.showDetails();
        }
    }
}
