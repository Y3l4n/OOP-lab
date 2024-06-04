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

public class explorationETHPressRelease {

    public static void main(String[] args) {
        List<Article> articleList = new ArrayList<>();

        for (int i = 1; i < 2; i++) {
            String url = "https://www.ethnews.com/category/press-release/page/" + i + "/";
            try {
                Document doc = Jsoup.connect(url).get();

                Elements contents = doc.select(".tdb_module_loop.td_module_wrap.td-animation-stack.td-cpt-post");

                for (Element element : contents) {
                    String websiteSource = "https://www.ethnews.com/";
                    String title = element.selectFirst("h3 > a").text();
                    String link = element.selectFirst("h3 > a").attr("href");
                    String content = "";
                    String category = "";
                    String type = "Press release";
                    List<String> referenceLinks = new ArrayList<>();
                    try {
                        Document articleDoc = Jsoup.connect(link).get();
                        Elements articleContent = articleDoc.getElementsByClass("td_block_wrap tdb_single_content tdi_63 td-pb-border-top td_block_template_1 td-post-content tagdiv-type").select("p");
                        for (Element subarticleContent : articleContent) {
                            String subContent = subarticleContent.text();
                            content += subContent + "\n";
                        }

                        Elements fullCategory = articleDoc.getElementsByClass("tdb-tags").select("li");
                        if (fullCategory.isEmpty()) {
                            category = "General news";
                        } else {
                            for (Element fullEleCategory : fullCategory) {
                                String cates = fullEleCategory.text();
                                category += cates + ", ";
                            }
                            String tempCategory2 = category.substring(6);
                            category = tempCategory2.substring(0, tempCategory2.length() - 2);
                        }

                        // Extract references from full content
                        Elements fullArticle = articleDoc.getElementsByClass("vc_column tdi_55  wpb_column vc_column_container tdc-column td-pb-span8");
                        Elements reference = fullArticle.select("p > a");
                        for (Element referenceElement : reference) {
                            String refs = referenceElement.attr("href");
                            referenceLinks.add(refs);
                        }
                        
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    // Trim - from author
                    String author = element.selectFirst(".td-post-author-name").text().replace(" -", "");
                    String creationDate = element.selectFirst(".entry-date.updated.td-module-date").text();
                    Article article = new Article(websiteSource, type, title, category, author, link, creationDate, content, referenceLinks);
                    articleList.add(article);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        // Convert article list to JSON
        String json = gson.toJson(articleList);

        // Specify the file path to save the JSON file
        String filePath = "ETHPressRelease.json";

        // Save the JSON data to a file
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Finished operation");
    }
}