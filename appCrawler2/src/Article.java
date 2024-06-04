
import java.util.List;

public class Article {
    private String websiteSource;
    private String type;
    private String title;
    private String category;
    private String author;
    private String link;
    private String creationDate;
    private String content;
    private List<String> referenceLinks;
    private String pictureLink;


    public Article(String websiteSource, String type, String title, String category, String author, String link,
            String creationDate, String content, List<String> referenceLinks, String pictureLink) {
        this.websiteSource = websiteSource;
        this.type = type;
        this.title = title;
        this.category = category;
        this.author = author;
        this.link = link;
        this.creationDate = creationDate;
        this.content = content;
        this.referenceLinks = referenceLinks;
        this.pictureLink = pictureLink;
    }


    public String getWebsiteSource() {
        return websiteSource;
    }


    public void setWebsiteSource(String websiteSource) {
        this.websiteSource = websiteSource;
    }


    public String getType() {
        return type;
    }


    public void setType(String type) {
        this.type = type;
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


    public String getAuthor() {
        return author;
    }


    public void setAuthor(String author) {
        this.author = author;
    }


    public String getLink() {
        return link;
    }


    public void setLink(String link) {
        this.link = link;
    }


    public String getCreationDate() {
        return creationDate;
    }


    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }


    public String getContent() {
        return content;
    }


    public void setContent(String content) {
        this.content = content;
    }


    public List<String> getReferenceLinks() {
        return referenceLinks;
    }


    public void setReferenceLinks(List<String> referenceLinks) {
        this.referenceLinks = referenceLinks;
    }


    public String getPictureLink() {
        return pictureLink;
    }


    public void setPictureLink(String pictureLink) {
        this.pictureLink = pictureLink;
    }
    
    
}