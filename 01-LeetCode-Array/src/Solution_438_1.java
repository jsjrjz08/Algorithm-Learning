import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。
 字符串只包含小写英文字母，并且字符串 s 和 p 的长度都不超过 20100。

 说明：
 字母异位词指字母相同，但排列不同的字符串。
 不考虑答案输出的顺序。

 示例 1:
 输入:
 s: "cbaebabacd" p: "abc"
 输出:
 [0, 6]
 解释:
 起始索引等于 0 的子串是 "cba", 它是 "abc" 的字母异位词。
 起始索引等于 6 的子串是 "bac", 它是 "abc" 的字母异位词。

 示例 2:
 输入:
 s: "abab" p: "ab"
 输出:
 [0, 1, 2]
 解释:
 起始索引等于 0 的子串是 "ab", 它是 "ab" 的字母异位词。
 起始索引等于 1 的子串是 "ba", 它是 "ab" 的字母异位词。
 起始索引等于 2 的子串是 "ab", 它是 "ab" 的字母异位词。
 */
public class Solution_438_1 {
    //时间 O(n^2)
    //空间 O(1)
    //暴力解法 -----超出时间限制
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> resultLst = new ArrayList<>();
        int pLen = p.length();

        //[left...right) 表示窗口长度,窗口是等长的
        //判断[left...right)内的字符串是否与p为字母异位词，
        for(int right=pLen,left = 0; right<=s.length(); right++,left++) {
            // 如果是，则将left保存到resultLst;
            if(isAnagrams(s.substring(left,right),p)) {//每次都是整体判断，没有利用滑动窗口的性质
                resultLst.add(left);
            }
            // 如果不是，则窗口整体向右滑动一个单位
        }

        return resultLst;
    }

    //O(n)
    private boolean isAnagrams(String s1,String s2) {
        if(s1 == null || s2 == null || s1.length() != s2.length()) {
            return false;
        }

        List<Character> chs = new ArrayList<>();
        for(int i=0; i<s1.length(); i++) {
            chs.add(s1.charAt(i));
        }

        for(int i=0; i<s2.length(); i++) {
            //如果s2的字符在chs中存在，则从chs中移除该字符
            int index = chs.indexOf(s2.charAt(i));
            if( index != -1) {
                chs.remove(index);
            } else {//否则，返回false
                return false;
            }
        }
        return true;
    }
}
