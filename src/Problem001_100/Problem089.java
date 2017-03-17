package Problem001_100;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mwindson on 2017/3/17.
 * https://leetcode.com/problems/gray-code/#/description
 */
public class Problem089 {
    public static void main(String[] args) {
        System.out.println(grayCode(3));
    }


    // 00,01,11,10 -> (000,001,011,010 ) (110,111,101,100). n=3 based on b=2
    public static List<Integer> grayCode(int n) {
        List<Integer> rs = new ArrayList<Integer>();
        rs.add(0);
        for (int i = 0; i < n; i++) {
            int size = rs.size();
            for (int k = size - 1; k >= 0; k--)
                rs.add(rs.get(k) | 1 << i);
        }
        return rs;
    }
}
