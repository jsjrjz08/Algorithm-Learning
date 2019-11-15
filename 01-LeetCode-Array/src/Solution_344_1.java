/**
 * 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 char[] 的形式给出。

 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
 你可以假设数组中的所有字符都是 ASCII 码表中的可打印字符。

 示例 1：
 输入：["h","e","l","l","o"]
 输出：["o","l","l","e","h"]

 示例 2：
 输入：["H","a","n","n","a","h"]
 输出：["h","a","n","n","a","H"]

 */
public class Solution_344_1 {
    //时间 O(n)
    //空间 O(1)
    public void reverseString(char[] s) {
        int len = s.length;
        if(len == 0 || len == 1) {
            return;
        }

        //在[l...r]闭区间内，原地交换字符
        int l = 0;
        int r = len-1;
        while(l<r) {//l==r不需要交换操作了
            char tmp = s[r];
            s[r] = s[l];
            s[l] = tmp;
            l++;
            r--;
        }
    }
}
