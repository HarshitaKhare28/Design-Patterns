import java.util.ArrayList;
import java.util.List;

// Iterator Interface
interface Iterator {
    boolean hasNext();
    Object next();
}

// Aggregate Interface
interface Collection {
    Iterator createIterator();
}

// Concrete Iterator
class BookIterator implements Iterator {
    private List<Book> books;
    private int position;

    public BookIterator(List<Book> books) {
        this.books = books;
        this.position = 0;
    }

    @Override
    public boolean hasNext() {
        return position < books.size();
    }

    @Override
    public Object next() {
        if (hasNext()) {
            return books.get(position++);
        }
        return null;
    }
}

// Concrete Aggregate (Library)
class Library implements Collection {
    private List<Book> books;

    public Library() {
        books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    @Override
    public Iterator createIterator() {
        return new BookIterator(books);
    }
}

// Book class (Element in the collection)
class Book {
    private String title;
    private String author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return "Book[Title=" + title + ", Author=" + author + "]";
    }
}

// Main class to test the Iterator pattern
public class Main {
    public static void main(String[] args) {
        // Create the Library and add some books
        Library library = new Library();
        library.addBook(new Book("The Alchemist", "Paulo Coelho"));
        library.addBook(new Book("1984", "George Orwell"));
        library.addBook(new Book("To Kill a Mockingbird", "Harper Lee"));

        // Create the iterator
        Iterator iterator = library.createIterator();

        // Iterate over the books
        while (iterator.hasNext()) {
            Book book = (Book) iterator.next();
            System.out.println(book);
        }
    }
}
