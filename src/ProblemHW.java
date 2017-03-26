/**
 * Created by mwindson on 2017/3/24.
 */
// 华为java笔试题，翻骰子
public class ProblemHW {
    public static void main(String[] args) {
        System.out.println(transfrom("RA"));
    }

    public static int[] transfrom(String s) {
        // 左，右，前，后，上，下
        int[] nums = {1, 2, 3, 4, 5, 6};
        for (int i = 0; i < s.length(); i++) {
            int tmp = 0;
            switch (s.charAt(i)) {
                case 'L':
                    tmp = nums[5];
                    nums[5] = nums[0];
                    nums[0] = nums[4];
                    nums[4] = nums[1];
                    nums[1] = tmp;
                    break;
                case 'R':
                    tmp = nums[5];
                    nums[5] = nums[1];
                    nums[1] = nums[4];
                    nums[4] = nums[0];
                    nums[0] = tmp;
                    break;
                //向前
                case 'F':
                    tmp = nums[5];
                    nums[5] = nums[2];
                    nums[2] = nums[4];
                    nums[4] = nums[3];
                    nums[3] = tmp;
                    break;
                //向后
                case 'B':
                    tmp = nums[5];
                    nums[5] = nums[3];
                    nums[3] = nums[4];
                    nums[4] = nums[2];
                    nums[2] = tmp;
                    break;
                //逆时针
                case 'A':
                    tmp = nums[2];
                    nums[2] = nums[0];
                    nums[0] = nums[3];
                    nums[3] = nums[1];
                    nums[1] = tmp;
                    break;
                //顺时针
                case 'C':
                    tmp = nums[2];
                    nums[2] = nums[1];
                    nums[1] = nums[3];
                    nums[3] = nums[0];
                    nums[0] = tmp;
                    break;
            }
        }
        return nums;
    }
}
