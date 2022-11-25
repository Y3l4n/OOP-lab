import java.util.ArrayList;

public class Store {

    private ArrayList<DigitalVideoDisc> storeItems = new ArrayList<DigitalVideoDisc>();

    public void printDetail() {
        System.out.println("Store items:");
        for (DigitalVideoDisc dvd : storeItems) {
            dvd.printDetail();
        }
    }

    /**
     * Lab3: implement addDVD method.
     * <p>
     * Check if <code> disc </code> is already in the store.
     * If not, add it to the <code> storeItems </code> array.
     */
    public boolean addDVD(DigitalVideoDisc disc) {
        if (storeItems.contains(disc)) {
            System.out.println("The disc is already in the store. Can't add!");
            return false;
        }
        storeItems.add(disc);
        return true;
    }

    /**
     * Lab3: implement removeDVD method.
     */
    public boolean removeDVD(DigitalVideoDisc disc) {
        if (!storeItems.contains(disc)) {
            System.out.println("The disc is not in the store. Can't remove!");
            return false;
        }
        storeItems.remove(disc);
        return true;
    }
}