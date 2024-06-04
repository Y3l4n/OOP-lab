
package dsai.Aims;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import dsai.Aims.media.Disc;
import dsai.Aims.media.Media;
import dsai.Cart.Cart;
import dsai.DigitalVideoDisc.DigitalVideoDisc;
import dsai.Store.Store;

/**
 * Aims
 */
public class Aims {

    private static Store store = new Store();
    private static Cart anOrder = new Cart();
    
    public static void showMenu(){

        System.out.println("AIMS: ");
        System.out.println("----------------------------------------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("----------------------------------------------");
        System.out.println("Please choose a number: 0-1-2-3");
        Scanner sc = new Scanner(System.in);
        short s = sc.nextShort();

        switch (s) {
            case 0:
                System.out.println("Exiting");
                break;
            case 1:
                storeMenu();
                break;
            case 2:
                updateStore();
                break;
            case 3: 
                cartMenu();
                break;
            default:
                break;
        }
        sc.close();
    }

    public static void storeMenu(){
        System.out.println("Options: ");
        System.out.println("----------------------------------------------");
        System.out.println("1. See a media's details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. See current cart");
        System.out.println("0. Back");
        System.out.println("Please choose a number: 0-1-2-3-4");

        Scanner sc = new Scanner(System.in);
        short s = sc.nextShort();
        
        switch (s) {
            case 0:
                showMenu();
                break;
            case 1:
                mediaDetailsMenu();
                break;
            case 2: 
                addToCart();
                break;
            case 3:
                playMedia();
                break;
            case 4:
                currentCart();
                break;
            default:
                break;
        }
        sc.close();
    }



    public static void mediaDetailsMenu(){
        System.out.println("Options: ");
        System.out.println("----------------------------------------------");
        System.out.println("1. Add to cart");
        System.out.println("2. Play");
        System.out.println("0. Back");
        System.out.println("----------------------------------------------");
        System.out.println("Please choose a number: 0-1-2");

        Scanner sc = new Scanner(System.in);
        short s = sc.nextShort();

        switch (s) {
            case 0:
                showMenu();
                break;
            case 1:
                addToCart();
                break;
            case 2:
                playMedia();
                break;
            default:
                break;
        }
        sc.close();
    }

    public static void addToCart(){
        System.out.println("Enter the title you want to add: ");
        Scanner scanner = new Scanner(System.in);
        DigitalVideoDisc dvd = new DigitalVideoDisc(scanner.nextLine());
        anOrder.addMedia(dvd);
        System.out.println("Current number of DVDs: " + anOrder.getItemsOrdered().size());
        scanner.close();
    }

    public static void removeFromCart(){
        System.out.println("Enter the title you want to remove: ");
        Scanner scanner = new Scanner(System.in);
        DigitalVideoDisc dvd = new DigitalVideoDisc(scanner.nextLine());
        anOrder.removeMedia(dvd);
        System.out.println("Current number of DVDs: " + anOrder.getItemsOrdered().size());
        scanner.close();

    }

    public static void playMedia(){
        System.out.println("Enter the title you want to play: ");
        Scanner scanner = new Scanner(System.in);
        DigitalVideoDisc dvd = new DigitalVideoDisc(scanner.nextLine());
        dvd.play();
        scanner.close();
    }

    public static void currentCart(){
        if (anOrder.getItemsOrdered().isEmpty()) {
            System.out.println("No item is currently in cart");
        } else {
            System.out.println("Number of items in cart: " + anOrder.getItemsOrdered().size());
            System.out.println("Details: ");
            anOrder.print();
        }
        System.out.println("Total cost: " + anOrder.totalCost());
    }

    public static void updateStore(){
        System.out.println("Options: ");
        System.out.println("----------------------------------------------");
        System.out.println("1. Add media to store");
        System.out.println("2. Remove media from store");
        System.out.println("0. Back");
        System.out.println("----------------------------------------------");
        
        Scanner sc = new Scanner(System.in);
        short s = sc.nextShort();

        switch (s) {
            case 0:
                showMenu();
                break;
            case 1:
                addMediaToStore();
                break;
            case 2:
                removeMediaFromStore();
                break;
            default:
                break;
        }
        sc.close();
    }

    public static void addMediaToStore(){
        System.out.println("Enter the title you want to add: ");
        Scanner sc = new Scanner(System.in);
        Disc disc = new Disc(sc.nextLine());
        store.addMedia(disc);
        sc.close();
    }

    public static void removeMediaFromStore(){
        System.out.println("Enter the title: ");
        Scanner sc = new Scanner(System.in);
        Disc disc = new Disc(sc.nextLine());
        store.removeMedia(disc);
        sc.close();
    }

    public static void cartMenu(){
        System.out.println("Options: ");
        System.out.println("----------------------------------------------");
        System.out.println("1. Filter media in cart");
        System.out.println("2. Sort media in cart");
        System.out.println("3. Remove media from cart");
        System.out.println("4. Play a media");
        System.out.println("5. Place order");
        System.out.println("0. Back");
        System.out.println("----------------------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4-5");

        Scanner sc = new Scanner(System.in);
        short s = sc.nextShort();
        switch (s) {
            case 0:
                showMenu();
                break;
            case 1:
                filterMediaInCart();
                break;
            case 2: 
                sortMediaInCart();
                break;
            case 3:
                removeFromCart();
                break;
            case 4:
                playMedia();
                break;
            case 5:
                placeOrder();
                break;
            default:
                break;
        }
        sc.close();
    }

    public static void filterMediaInCart(){
        System.out.println("Options: ");
        System.out.println("----------------------------------------------");
        System.out.println("1. Filter by id");
        System.out.println("2. Filter by title");
        System.out.println("0. Back");
        System.out.println("----------------------------------------------");
        System.out.println("Choose a number: 0-1-2");
        Scanner sc = new Scanner(System.in);
        short s = sc.nextShort();

        switch (s) {
            case 0:
                showMenu();
                break;
            case 1:
                filterByTitle();
                break;
            case 2:
                filterById();
                break;
            default:
                break;
        }
        sc.close();
    }

    public static void filterByTitle(){
        System.out.println("Enter the title to filter: ");
        Scanner sc = new Scanner(System.in);
        String res = sc.nextLine();
        List<Media> allRes = new ArrayList<>();
        for (Media media : anOrder.getItemsOrdered()) {
            if (media.getTitle() == res) {
                allRes.add(media);
                System.out.println(media.toString());
            } else {
                System.out.println("No media has this title");
            }
        }
        sc.close();
    }

    public static void filterById(){
        System.out.println("Enter the ID to filter: ");
        Scanner sc = new Scanner(System.in);
        int res = sc.nextInt();
        List<Media> allRes = new ArrayList<>();
        for (Media media : anOrder.getItemsOrdered()) {
            if (media.getId() == res) {
                allRes.add(media);
                System.out.println(media.toString());
            } else {
                System.out.println("No media has this id");
            }
        }
        sc.close();
    }

    public static void sortMediaInCart(){
        System.out.println("Options: ");
        System.out.println("----------------------------------------------");
        System.out.println("1. Sort by id");
        System.out.println("2. Sort by title");
        System.out.println("0. Back");
        System.out.println("----------------------------------------------");
        System.out.println("Choose a number: 0-1-2");
        Scanner sc = new Scanner(System.in);
        short s = sc.nextShort();

        switch (s) {
            case 0:
                showMenu();
                break;
            case 1:
                sortByTitle();
                break;
            case 2:
                sortByCost();
                break;
            default:
                break;
        }
        sc.close();
    }

    // Implemented method needs overriding to use
    public static void sortByTitle(){
        Collections.sort(anOrder.getItemsOrdered(), new Comparator<Media>() {
            @Override
            public int compare (Media m1, Media m2){
                return m1.getTitle().compareTo(m2.getTitle());
            }
        });
        System.out.println("List sorted by title: " + anOrder.getItemsOrdered());
    }

    public static void sortByCost(){
        Collections.sort(anOrder.getItemsOrdered(), new Comparator<Media>() {
            @Override
            public int compare(Media m1, Media m2) {
                int costComparison = Float.compare(m2.getCost(), m1.getCost());
                if (costComparison == 0) {
                    return m1.getTitle().compareToIgnoreCase(m2.getTitle());
                }
                return costComparison;
            }
        });
        System.out.println("Cart sorted by cost: " + anOrder.getItemsOrdered());
    }


    public static void placeOrder(){
        currentCart();
        System.out.println("Order created");
    }

    public static void main(String[] args) {

        showMenu();
    }
}
