package AIMS.media;

import java.util.Comparator;

public abstract class Media {

    protected int id;
    protected String title;
    protected String category;
    protected double cost;

    public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
    public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();

    public Media() {
    }

    public Media(int id, String title, String category, double cost) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.cost = cost;
    }

    public int getId() {
        return id;
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

    public double getCost() {
        return cost;
    }

    @Override
    public abstract String toString();

    public void printDetail() {
        System.out.println(toString());
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Media))
            return false;
        return this.id == ((Media) obj).id;
    }
}