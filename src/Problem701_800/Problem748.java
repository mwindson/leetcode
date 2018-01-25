package Problem701_800;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 748. Shortest Completing Word
 * https://leetcode.com/problems/shortest-completing-word/description/
 *
 * @ tag HashTable
 */
public class Problem748 {
    public static void main(String[] args) {
        String licensePlate = "1s3 PSt";
        String[] words = {"step", "steps", "stripe", "stepple"};
        System.out.println(shortestCompletingWord(licensePlate, words));
    }

    public static String shortestCompletingWord(String licensePlate, String[] words) {
        List<String> list = new ArrayList<>();
        Map<Character, Integer> license = new HashMap<>();
        for (char c : licensePlate.toLowerCase().toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                license.put(c, license.getOrDefault(c, 0) + 1);
            }
        }
        for (String word : words) {
            Map<Character, Integer> wordMap = new HashMap<>();
            for (char c : word.toLowerCase().toCharArray()) {
                wordMap.put(c, wordMap.getOrDefault(c, 0) + 1);
            }
            boolean isComplete = true;
            for (char c : license.keySet()) {
                if (wordMap.get(c) == null || wordMap.get(c) < license.get(c)) {
                    isComplete = false;
                    break;
                }
            }
            if (isComplete) {
                if (list.isEmpty() || word.length() < list.get(0).length()) {
                    list = new ArrayList<>();
                    list.add(word);
                }
            }
        }
        return list.isEmpty() ? "" : list.get(0);
    }
}
