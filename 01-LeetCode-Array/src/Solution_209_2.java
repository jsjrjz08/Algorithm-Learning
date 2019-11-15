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
public class Solution_209_2 {
    //时间 O(n)
    //空间 O(1)
    //滑动窗口
    //1.双指针初始都在数组最左侧,0
    //2.保持左指针不动,移动右指针,并且对左右指针区间的值求和
    //3.判断 区间 和 是否>=s ,小于就继续移动右指针,直到找到一个区间和>=s后
    //  (极限情况就是右指针到了数组末尾后 区间和 == s ),开始进行区间内的判断,
    //  因为右指针指向的值可能会很大,所以需要对左指针的区间进行瘦身保证最小长度
    //4.右指针停住后,开始移动左侧,并且从区间和里移除掉左指针指向的值,一直移动到和<s后 左指针停住,
    //  继续移动右指针.
    //5.用min 来 判断每一次区间的数量大小
    //6.右指针到头的时候 结束并返回长度
    public int minSubArrayLen(int s, int[] nums) {
        int len = nums.length;
        //初始化
        int minLen = len+1;
        int left = 0;
        int sum = 0;//sum表示[l...r]区间的元素之和

        for(int right=0; right<len; right++) {
            sum += nums[right];

            //找到符合条件的最小 子数组
            while(sum >= s) {
                minLen = Math.min(minLen, right-left+1);
                sum -= nums[left];
                left ++;
            }
        }

        return minLen == len+1 ? 0 : minLen;
    }
}
