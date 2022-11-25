import java.util.ArrayList;
import java.util.Collections;

public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private ArrayList<DigitalVideoDisc> itemsOrdered = new ArrayList<DigitalVideoDisc>();
    private int qtyOrdered = 0;

    public int getQtyOrdered() {
        return qtyOrdered;
    }

    /**
     * Lab3: Overload addDigitalVideoDisc method.
     * <p>
     * Parameters: disc (a single disc), dvdlist (array or an unknown number of
     * discs), dvd1, dvd2 (2 discs).
     */
    public boolean addDigitalVideoDisc(DigitalVideoDisc disc) {
        if (qtyOrdered >= MAX_NUMBERS_ORDERED) {
            System.out.println("The cart is full. Can't add more!");
            return false;
        }
        itemsOrdered.add(disc);
        qtyOrdered++;
        return true;
    }

    public boolean addDigitalVideoDisc(DigitalVideoDisc[] dvdlist) {
        if (qtyOrdered + dvdlist.length > MAX_NUMBERS_ORDERED) {
            System.out.println("Cart is too full after add items in list. Can't add!");
            return false;
        }
        Collections.addAll(itemsOrdered, dvdlist);
        qtyOrdered += dvdlist.length;
        return true;
    }

    // public boolean addDigitalVideoDisc(DigitalVideoDisc... dvdlist){
    // if (qtyOrdered + dvdlist.length > MAX_NUMBERS_ORDERED){
    // System.out.println("Cart is too full after add items in list. Can't add!");
    // return false;
    // }
    // Collections.addAll(itemsOrdered, dvdlist);
    // qtyOrdered += dvdlist.length;
    // return true;
    // }
    public boolean addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
        return addDigitalVideoDisc(new DigitalVideoDisc[] { dvd1, dvd2 });
    }

    public boolean removeDigitalVideoDisc(DigitalVideoDisc disc) {
        if (!itemsOrdered.contains(disc)) {
            System.out.println("The disc is not in the cart. Can't remove!");
            disc.printDetail();
            return false;
        }
        itemsOrdered.remove(disc);
        qtyOrdered--;
        return true;
    }

    public double totalCost() {
        double total = 0;
        for (DigitalVideoDisc disc : itemsOrdered) {
            total += disc.getCost();
        }
        return total;
    }

    /**
     * Lab3: implement displayCart method. 
     * <p>
     * Prints every items in cart and cart's total cost.
     */
    public void displayCart() {
        System.out.println("***********************CART***********************");
        for (int i = 0; i < qtyOrdered; i++) {
            System.out.println((i + 1) + ". DVD - " + itemsOrdered.get(i).toString());
        }
        System.out.format("Total cost: %.2f$\n", totalCost());
    }

    /**
     * Lab3: implement searchCart method.
     * <p>
     * Search for a disc in cart by id.
     * @return the number of dvds with id <code>id</code> in cart.
     */
    public void searchCart(int id){
        long count = itemsOrdered.stream().filter(dvd -> dvd.getId() == id).count();
        System.out.format("There are %d disc(s) with id %d in your cart.\n", count, id);
    }
    /**
     * Search for a disc in cart by title.
     * @return the number of dvds with title <code>title</code> in cart.
     */
    public void searchCart(String title){
        long count = itemsOrdered.stream().filter(dvd -> dvd.isMatch(title)).count();
        System.out.format("There are %d disc(s) with title \"%s\" in your cart.\n", count, title);
    }
}