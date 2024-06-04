package dsai.Store;
import java.util.ArrayList;

import dsai.Aims.media.Media;

public class Store extends Media {

    private ArrayList<Media> itemsInStore = new ArrayList<Media>();
    private int itemCount = 0;
    
    //Cho phep method addMedia duoc nhap nhieu instance Media hoac k nhap
    public void addMedia(Media... medias){

        for (Media media : medias) {
            if (!itemsInStore.contains(media)) {
                itemsInStore.add(media);
                itemCount++;
            }
            System.out.println("Item: " + media.getTitle() + " has been added");
        }
    }

    public void removeMedia(Media... medias){
        for (Media media : medias) {
            if (itemsInStore.contains(media)) {
                itemsInStore.remove(media);
                itemCount--;
            }
            System.out.println("Item: " + media.getTitle() + " has been removed");
        }
    }

    public void numberofMedia(){
        System.out.println("Current in stock: " + itemCount);
    }
}

