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

public class exploration2 {

    
    public static void main(String[] args) {
        List<Article> articleList = new ArrayList<>();
        String url = "https://www.investing.com/news/cryptocurrency-news";
        try {
            Document doc = Jsoup.connect(url).get();
            Elements content = doc.getElementsByClass("list_list__item__dwS6E !mt-0 border-t border-solid border-[#E6E9EB] py-6");
            for (Element element : content) {
                String websiteSource = "Investing.com";
                String type = "Article";
                String title = element.getElementsByClass("text-secondary hover:text-secondary hover:underline focus:text-secondary focus:underline whitespace-normal text-sm font-bold leading-5 !text-[#181C21] sm:text-base sm:leading-6 lg:text-lg lg:leading-7").text();
                String articleUrl = "https://www.investing.com" + element.getElementsByClass("text-secondary hover:text-secondary hover:underline focus:text-secondary focus:underline whitespace-normal text-sm font-bold leading-5 !text-[#181C21] sm:text-base sm:leading-6 lg:text-lg lg:leading-7").attr("href");
                String author = element.getElementsByClass("shrink-0 text-xs leading-4").text();
                String time = element.getElementsByClass("mx-1 shrink-0 text-xs leading-4").attr("datetime");
                String excerpt = element.getElementsByClass("mt-[0.5rem] hidden overflow-hidden text-xs leading-[1.38rem] md:block").text();
                String fullContent = "";
                try {
                    Document articleDoc = Jsoup.connect(articleUrl).get();
                    Elements articleContent = articleDoc.getElementsByClass("article_WYSIWYG__O0uhw article_articlePage__UMz3q text-[18px] leading-8");
                    fullContent = articleContent.text();

                } catch (IOException e) {
                    e.printStackTrace();
                }
                List<String> references = new ArrayList<>();
                Article article = new Article(websiteSource, title, articleUrl, author, time, excerpt, fullContent, references, type);
                articleList.add(article);
            }

            
            Gson gson = new GsonBuilder().setPrettyPrinting().create();

            // Convert article list to JSON
            String json = gson.toJson(articleList);

            // Specify the file path to save the JSON file
            String filePath = "articles2.json";

            // Save the JSON data to a file
            FileWriter writer = new FileWriter(filePath);
            writer.write(json);
            writer.close();

            System.out.println("Articles have been saved to " + filePath);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
