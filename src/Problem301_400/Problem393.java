package Problem301_400;

/**
 * Created by mwindson on 2017/5/18.
 * https://leetcode.com/problems/utf-8-validation/#/description
 */
public class Problem393 {
    public static void main(String[] args) {
        int[] data = {524, 197, 130, 197};
        System.out.println(validUtf8(data));
    }

    public static boolean validUtf8(int[] data) {
        // 0代表未知;
        // UTF-8格式1中间态:无，
        // UTF-8格式2中间态:1,
        // UTF-8格式3中间态:2,3,
        // UTF-8格式4中间态:4,5,6,
        int type = 0;
        boolean valid = true;
        for (int i = 0; i < data.length; i++) {
            StringBuilder binaryCode = new StringBuilder(Integer.toBinaryString(data[i]));
            int len = binaryCode.length();
            if (len <= 8) {
                for (int j = 0; j < 8 - len; j++) {
                    binaryCode.insert(0, '0');
                }
            } else {
                binaryCode = new StringBuilder(binaryCode.substring(len - 8, len));
            }
            System.out.println(binaryCode);
            switch (type) {
                case 0:
                    if (binaryCode.charAt(0) == '0') {
                        type = 0;
                    } else if (binaryCode.indexOf("110") == 0) {
                        type = 1;
                    } else if (binaryCode.indexOf("1110") == 0) {
                        type = 2;
                    } else if (binaryCode.indexOf("11110") == 0) {
                        type = 4;
                    } else {
                        valid = false;
                    }
                    break;
                case 1:
                    if (binaryCode.indexOf("10") == 0) {
                        type = 0;
                    } else {
                        valid = false;
                    }
                    break;
                case 2:
                    if (binaryCode.indexOf("10") == 0) {
                        type = 3;
                    } else {
                        valid = false;
                    }
                    break;
                case 3:
                    if (binaryCode.indexOf("10") == 0) {
                        type = 0;
                    } else {
                        valid = false;
                    }
                    break;
                case 4:
                    if (binaryCode.indexOf("10") == 0) {
                        type = 5;
                    } else {
                        valid = false;
                    }
                    break;
                case 5:
                    if (binaryCode.indexOf("10") == 0) {
                        type = 6;
                    } else {
                        valid = false;
                    }
                    break;
                case 6:
                    if (binaryCode.indexOf("10") == 0) {
                        type = 0;
                    } else {
                        valid = false;
                    }
                    break;
                default:

            }
            if (!valid) return false;
        }
        return type == 0;
    }
}
