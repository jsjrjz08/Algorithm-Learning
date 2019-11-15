/**
 * 编写一个函数，以字符串作为输入，反转该字符串中的元音字母。

 示例 1:
 输入: "hello"
 输出: "holle"

 示例 2:
 输入: "leetcode"
 输出: "leotcede"

 说明:
 元音字母不包含字母"y"。

 */
public class Solution_345_1 {
    //时间 O(n)
    //空间 O(1)
    public String reverseVowels(String s) {
        if(s == null || s.length() <= 1) {
            return s;
        }

        //在[i...r]闭区间查找元音字母并做交换处理
        char[] chars = s.toCharArray();
        int l = 0;
        int r = chars.length - 1;

        while(l<r) {
            while(! isVowels(chars[l]) && l<r) {
                l++;
            }
            while(! isVowels(chars[r]) && l<r) {
                r--;
            }
            //交换元音字母
            if(l != r) {
                char tmp = chars[r];
                chars[r] = chars[l];
                chars[l] = tmp;
                l++;
                r--;
            }
        }

        return new String(chars);
    }

    private boolean isVowels(char ch) {
        if(ch == 'a' || ch == 'A') return true;
        if(ch == 'e' || ch == 'E') return true;
        if(ch == 'i' || ch == 'I') return true;
        if(ch == 'o' || ch == 'O') return true;
        if(ch == 'u' || ch == 'U') return true;
        return false;
    }

}
