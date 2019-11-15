import java.util.Arrays;

/**
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 * 示例 1:
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 *
 * 梳理：
 *
 *
 */
public class Solution_215_1 {

    //时间 O(nlogn)
    //空间 O(1)
    //暴力解法：降序排序后，找到第k大的元素
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);//快排-升序
        return nums[nums.length-k];
    }
}
