package Huawei;

import java.util.Scanner;

public class P2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println(getNum("-2.5e-3"));
        String s = in.nextLine();
        Integer numA = null;
        Integer numB = null;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '+') {
                if (i == 0) continue;
                if (s.charAt(i - 1) >= '0' && s.charAt(i - 1) <= '9') {
                    numA = getNum(s.substring(0, i));
                    numB = getNum(s.substring(i + 1));
                    System.out.println(numA + numB);
                }
            } else if (c == '*') {
                numA = getNum(s.substring(0, i));
                numB = getNum(s.substring(i + 1));
                System.out.println(numA * numB);
            } else if (c == '/') {
                numA = Integer.valueOf(s.substring(0, i));
                numB = Integer.valueOf(s.substring(i + 1));
                System.out.println(numA / numB);
            } else if (c == '-') {
                if (i == 0) continue;
                if (s.charAt(i - 1) >= '0' && s.charAt(i - 1) <= '9') {
                    numA = Integer.valueOf(s.substring(0, i));
                    numB = Integer.valueOf(s.substring(i + 1));
                    System.out.println(numA - numB);
                }
            }
        }
    }

    private static int getNum(String s) {
        int index = s.indexOf('e');
        if (index == -1) {
            return Integer.valueOf(s);
        } else {
            String a = s.substring(0, index);
            String b = s.substring(index + 1);
            return (int) (Integer.valueOf(a) * Math.pow(10, Integer.valueOf(b)));
        }
    }

}
