package AIMS.media;
import AIMS.playable.Playable;
   
public class Track implements Playable{
    private String title;
    private int length;

    public String getTitle() {
        return title;
    }

    public int getLength() {
        return length;
    }

    public Track() {
    }

    public Track(String title, int length) {
        this.title = title;
        this.length = length;
    }

    public void play() {
        System.out.println("Playing track: " + this.getTitle());
        System.out.println("Track length: " + this.getLength());
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Track))
            return false;
        return this.title.equalsIgnoreCase(((Track) obj).title) && this.length == ((Track) obj).length;
    }
}

