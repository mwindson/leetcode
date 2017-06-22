package Problem201_300;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mwindson on 2017/6/22.
 * https://leetcode.com/problems/expression-add-operators/#/description
 */
public class Problem282 {
    public static void main(String[] args) {
        String num = "105";
        int target = 5;
        System.out.println(addOperators(num, target));
    }

    public static List<String> addOperators(String num, int target) {
        List<String> list = new ArrayList<>();
        if (num.length() == 0) return list;
        helper(list, "", num, target, 0, 0, 0);
        return list;
    }

    private static void helper(List<String> rst, String path, String num, int target, int pos, long eval, long multed) {
        if (pos == num.length()) {
            if (eval == target)
                rst.add(path);
        } else {
            for (int i = pos; i < num.length(); i++) {
                // 排除0122这种数字的情况
                if (i != pos && num.charAt(pos) == '0') break;
                long cur = Long.parseLong(num.substring(pos, i + 1));
                if (pos == 0) {
                    helper(rst, path + cur, num, target, i + 1, cur, cur);
                } else {
                    helper(rst, path + '+' + cur, num, target, i + 1, eval + cur, cur);
                    helper(rst, path + '-' + cur, num, target, i + 1, eval - cur, -cur);
                    helper(rst, path + '*' + cur, num, target, i + 1, eval - multed + multed * cur, multed * cur);
                }
            }
        }
    }
}
