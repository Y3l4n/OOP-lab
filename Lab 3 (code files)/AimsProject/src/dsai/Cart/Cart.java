package dsai.Cart;


import java.util.ArrayList;
import java.util.Scanner;

import dsai.Aims.media.Media;
import dsai.DigitalVideoDisc.DigitalVideoDisc;

public class Cart extends Media {

    public static final int MAX_NUMBER_ORDERED = 20;
    //Create a new array with a max_length = 20
    // private DigitalVideoDisc[] itemsOrdered = new DigitalVideoDisc[MAX_NUMBER_ORDERED];
    // private int qtyOrdered;
    private ArrayList<Media> itemsOrdered = new ArrayList<Media>();

    public void addMedia(Media... addedMedia){
        for (Media media : addedMedia) {
            if (MAX_NUMBER_ORDERED > itemsOrdered.size()) {
                itemsOrdered.add(media);
            } else {
                System.out.println("Cart is full. Cannot add more items");
            }
        }
    }

    public void removeMedia(Media... removedMedia) {
        for (Media media : removedMedia) {
            if (itemsOrdered.remove(media)) {
                System.out.println(media.getTitle() + " has been removed from the cart.");
            } else {
                System.out.println(media.getTitle() + " is not in the cart.");
            }
        }
    }

    public ArrayList<Media> getItemsOrdered(){
        return itemsOrdered;
    
    }
    public void print() {
        if (itemsOrdered.isEmpty()) {
            System.out.println("The cart is empty.");
        } else {
            System.out.println("Cart items:");
            for (Media item : itemsOrdered) {
                System.out.println(item.getTitle() + " - $" + item.getCost());
            }
        }
    }

    public void displayCart() {
        System.out.println("Items in the cart:");
        for (Media media : itemsOrdered) {
            System.out.println(media.getTitle() + " - " + media.getCost() + "$");
        }
        System.out.println("Total cost: " + totalCost() + "$");
    }

    public void sortByTitle() {
        itemsOrdered.sort(Media.COMPARE_BY_TITLE_COST);
    }

    public void sortByCost() {
        itemsOrdered.sort(Media.COMPARE_BY_COST_TITLE);
    }

    public float totalCost() {
        float total = 0;
        for (Media media : itemsOrdered) {
            total += media.getCost();
        }
        return total;
    }
}

