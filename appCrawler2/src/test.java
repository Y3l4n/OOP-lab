import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class test {
    public static void main(String[] args) {
        String svgCode = "<img src=\"https://cryptopotato.com/wp-content/uploads/thumbs/CZ-3icn2f6fsqk23jq54b1iq2.webp\" alt=\"Ex-Binance CEO Changpeng Zhao Receives 4 Months Jail Time For AML Violations\" class=\"media-object\" />";
        String svgCodeWithBase64 = "<svg xmlns=\"http://www.w3.org/2000/svg\" viewBox=\"0 0 460 295\" width=\"460\" height=\"295\" data-u=\"aHR0cHM6Ly9jcnlwdG9wb3RhdG8uY29tL3dwLWNvbnRlbnQvdXBsb2Fkcy90aHVtYnMvQ1otM2ljbjJmNmZzcWs...\" data-w=\"460\" data-h=\"295\" data-bip=\"\"></svg>";

        String imageLink1 = extractImageLink(svgCode);
        String imageLink2 = extractImageLink(svgCodeWithBase64);

        System.out.println("Image Link 1: " + imageLink1);
        System.out.println("Image Link 2: " + imageLink2);
    }

    public static String extractImageLink(String code) {
        String imageLink = extractBase64EncodedImageLink(code);

        if (imageLink == null) {
            imageLink = extractDirectImageLink(code);
        }

        return imageLink;
    }

    public static String extractBase64EncodedImageLink(String code) {
        Pattern pattern = Pattern.compile("data-u=\"([^\"]+)\"");
        Matcher matcher = pattern.matcher(code);

        if (matcher.find()) {
            String encodedImageLink = matcher.group(1);
            String decodedImageLink = decodeURL(encodedImageLink);
            return decodedImageLink;
        }

        return null;
    }

    public static String extractDirectImageLink(String code) {
        Pattern pattern = Pattern.compile("<img[^>]+src\\s*=\\s*[\"']([^\"']+)\"[^>]*>");
        Matcher matcher = pattern.matcher(code);

        if (matcher.find()) {
            return matcher.group(1);
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
}