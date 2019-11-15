/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 示例 1:
 输入: "abcabcbb"
 输出: 3
 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。

 示例 2:
 输入: "bbbbb"
 输出: 1
 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。

 示例 3:
 输入: "pwwkew"
 输出: 3
 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 */
public class Solution_3_2 {

    //时间 O(n)
    //空间 O(1)
    //滑动窗口
    public int lengthOfLongestSubstring(String s) {
        if(s == null) {
            return -1;
        }
        if( s.length() <= 1) {
            return s.length();
        }

        int maxLen = -1;
        char[] chars = s.toCharArray();
        int[] freq = new int[256];//默认 0。0：未出现过; 1:出现过

        //[left...right]表示不含有重复字符的子串区间。初始状态没有字符
        int left = 0;
        int right = -1;

        while(left < chars.length) {
            if(right+1 < chars.length && freq[chars[right+1]%256] != 1) {//不存在
                right++;
                freq[chars[right]%256] = 1;
                maxLen = Math.max(maxLen, right-left +1);
            } else {
                freq[chars[left]%256] = 0;
                left++;
            }
        }

        return maxLen;
    }
}
