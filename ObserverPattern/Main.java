import java.util.ArrayList;
import java.util.List;

// Observer Interface
interface Observer {
    void update(String news);
}

// Subject Interface
interface Subject {
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers();
}

// Concrete Subject (News Agency)
class NewsAgency implements Subject {
    private List<Observer> observers;
    private String news;

    public NewsAgency() {
        observers = new ArrayList<>();
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(news);
        }
    }

    public void setNews(String news) {
        this.news = news;
        notifyObservers();
    }
}

// Concrete Observer (News Channel)
class NewsChannel implements Observer {
    private String name;

    public NewsChannel(String name) {
        this.name = name;
    }

    @Override
    public void update(String news) {
        System.out.println(name + " received the news update: " + news);
    }
}

// Main class to test the Observer pattern
public class Main {
    public static void main(String[] args) {
        // Create the subject (NewsAgency)
        NewsAgency newsAgency = new NewsAgency();

        // Create observers (NewsChannels)
        Observer channel1 = new NewsChannel("Channel 1");
        Observer channel2 = new NewsChannel("Channel 2");
        Observer channel3 = new NewsChannel("Channel 3");

        // Register the observers with the subject
        newsAgency.addObserver(channel1);
        newsAgency.addObserver(channel2);
        newsAgency.addObserver(channel3);

        // Set news and notify observers
        newsAgency.setNews("Breaking News: Design Patterns in Java!");
        newsAgency.setNews("Update: Observer Pattern in Action!");

        // Unsubscribe an observer
        newsAgency.removeObserver(channel2);
        
        // Set more news and notify remaining observers
        newsAgency.setNews("New Update: Unsubscribe one channel!");
    }
}
