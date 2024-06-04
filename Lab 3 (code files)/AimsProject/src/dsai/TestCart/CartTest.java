package dsai.TestCart;

import dsai.Aims.media.MediaComparatorByCost;
import dsai.Aims.media.MediaComparatorByTitle;
import dsai.Cart.Cart;
import dsai.DigitalVideoDisc.DigitalVideoDisc;

import java.util.Collections;

public class CartTest {
    public static void main(String[] args) {

        Cart cart = new Cart();

        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation",
                "Roger Allers", 87, 19.95f);
        cart.addMedia(dvd1);

        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction",
                "George Lucas", 87, 24.95f);
        cart.addMedia(dvd2);

        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladdin", "Animation", 18.99f);
        cart.addMedia(dvd3);

        // Print the cart before sorting
        System.out.println("Before sorting:");
        cart.print();

        MediaComparatorByTitle comparator = new MediaComparatorByTitle();
        Collections.sort(cart.getItemsOrdered(), comparator);

        // Print the cart after sorting
        System.out.println("\nAfter sorting:");
        cart.print();
    }
}