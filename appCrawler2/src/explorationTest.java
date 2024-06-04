import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Base64;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * explorationTest
 */
public class explorationTest {

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
        
        String url = "https://cryptopotato.com/category/crypto-news/page/19/";
        String mainTags = "";
        try {
            Document doc = Jsoup.connect(url).get();
            
            Elements elements = doc.getElementsByTag("article");
            for (Element element : elements) {
                String pictureLink = element.getElementsByTag("img").attr("src");

                if (pictureLink.contains("https://")) {
                    System.out.println(pictureLink);
                } else {
                    String trimmedLinks = pictureLink.substring(pictureLink.indexOf(",") + 1);
                    byte[] decodedBytes = Base64.getDecoder().decode(trimmedLinks);
                    String svgContent = new String(decodedBytes);
                    String imageLink = extractImageLinkFromSVG(svgContent);
                    System.out.println("Image Link: " + imageLink);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}