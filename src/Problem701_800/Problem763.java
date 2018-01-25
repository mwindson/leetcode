package Problem701_800;

import java.util.ArrayList;
import java.util.List;

/**
 * 763. Partition Labels
 * https://leetcode.com/problems/partition-labels/description/
 *
 * @ tag two pointer
 */
public class Problem763 {
    public static void main(String[] args) {
        String s = "ababcbacadefegdehijhklij";
        System.out.println(partitionLabels(s));
    }

    public static List<Integer> partitionLabels(String S) {
        List<Integer> res = new ArrayList<>();
        int[] last = new int[26];
        int len = S.length();
        char[] sc = S.toCharArray();
        // 记录字母最后出现的位置
        for (int i = 0; i < len; i++) {
            last[sc[i] - 'a'] = i;
        }
        int start = -1, end = -1;
        for (int i = 0; i < len; i++) {
            if (start == -1) start = i;
            // 某个字母的结束点
            end = Math.max(end, last[sc[i] - 'a']);
            if (end == i) {
                res.add(end - start + 1);
                start = -1;
            }
        }
        return res;
    }
}
