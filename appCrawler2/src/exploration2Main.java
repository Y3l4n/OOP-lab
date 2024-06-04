import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//websiteSource(default), title, category(optional), url, author, time, fullContent, reference, type(article)

/**
 * exploration2Main
 */
public class exploration2Main {

    public static void main(String[] args) {
        String url = "https://cryptoslate.com/news/page/2/";

        try {
            
            Document doc = Jsoup.connect(url).get();
            Elements contents = doc.select(".list-post");
            for (Element element : contents) {
                String link = element.select("a").attr("href");
                System.out.println(link);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}