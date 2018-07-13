package Huawei;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class P1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        String[] strs = s.split(" +");
        StringBuilder res = new StringBuilder();
        for (int i = strs.length - 1; i >= 0; i--) {
            res.append(strs[i]);
            if (i > 0) {
                res.append(" ");
            }
        }
        System.out.println(res.toString());
    }
}
