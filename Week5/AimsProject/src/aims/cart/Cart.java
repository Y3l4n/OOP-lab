package aims.cart;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

import aims.media.Media;

public class Cart {

    public static final int MAX_NUMBERS_ORDERED = 20;
    private List<Media> itemsOrdered = new ArrayList<Media>();

    public boolean addMedia(Media media) {
        if (itemsOrdered.size() >= MAX_NUMBERS_ORDERED) {
            return false;
        }
        itemsOrdered.add(media);
        return true;
    }

    public boolean addMedia(Media... medialist) {
        if (itemsOrdered.size() + medialist.length > MAX_NUMBERS_ORDERED) {
            System.out.println("Cart is too full after add items in list. Can't add!");
            return false;
        }
        Collections.addAll(itemsOrdered, medialist);
        return true;
    }

    public boolean removeMedia(Media media) {
        if (!itemsOrdered.contains(media)) {
            System.out.println("The media is not in the cart. Can't remove!");
            return false;
        }
        itemsOrdered.remove(media);
        return true;
    }

    public double totalCost() {
        double total = 0;
        for (Media media : itemsOrdered) {
            total += media.getCost();
        }
        return total;
    }

    public void displayCart() {
        System.out.println("Cart: ");
        for (int i = 0; i < itemsOrdered.size(); i++)
            System.out.println((i + 1) + ". " + itemsOrdered.get(i).toString());
        System.out.format("Total cost: %.2f$\n", totalCost());
    }

    public Media searchCart(int id) {
        return itemsOrdered.stream().filter(media -> media.getId() == id).findFirst().orElse(null);
    }

    public Media searchCart(String title) {
        return itemsOrdered.stream().filter(media -> media.getTitle().equalsIgnoreCase(title)).findFirst().orElse(null);
    }

    public void sortCartByTitle(){
        Collections.sort(itemsOrdered, Media.COMPARE_BY_TITLE_COST);
    }
    public void sortCartByCost(){
        Collections.sort(itemsOrdered, Media.COMPARE_BY_COST_TITLE);
    }
}