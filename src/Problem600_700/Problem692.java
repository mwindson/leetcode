package Problem600_700;

import java.util.*;

/**
 * Created by mwindson on 2017/10/13.
 * https://leetcode.com/problems/top-k-frequent-words/description/
 */
public class Problem692 {
    public static void main(String[] args) {
        String[] words = {"i", "love", "leetcode", "i", "love", "coding"};
        int k = 2;
        System.out.println(topKFrequent(words, k));
    }

    public static List<String> topKFrequent(String[] words, int k) {
        List<String> result = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((o1, o2) -> {
            if (Objects.equals(o1.getValue(), o2.getValue())) {
                return o1.getKey().compareTo(o2.getKey());
            } else {
                return o2.getValue() - o1.getValue();
            }
        });
        for (Map.Entry<String, Integer> mapping : list) {
            result.add(mapping.getKey());
            if (result.size() >= k) break;
        }
        return result;
    }
}
