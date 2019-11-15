/**
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。

 说明：本题中，我们将空字符串定义为有效的回文串。

 示例 1:
 输入: "A man, a plan, a canal: Panama"
 输出: true

 示例 2:
 输入: "race a car"
 输出: false

 */
public class Solution_125_1 {
    //时间 O(n)
    //空间 O(1)
    public boolean isPalindrome(String s) {
        if(s == null  ) {
            return true;
        }
        //通过正则，提前过滤出需要处理的数字和字母
        char[] chs = s.toLowerCase().replaceAll("[^A-Za-z0-9]","").toCharArray();//统一小写

        //在[l...r]闭区间查找并比较字母和数字
        int l = 0;
        int r = chs.length-1;

        //判断两个指针所指字符是否相等 l == r意味着指向同一个字符，当然相等了，所以，不用进入循环了
        while(l < r) {
            if(chs[l] != chs[r]) {
                return false;
            }

            l++;
            r--;
        }
        return true;
    }

}
