public class DigitalVideoDisc {
    
    private String title;
    private String category;
    private String director;
    private int length;
    private double cost;

    // Getters
    public String getTitle(){
        return title;
    }
    public String getCategory(){
        return category;
    }
    public String getDirector(){
        return director;
    }
    public int getLength(){
        return length;
    }
    public double getCost(){
        return cost;
    }


    // Init functions
    public DigitalVideoDisc(String title){
        this.title = title;
    }
    public DigitalVideoDisc(String title, String category, double cost){
        this(title);
        this.category = category;
        this.cost = cost;
    }
    public DigitalVideoDisc(String title, String category, String director, double cost){
        this(title, category, cost);
        this.director = director;
    }
    public DigitalVideoDisc(String title, String category, String director, int length, double cost){
        this(title, category, director, cost);
        this.length = length;
    }


    // Print detail
    void printDetail(){
        System.out.format("Disc detail:\n"
                            + "Title: %s\n"
                            + "Category: %s\n"
                            + "Director: %s\n"
                            + "Length: %d page(s)\n"
                            + "Cost: %.2f$\n\n", title, category, director, length, cost);
    }
}