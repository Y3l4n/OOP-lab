package dsai.Aims.media;

public class Track implements Playable {

    private String title;
    private int length;

    public String getTitle() {
        return title;
    }
    public int getLength() {
        return length;
    }
    public Track(String title, int length) {
        this.title = title;
        this.length = length;
    }
    @Override
    public void play() {
        System.out.println("Playing track: " + this.getTitle());
        System.out.println("Length: " + this.getLength());
    }

    @Override
    public boolean equals(Object obj){
        Track track = (Track) obj;
        return title.equals(track.getTitle()) && length == track.getLength();
    }
}
