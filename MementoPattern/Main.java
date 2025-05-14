import java.util.Stack;

// Memento class that stores the state of the text editor
class Memento {
    private final String text;

    public Memento(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}

// Originator class that will create and restore Memento
class TextEditor {
    private String text;

    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public Memento save() {
        return new Memento(text);
    }

    public void restore(Memento memento) {
        this.text = memento.getText();
    }
}

// Caretaker class that holds the Memento
class Caretaker {
    private Stack<Memento> mementoStack = new Stack<>();

    public void saveState(TextEditor editor) {
        mementoStack.push(editor.save());
    }

    public void undo(TextEditor editor) {
        if (!mementoStack.isEmpty()) {
            editor.restore(mementoStack.pop());
        } else {
            System.out.println("No previous state to restore.");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor();
        Caretaker caretaker = new Caretaker();

        // Initial text
        editor.setText("Hello, World!");
        System.out.println("Text: " + editor.getText());
        caretaker.saveState(editor);  // Save state

        // Edit text
        editor.setText("Hello, Memento Pattern!");
        System.out.println("Text: " + editor.getText());

        // Undo last change
        caretaker.undo(editor);
        System.out.println("After Undo: " + editor.getText());

        // Edit again
        editor.setText("Text Editor Example");
        System.out.println("Text: " + editor.getText());

        // Undo last change
        caretaker.undo(editor);
        System.out.println("After Undo: " + editor.getText());
    }
}
