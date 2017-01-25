package Problem401_500;

/**
 * Created by mwindson on 2017/1/25.
 */
public class Problem492 {
    public static void main(String[] args) {
        int area = 3;
        System.out.println(constructRectangle(area));
    }

    public static int[] constructRectangle(int area) {
        int[] result = new int[2];
        if (area == 0) {
            return result;
        }
        int a = (int) Math.sqrt(area);
        while (area % a != 0) {
            a--;
        }
        int b = area / a;
        result[0] = b;
        result[1] = a;
        return result;
    }
//    public static int[] constructRectangle(int area) {
//        double areaDouble = area;
//        int base = (int) Math.sqrt(areaDouble);
//        int W = base, L = base;
//        for (int i = 0; i < area; i++) {
//            L = base + i;
//            if (area % L == 0) {
//                W = area / L;
//                if (W <= L) break;
//            }
//        }
//        int[] nums = {L, W};
//        return nums;
//    }
}
