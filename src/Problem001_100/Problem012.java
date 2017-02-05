package Problem001_100;

/**
 * Created by mwindson on 2017/2/5.
 * Question: https://leetcode.com/problems/integer-to-roman/
 */
public class Problem012 {
    public static void main(String[] args) {
        int num = 555;
        System.out.println(intToRoman(num));
    }

    public static String intToRoman(int num) {
        String RomanString = "";
        while (num >= 1000) {
            RomanString += "M";
            num -= 1000;
        }
        if (num < 1000 && num >= 900) {
            RomanString += "CM";
            num -= 900;
        }
        while (num >= 500) {
            RomanString += "D";
            num -= 500;
        }
        if (num < 500 && num >= 400) {
            RomanString += "CD";
            num -= 400;
        }
        while (num >= 100) {
            RomanString += "C";
            num -= 100;
        }
        if (num < 100 && num >= 90) {
            RomanString += "XC";
            num -= 90;
        }
        while (num >= 50) {
            RomanString += "L";
            num -= 50;
        }
        if (num < 50 && num >= 40) {
            RomanString += "XL";
            num -= 40;
        }
        while (num >= 10) {
            RomanString += "X";
            num -= 10;
        }
        if (num < 10 && num >= 9) {
            RomanString += "IX";
            num -= 9;
        }
        while (num >= 5) {
            RomanString += "V";
            num -= 5;
        }
        if (num < 5 && num >= 4) {
            RomanString += "IV";
            num -= 4;
        }
        while (num >= 1) {
            RomanString += "I";
            num -= 1;
        }
        return RomanString;
    }
}
