package Problem401_500;

/**
 * Created by mwindson on 2017/3/22.
 * https://leetcode.com/problems/teemo-attacking/#/description
 */
public class Problem495 {
    public static void main(String[] args) {
        int[] timeSerie = {1, 2, 4, 5, 7, 8};
        int duration = 2;
        System.out.println(findPoisonedDuration(timeSerie, duration));
    }

    public static int findPoisonedDuration(int[] timeSeries, int duration) {
        if (timeSeries.length == 0)
            return 0;
        int totalTime = 0;
        for (int i = 1; i < timeSeries.length; i++)
            totalTime += (timeSeries[i] - timeSeries[i - 1]) >= duration ? duration : timeSeries[i] - timeSeries[i - 1];
        return totalTime + duration;
    }
}
