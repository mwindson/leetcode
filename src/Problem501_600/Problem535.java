package Problem501_600;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by mwindson on 2017/6/4.
 * https://leetcode.com/problems/encode-and-decode-tinyurl/#/solutions
 */
public class Problem535 {
    public static void main(String[] args) {
        Codec codec = new Codec();
        String url = "https://leetcode.com/problems/design-tinyurl";
        codec.decode(codec.encode(url));
    }

    public static class Codec {
        Map<Integer, String> map = new HashMap<>();

        // Encodes a URL to a shortened URL.
        public String encode(String longUrl) {
            map.put(longUrl.hashCode(), longUrl);
            return "http://tinyurl.com/" + longUrl.hashCode();
        }

        // Decodes a shortened URL to its original URL.
        public String decode(String shortUrl) {
            return map.get(Integer.parseInt(shortUrl.replace("http://tinyurl.com/", "")));
        }
    }
}
