package dsai.Aims.media;

import java.util.Comparator;

public abstract class Media {

    private int id;
    private String title;
    private String category;
    private float cost;

    public Media(String title) {
        this.title = title;
    }

    public Media(String title2, String category2, float cost2) {
        //TODO Auto-generated constructor stub
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
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Media media = (Media) obj;
        return title.equals(media.getTitle());
    }

    @Override
    public String toString() {
        String res = "Media: ";
        if (getTitle() != null) {
            res += getTitle();
        }
        if (getCategory() != null) {
            res += getCategory();
        }
        if (getCost() != 0.0) {
            res += getCost();
        }
        return res;
    }

    public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitle();
    public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCost();

}