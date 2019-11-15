/**
 * 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组
 * 说明:
 * 1 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
 * 2 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 *
 * 示例：
 * 输入:
 *  nums1 = [1,2,3,0,0,0], m = 3
 *  nums2 = [2,5,6],       n = 3
 * 输出: [1,2,2,3,5,6]
 *
 * 梳理：
 * 两个输入是有序的，要求输出也是有序的；
 * 是归并排序中的归并步骤
 */
public class Solution_88_1 {
    //时间 O(m+n)
    //空间 O(1)
    //双指针+从后向前归并
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        //nums1的末尾元素
        int p1 = m-1;
        //nums2的末尾元素
        int p2 = n-1;
        //nums1的末尾可用空间
        int p = m+n-1;

        //取出nums1[p1],nums2[p2]中的较大值，放到nums1[p]中
        while((p1 >= 0) && (p2 >= 0)) {
            nums1[p--] = nums2[p2] > nums1[p1] ? nums2[p2--] : nums1[p1--];
        }

        //很重要,既可以处理nums1空数组,又可以处理nums2比nums1元素多的情况
        System.arraycopy(nums2, 0, nums1, 0, p2+1);
    }

}
