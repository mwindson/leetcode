package nowcoder;

public class P48 {
    public static void main(String[] args) {
        int num1 = 156, num2 = 279;
        P48 p = new P48();
        System.out.println(p.Add(num1, num2));
    }

    public int Add(int num1, int num2) {
        int sum, carry;
        do {
            sum = num1 ^ num2;
            carry = (num1 & num2) << 1; // 产生进位后，位数会左移一次
            num1 = sum;
            num2 = carry;
        } while (num2 != 0);

        return num1;
    }
}
