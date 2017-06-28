package Problem301_400;

/**
 * Created by mwindson on 2017/6/27.
 * https://leetcode.com/problems/additive-number/#/description
 */
public class Problem306 {
    public static void main(String[] args) {
        String num = "199100199";
        System.out.println(isAdditiveNumber(num));
    }

    public static boolean isAdditiveNumber(String num) {
        int n = num.length();
        //  遍历所有起始组合对
        for (int i = 1; i <= n / 2; ++i)
            for (int j = 1; Math.max(j, i) <= n - i - j; ++j)
                if (isValid(i, j, num)) return true;
        return false;
    }

    private static boolean isValid(int i, int j, String num) {
        if (num.charAt(0) == '0' && i > 1) return false;
        if (num.charAt(i) == '0' && j > 1) return false;
        String sum;
        // 两个起始数字
        Long x1 = Long.parseLong(num.substring(0, i));
        Long x2 = Long.parseLong(num.substring(i, i + j));
        // 剩余部分循环处理
        for (int start = i + j; start != num.length(); start += sum.length()) {
            // x2+x1->x2
            // old x2->x1
            x2 = x2 + x1;
            x1 = x2 - x1;
            sum = x2.toString();
            // startWith(a,b): b开头部分与a相同
            if (!num.startsWith(sum, start)) return false;
        }
        return true;
    }
}
