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
public class Solution_3_1 {

    //时间 O(n^2)
    //空间 O(1)
    //暴力解法
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

        for(int i=0; i<chars.length; i++) {
            int tmpMaxLen = 0;
            for(int j=i; j<chars.length; j++) {
                if(freq[chars[j]%256] != 1) {//不存在，则添加
                    freq[chars[j]%256] = 1;
                    tmpMaxLen = Math.max(tmpMaxLen, j-i+1);
                    maxLen = Math.max(tmpMaxLen,maxLen);
                } else {
                    maxLen = Math.max(tmpMaxLen,maxLen);
                    freq = new int[256];
                    break;
                }
            }
        }

        return maxLen;
    }
}
