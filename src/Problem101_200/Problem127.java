package Problem101_200;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

/**
 * 127. Word Ladder
 * https://leetcode.com/problems/word-ladder/description/
 *
 * @ tag BFS
 */
public class Problem127 {
    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");
        System.out.println(ladderLength(beginWord, endWord, wordList));
    }

    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<String> queue = new ArrayDeque<>();
        queue.add(beginWord);
        int length = 1;
        boolean[] visited = new boolean[wordList.size()];
        int size = queue.size();
        while (!queue.isEmpty()) {
            for (int i = 0; i < size; i++) {
                String curr = queue.poll();
                if (curr.equals(endWord)) return length;
                for (int j = 0; j < wordList.size(); j++) {
                    if (visited[j]) continue;
                    String s = wordList.get(j);
                    if (oneDistinct(curr, s)) {
                        queue.add(s);
                        visited[j] = true;
                    }
                }
            }
            size = queue.size();
            length++;
        }
        return length;
    }

    private static boolean oneDistinct(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        int diffNum = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                diffNum++;
            }
        }
        return diffNum == 1;
    }
}
