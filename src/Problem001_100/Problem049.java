package Problem001_100;

import java.util.*;

/**
 * Created by mwindson on 2017/2/23.
 * https://leetcode.com/problems/anagrams/?tab=Description
 */
public class Problem049 {
    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(strs));
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> letters = new HashMap<String, List<String>>();
        for (String s : strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String newStr = String.valueOf(chars);
            if (!letters.containsKey(newStr))
                letters.put(newStr, new ArrayList<>());
            letters.get(newStr).add(s);

        }
        return new ArrayList<List<String>>(letters.values());
    }
}
