package aims.media.disc;

import aims.media.Media;
import playable.Playable;

public abstract class Disc extends Media implements Playable{

    protected int length;
    protected String director;

    public int getLength() {
        return length;
    }

    public String getDirector() {
        return director;
    }

    public Disc() {
    }

    public Disc(int id, String title, String category, double cost, String director) {
        super(id, title, category, cost);
        this.director = director;
    }

    public Disc(int id, String title, String category, double cost, String director, int length) {
        this(id, title, category, cost, director);
        this.length = length;
    }

    @Override
    public String toString() {
        return String.format("%s - %s - %s - %d minutes(s): %.2f$", title, category, director, length, cost);
    }
}