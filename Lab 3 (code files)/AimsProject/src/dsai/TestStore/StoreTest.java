package dsai.TestStore;
import dsai.DigitalVideoDisc.DigitalVideoDisc;
import dsai.Store.Store;

public class StoreTest {
    public static void main(String[] args) {
        Store store = new Store(5);

        DigitalVideoDisc dvd1 = new DigitalVideoDisc("DVD1");
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("DVD2");
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("DVD3");

        store.addDVD(dvd1);
        store.addDVD(dvd2);
        store.addDVD(dvd3);

        store.removeDVD(dvd2); //Remove DVD2
        store.removeDVD(dvd2); //Try to remove DVD2 again

        DigitalVideoDisc dvd4 = new DigitalVideoDisc("DVD4");
        DigitalVideoDisc dvd5 = new DigitalVideoDisc("DVD5");
        DigitalVideoDisc dvd6 = new DigitalVideoDisc("DVD6");

        store.addDVD(dvd4); 
        store.addDVD(dvd5); 
        store.addDVD(dvd6); //Try to add DVD6 (store is full)
    }
}
