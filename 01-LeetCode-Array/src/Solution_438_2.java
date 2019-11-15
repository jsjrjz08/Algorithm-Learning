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
public class Solution_438_2 {
    //时间 O(n^2)
    //空间 O(1)
    //滑动窗口 ：判断新加入的字符是否为缺少的字符
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> resultLst = new ArrayList<>();
        int pLen = p.length();

        //[left...right) 表示窗口长度,窗口是等长的
        //判断[left...right)内的字符串是否与p为字母异位词，
        for(int right=pLen,left = 0; right<=s.length(); right++,left++) {
            // 如果是，则将left保存到resultLst;
//            if(isAnagrams(s.substring(left,right),p)) {//每次都是整体判断，没有利用滑动窗口的性质
//                resultLst.add(left);
//            }
            // 如果不是，则窗口整体向右滑动一个单位
        }

        return resultLst;
    }

}
