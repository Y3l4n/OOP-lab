package Test;

import AIMS.AIMS;
import AIMS.media.Media;
import Test.media.MediaObjects;

public class AIMSTest extends MediaObjects {
    public static void main(String[] args) {
        Media[] mediae = { dvd1, dvd2, dvd3, book1, book2, book3, book4, cd1, cd2 };
        AIMS aims = new AIMS(mediae);
        aims.start();
    }
}