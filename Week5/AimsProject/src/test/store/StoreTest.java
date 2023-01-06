package test.store;

import aims.store.Store;
import test.media.MediaObjects;

public class StoreTest extends MediaObjects {
    public static void main(String[] args) {

        // Lab3: test addDvd and removeDvd methods
        Store store = new Store();

        store.addMedia(dvd1);
        store.addMedia(dvd2);
        store.addMedia(dvd3);
        store.addMedia(dvd2);
        store.printDetail();
        System.out.println();

        store.removeMedia(dvd3);
        store.removeMedia(dvd3);
        store.printDetail();

        store.searchMedia("The Lion King").printDetail();
    }
}
