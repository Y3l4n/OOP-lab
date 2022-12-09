package test;

import AIMS.AIMS;
import AIMS.media.Media;
import test.media.MediaObjects;

public class AimsTest extends MediaObjects {
    public static void main(String[] args) {
        Media[] mediae = { dvd1, dvd2, dvd3, book1, book2, book3, book4, cd1, cd2 };
        Aims aims = new Aims(mediae);
        aims.start();
    }
}