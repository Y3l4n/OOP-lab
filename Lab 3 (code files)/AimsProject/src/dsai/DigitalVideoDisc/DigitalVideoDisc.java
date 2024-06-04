package dsai.DigitalVideoDisc;

import dsai.Aims.media.Media;
import dsai.Aims.media.Playable;

public class DigitalVideoDisc extends Media implements Playable {

    private String director;
    private int length;
    private static int nbDigitalVideoDisc = 0;

    public String getDirector() {
        return director;
    }
    public int getLength() {
        return length;
    }
    public void setDirector(String director) {
        this.director = director;
    }
    public void setLength(int length) {
        this.length = length;
    }

    public DigitalVideoDisc(String title) {
        super();
        setTitle(title);
        nbDigitalVideoDisc++;
    }

    public DigitalVideoDisc(String title, String category, float cost) {
        super();
        setTitle(title);
        setCategory(category);
        setCost(cost);
        nbDigitalVideoDisc++;
    }

    
    public DigitalVideoDisc(String title, String category, float cost, int id) {
        super();
        setTitle(title);
        setCategory(category);
        setCost(cost);
        setId(id);
        nbDigitalVideoDisc++;
    }

    public DigitalVideoDisc(String title, String category, String director, float cost) {
        super();
        setTitle(title);
        setCategory(category);
        setDirector(director);
        setCost(cost);
        nbDigitalVideoDisc++;
    }
    
    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        super();
        setTitle(title);
        setCategory(category);
        this.director = director;
        this.length = length;
        setCost(cost);
        nbDigitalVideoDisc++;
    }
    
    public DigitalVideoDisc(String title, String category, String director, int length, float cost, int id) {
        super();
        setTitle(title);
        setCategory(category);
        this.director = director;
        this.length = length;
        setCost(cost);
        setId(id);
        nbDigitalVideoDisc++;
    }
    
    @Override
    public String toString(){
        String dvd = "DVD: ";
        if (getTitle() != null) {
            dvd += getTitle();
        }
        if (getCategory() != null){
            dvd += getCategory();
        }
        if (getDirector() != null) {
            dvd += getDirector();
        }
        if (getLength() != 0) {
            dvd += getLength();
        }
        if (getCost() != 0.0) {
            dvd += getCost();
        }
        return dvd;
    }
    
    @Override
    public void play() {
        System.out.println("Playing DVD: " + this.getTitle());
        System.out.println("DVD length: " + this.getLength());
    }
}