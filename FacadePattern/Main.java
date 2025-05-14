public class Main {
    public static void main(String[] args) {
        // Create subsystem objects
        DVDPlayer dvd = new DVDPlayer();
        Projector projector = new Projector();
        Lights lights = new Lights();

        // Create the facade
        HomeTheaterFacade homeTheater = new HomeTheaterFacade(dvd, projector, lights);

        // Use the facade
        homeTheater.watchMovie("Interstellar");
        homeTheater.endMovie();
    }
}
