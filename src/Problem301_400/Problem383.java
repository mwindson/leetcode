package Problem301_400;

/**
 * Created by Administrator on 2016/12/14.
 */
public class Problem383 {
    public static void main(String[] args) {
        String ransomNote = "aaaaa";
        String magazine = "aaabaa";
        System.out.print(canConstruct(ransomNote, magazine));
    }

    //    public static boolean canConstruct(String ransomNote, String magazine) {
//        StringBuilder sb1 = new StringBuilder(ransomNote);
//        StringBuilder sb2 = new StringBuilder(magazine);
//        int index=0;
//        for (int i = 0; i < ransomNote.length(); i++) {
//            index=sb2.indexOf(Character.toString(ransomNote.charAt(i)));
//            if (index>=0){
//                sb2.deleteCharAt(index);
//            }else{
//                return false;
//            }
//        }
//        return true;
//    }
    public static boolean canConstruct(String ransomNote, String magazine) {
        int[] arr = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            arr[magazine.charAt(i) - 'a']++;
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            if (--arr[ransomNote.charAt(i) - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }
}
