import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created by mwindson on 2017/3/30.
 */
public class ProblemTouTiao4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int q = in.nextInt();
        int[] listA = new int[n];
        int[] listB = new int[n];
        for (int i = 0; i < n; i++) {
            listA[i] = in.nextInt();
        }
        for (int i = 0; i < n; i++) {
            listB[i] = in.nextInt();
        }
        while (q >= 0) {
            int x = in.nextInt();
            int y = in.nextInt();
            int count = 0;
            for (int i = 0; i < n; i++) {
                if (listA[i] >= x && listB[i] >= y)
                    count++;
            }
            System.out.println(count);
            q--;
        }
    }
}
