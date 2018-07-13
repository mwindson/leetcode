package nowcoder;

public class P47 {
    public static void main(String[] args) {
        P47 p = new P47();
        System.out.println(p.Sum_Solution(1));
        System.out.println(p.Sum_Solution(5));
        System.out.println(p.Sum_Solution(10));
        System.out.println(p.Sum_Solution(15));
    }

    public int Sum_Solution(int n) {
        int sum = n;
        boolean flag = n > 0 && (sum += Sum_Solution(--n)) > 0;
        return sum;
    }
}
