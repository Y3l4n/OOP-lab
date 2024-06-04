package Test.store;

import AIMS.Store.Store;
import AIMS.media.DigitalVideoDisc;
import Test.media.MediaObjects;

public class StoreTest extends MediaObjects {
    public static void main(String[] args) {

        // Lab3: test addDvd and removeDvd methods
        Store store = new Store();

        DigitalVideoDisc dvd1 = new DigitalVideoDisc("Vinh gay", "Sex gay", 2.2, "Vinh");
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Oppenheimer", "History", 10.2, "Christopher Nolan");
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Lucifer", "Crime", 8.2, "Tom Ellis");
        store.addMedia(dvd1);
        store.addMedia(dvd2);
        store.addMedia(dvd3);
        store.addMedia(dvd2);

        

    }
}