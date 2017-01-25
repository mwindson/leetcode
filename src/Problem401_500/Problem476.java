package Problem401_500;

/**
 * Created by mwindson on 2017/1/25.
 */
public class Problem476 {
    public static void main(String[] args) {
        int num = 5;
        System.out.println(findComplement(num));
    }

    public static int findComplement(int num) {
        return ~num & ((Integer.highestOneBit(num) << 1) - 1);
    }
}
