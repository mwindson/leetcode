package Problem401_500;

import java.util.HashMap;

/**
 * Created by mwindson on 2017/3/27.
 * https://leetcode.com/problems/number-of-boomerangs/#/description
 */
public class Problem447 {
    public static void main(String[] args) {
        int[][] points = {{0, 0}, {1, 0}, {2, 0}};
        System.out.println(numberOfBoomerangs(points));
    }

    public static int numberOfBoomerangs(int[][] points) {
        int boomerangsNum = 0;
        for (int i = 0; i < points.length; i++) {
            HashMap<Integer, Integer> boomerangs = new HashMap<>();
            for (int j = 0; j < points.length; j++) {
                int dis = (int) (Math.pow(points[i][0] - points[j][0], 2) + Math.pow(points[i][1] - points[j][1], 2));
                if (boomerangs.containsKey(dis))
                    boomerangs.replace(dis, boomerangs.get(dis) + 1);
                else
                    boomerangs.put(dis, 1);
            }
            for (Integer value : boomerangs.values()) {
                boomerangsNum += value * (value - 1);
            }
        }

        return boomerangsNum;
    }
}
