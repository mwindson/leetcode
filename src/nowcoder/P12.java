package nowcoder;

public class P12 {
    public double Power(double base, int exponent) {
        if (exponent == 0) return 1;
        if (exponent < 0) return 1 / Power(base, -exponent);
        if (exponent == 1) return base;
        if (exponent % 2 == 0) {
            return Power(base * base, exponent / 2);
        } else {
            return Power(base * base, exponent / 2) * base;
        }
    }
}
