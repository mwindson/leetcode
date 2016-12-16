package Problem401_500;

/**
 * Created by Administrator on 2016/12/16.
 */
public class Problem409 {
    public static void main(String[] args){
        String s="abccccdd";
        System.out.print(longestPalindrome(s));
    }
    public static int longestPalindrome(String s) {
        int maxPalindromeLength=1;
        int index=0;
        while (index<s.length()){
            for(int length=maxPalindromeLength;length+index<s.length();length++){
                String substring1=s.substring(index,index+length);
                String substring2=s.substring(s.length()-index-length,s.length()-index);
                if(substring1.equals(substring2)){
                    maxPalindromeLength=length;
                }else{
                    break;
                }
            }
            index++;
        }

        return maxPalindromeLength;
    }
}
