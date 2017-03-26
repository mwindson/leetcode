package Problem301_400;

/**
 * Created by mwindson on 2017/3/26.
 * https://leetcode.com/problems/bulb-switcher/#/description
 */
public class Problem319 {
    public static void main(String[] args) {
        System.out.println(bulbSwitch(16));
    }

    // 相当于计算每个数字的因数个数(包括1和本身),发现只有平方数满足奇数次操作为亮
    public static int bulbSwitch(int n) {
        int i = 1;
        while (n - i * i >= 0) {
            i++;
        }
        return i - 1;
    }
}
