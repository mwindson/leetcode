package Problem101_200;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mwindson on 2017/4/4.
 * https://leetcode.com/problems/palindrome-partitioning/#/description
 */
public class Problem131 {
    public static void main(String[] args) {
        String s = "aba";
        System.out.println(partition(s));
    }

    public static List<List<String>> partition(String s) {
        List<List<String>> list = new ArrayList<>();
        List<String> tmpList = new ArrayList<>();
        backTracking(list, tmpList, s, 0);
        return list;
    }

    private static void backTracking(List<List<String>> list, List<String> tmpList, String s, int index) {
        if (index == s.length()) {
            list.add(new ArrayList<>(tmpList));
        } else {
            for (int i = index + 1; i <= s.length(); i++) {
                if (!ispalindrome(s.substring(index, i))) continue;
                tmpList.add(s.substring(index, i));
                backTracking(list, tmpList, s, i);
                tmpList.remove(tmpList.size() - 1);
            }
        }
    }

    private static boolean ispalindrome(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i))
                return false;
        }
        return true;
    }
}
