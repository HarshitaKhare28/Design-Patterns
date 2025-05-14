// Main.java

interface Button {
    void click();
}

interface Checkbox {
    void select();
}

// Concrete Products
class WindowsButton implements Button {
    public void click() {
        System.out.println("Windows Button clicked!");
    }
}

class MacButton implements Button {
    public void click() {
        System.out.println("Mac Button clicked!");
    }
}

class WindowsCheckbox implements Checkbox {
    public void select() {
        System.out.println("Windows Checkbox selected!");
    }
}

class MacCheckbox implements Checkbox {
    public void select() {
        System.out.println("Mac Checkbox selected!");
    }
}

// Abstract Factory
interface GUIFactory {
    Button createButton();
    Checkbox createCheckbox();
}

// Concrete Factories
class WindowsFactory implements GUIFactory {
    public Button createButton() {
        return new WindowsButton();
    }

    public Checkbox createCheckbox() {
        return new WindowsCheckbox();
    }
}

class MacFactory implements GUIFactory {
    public Button createButton() {
        return new MacButton();
    }

    public Checkbox createCheckbox() {
        return new MacCheckbox();
    }
}

// Client
class Application {
    private Button button;
    private Checkbox checkbox;

    public Application(GUIFactory factory) {
        button = factory.createButton();
        checkbox = factory.createCheckbox();
    }

    public void run() {
        button.click();
        checkbox.select();
    }
}

// Main method
public class Main {
    public static void main(String[] args) {
        GUIFactory factory;
        String osType = "Windows"; // Change to "Mac" to test Mac UI

        if (osType.equals("Windows")) {
            factory = new WindowsFactory();
        } else {
            factory = new MacFactory();
        }

        Application app = new Application(factory);
        app.run();
    }
}
