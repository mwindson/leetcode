package Problem600_700;

import java.util.*;

/**
 * Created by mwindson on 2017/7/3.
 * https://leetcode.com/problems/design-excel-sum-formula/#/description
 */
public class Problem631 {
    public static void main(String[] args) {
        Excel obj = new Excel(26, 'Z');
        obj.set(1, 'A', 1);
        obj.set(1, 'I', 1);
        System.out.println(obj.sum(7, 'D', new String[]{"A1:D6", "A1:G3", "A1:C12"}));
        System.out.println(obj.sum(10, 'G', new String[]{"A1:D7", "D1:F10", "D3:I8", "I1:I9"}));
        obj.set(5, 'A', 10);
        System.out.println(obj.get(7, 'D'));
        System.out.println(obj.get(10, 'G'));
//        System.out.println(obj.sum(3, 'C', new String[]{"A1:C1", "A1:A5"}));
//        obj.set(3, 'A', 3);
//        System.out.println(obj.get(1, 'B'));
//        System.out.println(obj.get(1, 'C'));
//        System.out.println(obj.get(3, 'C'));
//        System.out.println(obj.get(5, 'A'));
    }

    public static class Excel {
        int[][] excel;
        Map<String, List<String>> sumMap;

        public Excel(int H, char W) {
            excel = new int[H][W - 'A' + 1];
            sumMap = new TreeMap<>();
        }

        public void set(int r, char c, int v) {
            excel[r - 1][c - 'A'] = v;
            // 清除对应公式
            if (sumMap.containsKey(String.valueOf(c) + r)) {
                sumMap.remove(String.valueOf(c) + r);
            }
            // need to calculate again ?
            Queue<String> queue = new ArrayDeque<>();
            queue.add(String.valueOf(c) + r);
            while (!queue.isEmpty()) {
                String curr = queue.poll();
                for (String s : sumMap.keySet()) {
                    if (sumMap.get(s).contains(curr)) {
                        int sum = 0;
                        for (String l : sumMap.get(s))
                            sum += excel[Integer.valueOf(l.substring(1)) - 1][l.charAt(0) - 'A'];
                        excel[Integer.valueOf(s.substring(1)) - 1][s.charAt(0) - 'A'] = sum;
                        queue.add(s);
                    }
                }
            }
        }

        public int get(int r, char c) {
            return excel[r - 1][c - 'A'];
        }

        public int sum(int r, char c, String[] strs) {
            int sum = 0;
            List<String> cells = new ArrayList<>();
            for (String str : strs) {
                // A1
                if (str.indexOf(':') == -1) {
                    sum += excel[Integer.valueOf(str.substring(1)) - 1][str.charAt(0) - 'A'];
                    cells.add(str);
                } else {
                    String[] s = str.split(":");
                    for (int i = Integer.valueOf(s[0].substring(1)); i <= Integer.valueOf(s[1].substring(1)); i++) {
                        for (char j = s[0].charAt(0); j <= s[1].charAt(0); j++) {
                            sum += excel[i - 1][j - 'A'];
                            cells.add(String.valueOf(j) + i);
                        }
                    }
                }
            }
            sumMap.put(String.valueOf(c) + r, cells);
            excel[r - 1][c - 'A'] = sum;
            return sum;
        }
    }
}
