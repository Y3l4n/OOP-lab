package dsai.Aims.media;

import java.util.ArrayList;
import java.util.List;

import dsai.DigitalVideoDisc.DigitalVideoDisc;

public class test {

    public static void main(String[] args) {

        List<Media> mediae = new ArrayList<>();
        CompactDisc cd1 = new CompactDisc(1, "Alice in Wonderland", "Fantasy", 0.5f, 0.5f, "Heh");
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("Me");

        // Create a new Book object
        Book book = new Book();
        
        mediae.add(dvd1);
        mediae.add(cd1);
        mediae.add(book);

        for (Media media : mediae) {
            System.out.println(media.toString());
        }
        // // Set attributes for the book
        // book.setId(1);
        // book.setTitle("Introduction to Algorithms");
        // book.setCategory("Computer Science");
        // book.setCost(50.0f);

        // // Add authors to the book
        // book.addAuthor("Thomas H. Cormen");
        // book.addAuthor("Charles E. Leiserson");
        // book.addAuthor("Ronald L. Rivest");
        // book.addAuthor("Clifford Stein");

        // // Test getting attributes
        // System.out.println("Book ID: " + book.getId());
        // System.out.println("Book Title: " + book.getTitle());
        // System.out.println("Book Category: " + book.getCategory());
        // System.out.println("Book Cost: $" + book.getCost());
        // System.out.println("Book Authors: " + book.getAuthors());

        // // Test adding duplicate author
        // book.addAuthor("Thomas H. Cormen");

        // // Test removing author
        // book.removeAuthor("Ronald L. Rivest");
        // System.out.println("Book Authors after removal: " + book.getAuthors());

        // // Test removing non-existing author
        // book.removeAuthor("John Doe");
    }
}
