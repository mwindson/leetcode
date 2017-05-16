package Problem401_500;

/**
 * Created by mwindson on 2017/5/16.
 * https://leetcode.com/problems/magical-string/#/description
 */
public class Problem481 {
    public static void main(String[] args) {
        System.out.println(magicalString(10));
    }

    public static int magicalString(int n) {
        StringBuilder magic = new StringBuilder("1221121221221121122");
        int pt1 = 12, pt2 = magic.length(), count = 0; //initiate pointers
        // 通过比较最后一位和对应位置的数字生成下一个或两个数字
        while (magic.length() < n) {
            if (magic.charAt(pt1) == '1') {
                if (magic.charAt(pt2 - 1) == '1') magic.append(2);
                else magic.append(1);
                pt2++;
            } else { //==2
                if (magic.charAt(pt2 - 1) == '1') magic.append(22);
                else magic.append(11);
                pt2 += 2;
            }
            pt1++;
        }
        for (int i = 0; i < n; i++)
            if (magic.charAt(i) == '1') count++;
        return count;
    }
}
