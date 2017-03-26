package Problem201_300;

/**
 * Created by mwindson on 2017/3/26.
 * https://leetcode.com/problems/ugly-number-ii/#/description
 */
public class Problem264 {
    public static void main(String[] args) {
        System.out.println(nthUglyNumber(12));
    }

    /* 分成三个列表
    * 2*1,2*2,2*3,2*4…………
    * 3*1,3*2,3*3,3*4…………
    * 5*1,5*2,5*3,5*4…………
    * 三个列表首位的最小值舍为当前uglyNumber，后删除该列表对应的值
    */
    public static int nthUglyNumber(int n) {
        int[] ugly = new int[n];
        ugly[0] = 1;
        int index2 = 0, index3 = 0, index5 = 0;
        int factor2 = 2, factor3 = 3, factor5 = 5;
        for (int i = 1; i < n; i++) {
            int min = Math.min(Math.min(factor2, factor3), factor5);
            ugly[i] = min;
            if (factor2 == min)
                factor2 = 2 * ugly[++index2];
            if (factor3 == min)
                factor3 = 3 * ugly[++index3];
            if (factor5 == min)
                factor5 = 5 * ugly[++index5];
        }
        return ugly[n - 1];
    }
}
