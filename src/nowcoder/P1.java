package nowcoder;

public class P1 {
    public static void main() {
        int[][] array = {
                {1, 2, 3, 4},
                {2, 4, 5, 6},
                {4, 10, 13, 14},
                {6, 11, 14, 20}
        };
        int target = 10;
        P1 sol = new P1();
        System.out.println(sol.Find(target, array));
    }

    // 右上角开始查询
    public boolean Find(int target, int[][] array) {
        if (array.length == 0 || array[0].length == 0) {
            return false;
        }
        int m = array.length;
        int n = array[0].length;
        int i = 0, j = n - 1;
        while (i < m && j >= 0) {
            if (target == array[i][j]) {
                return true;
            } else if (target < array[i][j]) {
                j--;
            } else {
                i++;
            }
        }
        return false;
    }
}
