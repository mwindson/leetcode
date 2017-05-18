package Problem301_400;

/**
 * Created by mwindson on 2017/5/18.
 * https://leetcode.com/problems/maximum-product-of-word-lengths/#/description
 */
public class Problem318 {
    public static void main(String[] args) {
        String[] words = {"abcw", "baz", "foo", "bar", "xtfn", "abcdef"};
        System.out.println(maxProduct(words));
    }

    public static int maxProduct(String[] words) {
        if (words == null || words.length == 0)
            return 0;
        int len = words.length;
        int[] value = new int[len];
        for (int i = 0; i < len; i++) {
            String tmp = words[i];
            value[i] = 0;
            /** 每一个字符串转化为对应的数值之和，a-z对应2的0-25次方
             *  如 abcw=>2^0+2^1+2^3+2^22=4194311
             *  因此两个不同值必对应两个不同的字符串
             */
            for (int j = 0; j < tmp.length(); j++) {
                value[i] |= 1 << (tmp.charAt(j) - 'a');
            }
        }
        int maxProduct = 0;
        for (int i = 0; i < len; i++)
            for (int j = i + 1; j < len; j++) {
                if ((value[i] & value[j]) == 0 && (words[i].length() * words[j].length() > maxProduct))
                    maxProduct = words[i].length() * words[j].length();
            }
        return maxProduct;
    }
}
