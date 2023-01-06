package aims.media.book;

import java.util.*;

import aims.media.Media;

public class Book extends Media {

    private List<String> authors = new ArrayList<String>();

    public Book() {
    }

    public Book(int id, String title, String category, double cost, String... authors) {
        super(id, title, category, cost);
        Collections.addAll(this.authors, authors);
    }

    public boolean addAuthor(String authorName) {
        if (authors.contains(authorName)) {
            System.out.println("Author already exists!");
            return false;
        }
        authors.add(authorName);
        return true;
    }

    public boolean removeAuthor(String authorName) {
        if (!authors.contains(authorName)) {
            System.out.println("Author doesn't exist!");
            return false;
        }
        authors.remove(authorName);
        return true;
    }

    @Override
    public String toString() {
        return String.format("%s - %s: %.2f$", title, category, cost);
    }
}
