/**
 * 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的[连续]子数组。
 * 如果不存在符合条件的连续子数组，返回 0。

 示例:
 输入: s = 7, nums = [2,3,1,2,4,3]
 输出: 2
 解释: 子数组 [4,3] 是该条件下的长度最小的连续子数组。

 进阶:
 如果你已经完成了O(n) 时间复杂度的解法, 请尝试 O(n log n) 时间复杂度的解法。

 */
public class Solution_209_1 {
    //时间 O(n^2)
    //空间 O(1)
    //暴力解法
    public int minSubArrayLen(int s, int[] nums) {
        int minLen = Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++) {
            int sumTmp = nums[i];
            if(sumTmp >= s) {
                return 1;
            }
            for(int j=i+1;j<nums.length;j++) {
                sumTmp += nums[j];
                if(sumTmp >= s) {
                    minLen = Math.min(j-i+1,minLen);
                }
            }
        }

        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}
