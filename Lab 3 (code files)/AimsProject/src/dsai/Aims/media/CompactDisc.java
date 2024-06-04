package dsai.Aims.media;

import java.util.ArrayList;
import java.util.List;

public class CompactDisc extends Disc implements Playable {

    private String artist;
    //List<type_of_object> name_of_object
    private List<Track> tracks = new ArrayList<Track>();

    public String getArtist() {
        return artist;
    }


    public CompactDisc(int id, String title, String category, float cost, float length, String director) {
        super(id, title, category, cost, length, director);

    }


    public void addTrack(Track addedTrack){
        if (tracks.contains(addedTrack)) {
            System.out.println("Track is already added to list");
        } else {
            tracks.add(addedTrack);
        }
    }

    public void removeTrack(Track removedTrack){
        if (tracks.contains(removedTrack)) {
            tracks.remove(removedTrack);
        } else {
            System.out.println("Track is not in disc. Can't remove");
        }
    }

    public int getLengthCD(){
        int lengthCD = 0;
        for (Track track : tracks) {
            lengthCD += track.getLength();
        }
        return lengthCD;
    }


    @Override
    //Ghi de abstract method Playable trong class CompactDisc
    public void play() {
        for (Track track : tracks) {
            System.out.printf("Playing track %s: %s\n ", track, this.getTitle());
            System.out.printf("%s length: %d\n", track, this.getLength());
            System.out.println();
        }
    }

    @Override
    public String toString(){
        String res = "CD: ";
        if (getTitle() != null) {
            res += " - " + getTitle();
        }
        if (getCategory() != null) {
            res += " - " + getCategory();
        }
        if (getDirector() != null) {
            res += " - " + getDirector();
        }
        if (getLength() != 0) {
            res += " - " + getLength();
        }
        if (getCost() != 0.0){
            res += " - " + getCost();
        }
        return res;

    }
}
