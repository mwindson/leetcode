package Problem001_100;

/**
 * Created by mwindson on 2017/1/27.
 * Question: https://leetcode.com/problems/roman-to-integer/
 */
public class Problem013 {
    public static void main(String[] args) {
        String romanString = "CDXLIV";
        System.out.println(romanToInt(romanString));
    }
// best
//    public int romanToInt(String s) {
//        int sum=0;
//        if(s.indexOf("IV")!=-1){sum-=2;}
//        if(s.indexOf("IX")!=-1){sum-=2;}
//        if(s.indexOf("XL")!=-1){sum-=20;}
//        if(s.indexOf("XC")!=-1){sum-=20;}
//        if(s.indexOf("CD")!=-1){sum-=200;}
//        if(s.indexOf("CM")!=-1){sum-=200;}
//
//        char c[]=s.toCharArray();
//        int count=0;
//
//        for(;count<=s.length()-1;count++){
//            if(c[count]=='M') sum+=1000;
//            if(c[count]=='D') sum+=500;
//            if(c[count]=='C') sum+=100;
//            if(c[count]=='L') sum+=50;
//            if(c[count]=='X') sum+=10;
//            if(c[count]=='V') sum+=5;
//            if(c[count]=='I') sum+=1;
//
//        }
//
//        return sum;
//
//    }
    public static int romanToInt(String s) {
        int number = 0;
        for (int i = 0; i < s.length(); ) {
            switch (s.charAt(i)) {
                case 'M':
                    number += 1000;
                    i++;
                    break;
                case 'D':
                    number += 500;
                    i++;
                    break;
                case 'C':
                    if (i + 1 != s.length()) {
                        if (s.charAt(i + 1) == 'M') {
                            number += 900;
                            i += 2;
                        } else if (s.charAt(i + 1) == 'D') {
                            number += 400;
                            i += 2;
                        } else {
                            number += 100;
                            i++;
                        }
                    } else {
                        number += 100;
                        i++;
                    }
                    break;
                case 'L':
                    number += 50;
                    i++;
                    break;
                case 'X':
                    if (i + 1 != s.length()) {
                        if (s.charAt(i + 1) == 'L') {
                            number += 40;
                            i += 2;
                        } else if (s.charAt(i + 1) == 'C') {
                            number += 90;
                            i += 2;
                        } else {
                            number += 10;
                            i++;
                        }
                    } else {
                        number += 10;
                        i++;
                    }
                    break;
                case 'V':
                    number += 5;
                    i++;
                    break;
                case 'I':
                    if (i + 1 != s.length()) {
                        if (s.charAt(i + 1) == 'V') {
                            number += 4;
                            i += 2;
                        } else if (s.charAt(i + 1) == 'X') {
                            number += 9;
                            i += 2;
                        } else {
                            number += 1;
                            i++;
                        }
                    } else {
                        number += 1;
                        i++;
                    }
                    break;
            }
        }
        return number;
    }
}
