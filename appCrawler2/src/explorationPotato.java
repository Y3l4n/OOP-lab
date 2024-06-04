import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class explorationPotato {

    public static String extractImageLinkFromSVG(String svgCode) {
        Pattern pattern = Pattern.compile("data-u=\"(.*?)\"");
        Matcher matcher = pattern.matcher(svgCode);

        if (matcher.find()) {
            String encodedImageLink = matcher.group(1);
            String imageLink = decodeURL(encodedImageLink);
            return imageLink;
        }

        return null;
    }

    public static String decodeURL(String encodedURL) {
        try {
            return URLDecoder.decode(encodedURL, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static void main(String[] args) {

        List<Article> articleList = new ArrayList<>();
        for (int i = 1; i < 161; i++) {

            String url = "https://cryptopotato.com/category/crypto-news/page/" + i + "/";
            System.out.println(url);
            try {
                Document doc = Jsoup.connect(url).get();
                Elements contents = doc.getElementsByTag("article");
                for (Element element : contents) {
                    String websiteSource = "https://cryptopotato.com/";
                    String title = element.selectFirst("h3 > a").text();
                    String link = element.selectFirst("h3 > a").attr("href");
                    String content = "";
                    String category = "";
                    String type = "News";
                    String author = "";
                    String creationDate = "";
                    String pictureLink = "";

                    String temppictureLink = element.getElementsByTag("img").attr("src");
                    if (temppictureLink.contains("https://")) {
                        pictureLink = temppictureLink;
                    } else {
                        String trimmedLinks = temppictureLink.substring(temppictureLink.indexOf(",") + 1);
                        byte[] decodedBytes = Base64.getDecoder().decode(trimmedLinks);
                        String svgContent = new String(decodedBytes);
                        pictureLink =  extractImageLinkFromSVG(svgContent);
                    }

                    List<String> referenceLinks = new ArrayList<>();
                    try {
                        Document articleDoc = Jsoup.connect(link).get();
                        author = articleDoc.select(".entry-user").text().replace("Author: ", "");

                        String tempDate = articleDoc.select(".last-modified-timestamp").text();
                        creationDate = tempDate.substring(0, tempDate.indexOf("@")).trim();

                        Elements articleContent = articleDoc.getElementsByClass("coincodex-content").select("p");
                        for (Element subarticleContent : articleContent) {
                            String subContents = subarticleContent.text();
                            content += subContents + "\n";
                        }
                        
                        Elements fullCategory = articleDoc.select("a[rel=tag]");

                        if (fullCategory.isEmpty()) {
                            category = "General news";
                        } else {
                            for (Element fullEleCategory : fullCategory) {
                                String cates = fullEleCategory.text();
                                category += cates + ", ";
                            }
                            category = category.substring(0, category.length() - 2);
                        }

                        Elements reference = articleContent.select("p > a");
                        for (Element referenceElement : reference) {
                            String refs = referenceElement.attr("href");
                            referenceLinks.add(refs);
                        }
                    
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    Article article = new Article(websiteSource, type, title, category, author, link, creationDate, content, referenceLinks, pictureLink);
                    articleList.add(article);
                    TimeUnit.MILLISECONDS.sleep(500);

                }
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        // Convert article list to JSON
        String json = gson.toJson(articleList);

        // Specify the file path to save the JSON file
        String filePath = "Potato2.json";

        // Save the JSON data to a file
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Finished operation");
    }
}