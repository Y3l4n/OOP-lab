


package dsai.Aims.media;

/**
 * Disc
 */
public class Disc extends Media {

    public Disc(String title) {
        super(title);
    }
    private int length;
    private String director;

    public Disc(String title, String category, float cost){
        super(title, category, cost);
    }

    public Disc(String title, String director, String category, float cost){
        super(title, category, cost);
        this.director = director;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public Disc(String title, String director, String category, float cost, int length){
        super(title, category, cost);
        this.director = director;
        this.length = length;
    }
}
