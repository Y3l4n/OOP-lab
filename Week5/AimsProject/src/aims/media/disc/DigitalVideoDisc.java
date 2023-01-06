package aims.media.disc;

public class DigitalVideoDisc extends Disc {

    private static int nbDigitalVideoDisc = 0;

    public DigitalVideoDisc() {
        this.id = ++nbDigitalVideoDisc;
    }

    public DigitalVideoDisc(String title) {
        this();
        this.title = title;
    }

    public DigitalVideoDisc(String title, String category, double cost, String director) {
        super(++nbDigitalVideoDisc, title, category, cost, director);
    }

    public DigitalVideoDisc(String title, String category, double cost, String director, int length) {
        super(++nbDigitalVideoDisc, title, category, cost, director, length);
    }

    public void play() {
        System.out.println("Playing DVD: " + this.getTitle());
        System.out.println("DVD length: " + this.getLength() + " minute(s)");
    }
}
