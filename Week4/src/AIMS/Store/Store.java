package AIMS.Store;
import java.util.List;
import java.util.ArrayList;

import AIMS.media.Media;
    
public class Store {

    private ArrayList<Media> storeItems = new ArrayList<Media>();
    

    public void printDetail() {
        System.out.println("Store items:");
        for (Media media : storeItems) {
            media.printDetail();
        }
    }

    public void addMedia(Media media) {
        storeItems.add(media);
    }

    public boolean removeMedia(Media media) {
        if (!storeItems.contains(media)) {
            System.out.println("The media is not in the store. Can't remove!");
            return false;
        }
        storeItems.remove(media);
        return true;
    }

    public Media searchMedia(String title) {
        return storeItems.stream().filter(media -> media.getTitle().equalsIgnoreCase(title)).findFirst().orElse(null); 
    }

    public ArrayList<Media> getStoreItems() {
        return storeItems;
    }
}

