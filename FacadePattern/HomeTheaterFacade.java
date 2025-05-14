// HomeTheaterFacade.java
public class HomeTheaterFacade {
    private DVDPlayer dvd;
    private Projector projector;
    private Lights lights;

    public HomeTheaterFacade(DVDPlayer dvd, Projector projector, Lights lights) {
        this.dvd = dvd;
        this.projector = projector;
        this.lights = lights;
    }

    public void watchMovie(String movie) {
        System.out.println("\nGetting ready to watch a movie...");
        lights.dim(10);
        projector.on();
        projector.setWideScreenMode();
        dvd.on();
        dvd.play(movie);
    }

    public void endMovie() {
        System.out.println("\nShutting movie theater down...");
        lights.on();
        projector.off();
        dvd.off();
    }
}
