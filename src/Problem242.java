/**
 * Created by Administrator on 2016/12/15.
 */
public class Problem242 {
    public static void main(String[] args){
        String s="ab";
        String t="b";
        System.out.println(isAnagram(s,t));
    }
    public static boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()) return false;
        int[] character=new int[26];
        for(int i=0;i<s.length();i++){
            character[s.charAt(i)-'a']++;
        }
        for(int j=0;j<t.length();j++){
            if(--character[t.charAt(j)-'a']<0){
                return false;
            };
        }
        return true;
    }
}
