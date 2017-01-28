package Problem401_500;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mwindson on 2017/1/28.
 * Question: https://leetcode.com/problems/binary-watch/
 */
public class Problem401 {
    public static void main(String[] args) {
        int num = 5;
        System.out.println(readBinaryWatch(num));
    }

    // top:1:{1,2,4,8},2:{3,5,6,9,10,12}.3:{7,11}
    // bottom: 1:{1,2,4,8,16,32} 2:{3,5,6,,10,12,17,18,20,}
    // 2 bit is easy
    public static List<String> readBinaryWatch(int num) {
        List<String> time = new ArrayList<String>();
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 60; j++) {
                if (Integer.bitCount(i) + Integer.bitCount(j) == num) {
                    // Many people got a slow running time like 33ms because they are suing slow io method.(The method "String.format").
                    time.add(String.format(i + ":" + (j < 10 ? "0" + j : j)));
                }
            }
        }
        return time;
    }
}
