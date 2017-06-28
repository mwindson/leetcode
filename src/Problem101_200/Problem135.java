package Problem101_200;

/**
 * Created by mwindson on 2017/6/28.
 * https://leetcode.com/problems/candy/#/description
 */
public class Problem135 {
    public static void main(String[] args) {
        int[] ratings = {5, 6, 2, 2, 4, 8, 9, 5, 4, 0, 5, 1};
        System.out.println(candy(ratings));
    }

    // two pass
    public static int candy1(int[] ratings) {
        int sum = 0;
        int[] a = new int[ratings.length];
        // [5, 6, 2, 2, 4, 8, 9, 5, 4, 0, 5, 1]
        for (int i = 0; i < a.length; i++) {
            a[i] = 1;
        }
        // [1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1]
        for (int i = 0; i < ratings.length - 1; i++) {
            if (ratings[i + 1] > ratings[i]) {
                a[i + 1] = a[i] + 1;
            }
        }
        // [1, 2, 1, 1, 2, 3, 4, 1, 1, 1, 2, 1]
        for (int i = ratings.length - 1; i > 0; i--) {
            if (ratings[i - 1] > ratings[i]) {
                if (a[i - 1] < (a[i] + 1)) {
                    a[i - 1] = a[i] + 1;
                }
            }
        }
        // [1, 2, 1, 1, 2, 3, 4, 3, 2, 1, 2, 1]
        for (int i = 0; i < a.length; i++) {
            sum += a[i];
        }
        return sum;
    }

    // one pass
    public static int candy(int[] ratings) {
        if (ratings == null || ratings.length == 0) return 0;
        int total = 1, prev = 1, countDown = 0;
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] >= ratings[i - 1]) {
                if (countDown > 0) {
                    total += countDown * (countDown + 1) / 2; // arithmetic progression
                    if (countDown >= prev) total += countDown - prev + 1;
                    countDown = 0;
                    prev = 1;
                }
                prev = ratings[i] == ratings[i - 1] ? 1 : prev + 1;
                total += prev;
            } else countDown++;
        }
        if (countDown > 0) { // if we were descending at the end
            total += countDown * (countDown + 1) / 2;
            if (countDown >= prev) total += countDown - prev + 1;
        }
        return total;
    }
}
