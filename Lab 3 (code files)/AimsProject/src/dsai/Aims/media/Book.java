package dsai.Aims.media;

import java.util.ArrayList;
import java.util.List;

/**
 * Book
 */
public class Book extends Media {

    private int id; 
    private String title;
    private String category;
    private float cost;
    private List<String> authors = new ArrayList<String>();

    public List<String> getAuthors() {
        return authors;
    }

    public Book(){
        super();
    }

    public void addAuthor(String authorName){
        if (authors.contains(authorName)) {
            System.out.println("Author is already in list");
        } else {
            authors.add(authorName);
        }
    }

    public void removeAuthor(String authorName){
        if (authors.contains(authorName)) {
            authors.remove(authorName);
        } else {
            System.out.println("Author is not in list. Cannot remove");
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    @Override
    public String toString(){
        String book = "Book: ";
        if (getTitle() != null) {
            book += getTitle();
        }
        if (getCategory() != null) {
            book += getCategory();
        }
        if (getCost() != 0.0) {
            book += getCost();
        }
        return book;
    }
}
