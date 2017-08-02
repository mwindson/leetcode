package Problem600_700;

import java.util.Arrays;
import java.util.List;

/**
 * Created by mwindson on 2017/8/1.
 * https://leetcode.com/problems/replace-words/description/
 */
public class Problem648 {
    public static class TrieNode {
        private int size = 26;
        public TrieNode[] children;// 孩子
        public char val; // 字节值
        public boolean isEnd;// 是否结束

        public TrieNode() {
            children = new TrieNode[size];
        }

        public TrieNode(char c) {
            children = new TrieNode[size];
            val = c;
        }
    }

    public static void main(String[] args) {
        List<String> dict = Arrays.asList("cat", "bat", "rat", "ra");
        String sentence = "the cattle was rattled by the battery";
        System.out.println(replaceWords(dict, sentence));
    }

    public static String replaceWords(List<String> dict, String sentence) {
        TrieNode root = new TrieNode();
        for (String s : dict) {
            char[] chars = s.toCharArray();
            TrieNode node = root;
            for (int i = 0; i < chars.length; i++) {
                if (node.children[chars[i] - 'a'] == null) {
                    node.children[chars[i] - 'a'] = new TrieNode(chars[i]);
                }
                node = node.children[chars[i] - 'a'];
            }
            node.isEnd = true;
        }
        String[] words = sentence.split(" ");
        StringBuilder res = new StringBuilder();
        for (String s : words) {
            TrieNode node = root;
            StringBuilder str = new StringBuilder();
            for (char c : s.toCharArray()) {
                if (node.children[c - 'a'] == null) {
                    str = new StringBuilder(s);
                    break;
                } else {
                    node = node.children[c - 'a'];
                    str.append(node.val);
                    if (node.isEnd) {
                        break;
                    }
                }
            }
            res.append(str).append(" ");
        }
        return res.substring(0, res.length() - 1);
    }
}
