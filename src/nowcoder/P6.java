package nowcoder;

public class P6 {
    public static void main(String[] args) {
        P6 p6 = new P6();
        System.out.println(p6.Fibonacci(0));
    }

    public int Fibonacci(int n) {
        if (n == 0) return 0;
        return helper(n - 1, 0, 1);
    }

    private int helper(int n, int first, int second) {
        if (n == 0) {
            return second;
        }
        return helper(n - 1, second, first + second);
    }
}
