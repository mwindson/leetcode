package Problem101_200;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * Created by mwindson on 2017/3/14.
 * https://leetcode.com/problems/word-break/#/description
 */
public class Problem139 {
    public static void main(String[] args) {
        String[] words = {"leet", "code"};
        List<String> wordDict = Arrays.asList(words);
        String s = "leetcodecode";
        System.out.println(wordBreak(s, wordDict));
    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        boolean[] f = new boolean[s.length() + 1];

        f[0] = true;

        // f[i]:whether subarray(0, i) can be segmented into words from the dictionary.
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                //当f[j]为true且wordDict包含substring(j,i)说明 f[i]可被分词
                if (f[j] && wordDict.contains(s.substring(j, i))) {
                    f[i] = true;
                    break;
                }
            }
        }

        return f[s.length()];
    }
}
