import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * crawlerTest2
 */
public class crawlerTest2 {

    public static void main(String[] args) {
        
        String url = "https://www.ethnews.com/shibs-burn-rate-explodes-how-shiba-inu-is-heating-up-the-crypto-market/";
        String contents = "";
        try {
            Document doc = Jsoup.connect(url).get();
            // Elements content = doc.getElementsByClass("td_block_wrap tdb_single_content tdi_63 td-pb-border-top td_block_template_1 td-post-content tagdiv-type").select("p");
            // for (Element element : content) {
            //     String subContents = element.text();
            //     // System.out.println(subContents);
            //     contents += subContents + "\n";
            // }
            Elements content = doc.getElementsByClass("tdb-tags").select("li");
            for (Element element : content) {
                String subContents = element.text();
                contents += subContents + ", ";
            }
            String tempContents = contents.substring(6);
            contents = tempContents.substring(0, tempContents.length() - 2);

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(contents);
    }
}