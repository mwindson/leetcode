package Problem101_200;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by mwindson on 2017/6/28.
 * https://leetcode.com/problems/max-points-on-a-line/#/solutions
 */
public class Problem149 {
    static class Point {
        int x;
        int y;

        Point() {
            x = 0;
            y = 0;
        }

        Point(int a, int b) {
            x = a;
            y = b;
        }
    }

    // 如果三点共线，则斜率相同
    // 注意斜率不存在和点重叠
    // 直接保存斜率double精度不够，改为保存分子和分母
    public static void main(String[] args) {
        Point[] points = {new Point(0, 0), new Point(94911151, 94911150), new Point(94911152, 94911151)};
        System.out.println(maxPoints(points));
    }

    public static int maxPoints(Point[] points) {
        if (points == null) return 0;
        if (points.length <= 2) return points.length;

        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        int result = 0;
        for (int i = 0; i < points.length; i++) {
            map.clear();
            int overlap = 0, max = 0;
            for (int j = i + 1; j < points.length; j++) {
                int x = points[j].x - points[i].x;
                int y = points[j].y - points[i].y;
                if (x == 0 && y == 0) {
                    overlap++;
                    continue;
                }
                int gcd = generateGCD(x, y);
                if (gcd != 0) {
                    x /= gcd;
                    y /= gcd;
                }

                if (map.containsKey(x)) {
                    if (map.get(x).containsKey(y)) {
                        map.get(x).put(y, map.get(x).get(y) + 1);
                    } else {
                        map.get(x).put(y, 1);
                    }
                } else {
                    Map<Integer, Integer> m = new HashMap<>();
                    m.put(y, 1);
                    map.put(x, m);
                }
                max = Math.max(max, map.get(x).get(y));
            }
            result = Math.max(result, max + overlap + 1);
        }
        return result;


    }

    private static int generateGCD(int a, int b) {

        if (b == 0) return a;
        else return generateGCD(b, a % b);

    }
}
