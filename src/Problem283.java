import java.util.LinkedList;

/**
 * Created by Administrator on 2016/12/14.
 */
public class Problem283 {
    public static void main(String[] args) {
        int[] nums={0,1,0,3,12,0,5,0,7,8,10,0,0,15};
        moveZeroes(nums);
        for(int i=0;i<nums.length;i++) {
            System.out.print(nums[i]+" ");
        }
    }

    public static void moveZeroes(int[] nums) {
        int zeroMinIndex = 0;
        int zeroMaxIndex = 0;
        int tmp=0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]==0){
                zeroMaxIndex=i;
            }else{
                tmp=nums[i];
                nums[i]=nums[zeroMinIndex];
                nums[zeroMinIndex]=tmp;
                zeroMinIndex++;
                zeroMaxIndex=i;
            }
        }
    }
}
